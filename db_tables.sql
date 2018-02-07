DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  surname VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  birth_date DATE NOT NULL,
  sex INT(1) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  client_id BIGINT(20) NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  balance BIGINT(20) NOT NULL DEFAULT '0',
  active INT(1) NOT NULL DEFAULT 1,
  block_dt DATETIME,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES `client`(id)
  ON DELETE CASCADE 
);
-------------------------------------------------------------------------
DROP VIEW IF EXISTS v_account_info;
CREATE VIEW v_account_info(client_id, acc_qty, total_balance) AS
SELECT
	client_id, COUNT(1) acc_qty, SUM(balance) total_balance
FROM
	account
WHERE
	active =1
GROUP BY client_id;

DROP VIEW IF EXISTS v_client_info;
CREATE VIEW v_client_info(id, `name`, surname, email, age, sex, acc_qty, total_balance) AS
SELECT
	c.id, c.name, c.surname, c.email,
	FLOOR(DATEDIFF(CURRENT_DATE, c.birth_date)/365) AS age,
	sex, acc.acc_qty, acc.total_balance
FROM
	`client` c,
	v_account_info acc
WHERE
	c.id = acc.client_id;

DROP VIEW IF EXISTS v_client_account_list;
CREATE VIEW v_client_account_list(client_id, `name`, surname, email, created, account_id, balance, active, block_dt) AS
SELECT
	c.id client_id, c.name, c.surname, c.email,
	acc.created, acc.id account_id,
	acc.balance, acc.active,
	acc.block_dt
FROM
	`client` c
LEFT JOIN
	account acc
ON c.id = acc.client_id
WHERE
	c.id = acc.client_id;



-------------------------------------------------------------------------
INSERT INTO CLIENT(id, surname, `name`, email, birth_date, sex)
VALUES(1, 'Doe', 'John', 'john@gmail.com', STR_TO_DATE('10-12-1980','%d-%m-%Y'), 1);
INSERT INTO CLIENT(id, surname, `name`, email, birth_date, sex)
VALUES(2, 'Joanna', 'Middlestone', 'joanna@gmail.com', STR_TO_DATE('10-04-1991','%d-%m-%Y'), 0);
INSERT INTO CLIENT(id, surname, `name`, email, birth_date, sex)
VALUES(3, 'Kate', 'Richardson', 'kate@gmail.com', STR_TO_DATE('10-04-1989','%d-%m-%Y'), 0);

COMMIT;


INSERT INTO account(client_id, balance)
VALUES(1, 400);
INSERT INTO account(client_id, balance)
VALUES(1, 700);

INSERT INTO account(client_id, balance)
VALUES(2, 7000);

INSERT INTO account(client_id, balance)
VALUES(3, 9020);
COMMIT;

