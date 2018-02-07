

-- DROP DATABASE agency;
--drop SEQUENCE nxt_user_ids;
--drop SEQUENCE nxt_real_estate_ids;
--drop SEQUENCE nxt_estate_show_ids;

--DROP TABLE estate_show;
--DROP TABLE real_estate;
--DROP TABLE  users;



CREATE DATABASE agency
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;

CREATE SEQUENCE nxt_user_ids;

CREATE TABLE users (
  id bigint PRIMARY KEY DEFAULT NEXTVAL('nxt_user_ids'),
  surname VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  patr VARCHAR(255) NOT NULL
);

CREATE SEQUENCE nxt_real_estate_ids;

CREATE TABLE real_estate
(
  id bigint  PRIMARY KEY DEFAULT NEXTVAL('nxt_real_estate_ids'),
  addr VARCHAR(255) not null,
  user_id bigint not null,
  CONSTRAINT FK_REAL_EST_TO_USER FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
 );



CREATE SEQUENCE nxt_estate_show_ids;
CREATE TABLE estate_show
(
  id bigint PRIMARY KEY DEFAULT NEXTVAL('nxt_estate_show_ids'),
  client_name VARCHAR(255),
  client_patr VARCHAR(255),
  client_phone VARCHAR(255),
  client_surname VARCHAR(255),
  meeting_time timestamp without time zone,
  estate_id bigint not null,
  UNIQUE (estate_id, meeting_time),
  CONSTRAINT FK_EST_SHOW_TO_REAL_EST FOREIGN KEY (estate_id)
      REFERENCES real_estate (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


insert into users(surname, name, patr) values('Марычев', 'Иван', 'Иванович');
insert into users(surname, name, patr) values('Иванов', 'Петр', 'Иванович');
insert into users(surname, name, patr) values('Петров', 'Андрей', 'Алексеевич');

insert into real_estate(addr, user_id) values('Киев, пр. Шурика 10,д.11 ', 3);
insert into real_estate(addr, user_id) values('Киев, ул. Кленовая 14,д.7 ', 1);
insert into real_estate(addr, user_id) values('Киев, ул. Зеленая 9а,д.5 ', 2);

insert into estate_show(client_surname, client_name, client_patr, client_phone, estate_id, meeting_time) values('Марычев', 'Иван', 'Иванович', '0994557777', 2, '2016-11-01 14:04');
insert into estate_show(client_surname, client_name, client_patr, client_phone, estate_id, meeting_time) values('Иванов', 'Петр', 'Иванович', '0958664455', 2, '2016-11-01 14:24');
insert into estate_show(client_surname, client_name, client_patr, client_phone, estate_id, meeting_time) values('Петров', 'Андрей', 'Алексеевич', '0667775533',3,'2016-11-01 14:04');

