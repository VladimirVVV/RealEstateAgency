package com.emm.dao.impl;

import com.emm.dao.AccountDao;
import com.emm.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 11.02.2018.
 */
public class AccountDaoImpl extends AbstractEntityDAO implements AccountDao {
    @Autowired
    public AccountDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = getJdbcTemplate().
                query("SELECT * FROM account",
                        new AccountMapper()
                );
        return accounts;
    }

    @Override
    public List<Map<String, String>> accountInfoList() {
        List<Map<String, String>> accounts = getJdbcTemplate().
                query("SELECT * FROM account",
                        (resultSet, j) -> {
                            ResultSetMetaData meta = resultSet.getMetaData();
                            Map map = new HashMap();
                            for (int i = 1; i <= meta.getColumnCount(); i++) {
                                String key = meta.getColumnName(i);
                                String value = resultSet.getString(key);
                                map.put(key, value);
                            }

                            return map;
                        }
                );

        return accounts;
    }

    private class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setClientId(rs.getLong("name"));
            account.setCreated(rs.getDate("created"));
            account.setBalance(rs.getInt("balance"));
            account.setBlockDate(rs.getDate("block_date"));
            account.setActive(rs.getBoolean("sex"));

            return account;
        }
    }
}
