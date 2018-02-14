package com.emm.dao.impl;

import com.emm.dao.ClientDao;
import com.emm.entities.Client;
import com.emm.entities.SexType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 07.02.2018.
 */
@Service
public class ClientDaoImpl extends AbstractEntityDAO implements ClientDao {
    @Autowired
    public ClientDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = getJdbcTemplate().
                query("SELECT * FROM client",
                        new ClientMapper()
                );
        return clients;
    }

    @Override
    public List<Map<String, String>> clientInfoList() {
        List<Map<String, String>> clients = getJdbcTemplate().
                query("SELECT id, name, surname, email, age, sex, acc_qty," +
                                " total_balance FROM v_client_info",
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

        return clients;
    }

    @Override
    public void insert(Client client) {
        getJdbcTemplate().update(
                "INSERT INTO client (surname, name, email, birth_date, sex) VALUES (?, ?)",
                new Object[]{
                        client.getSurname(),
                        client.getName(),
                        client.getEmail(),
                        client.getBirthDate(),
                        client.getSex().index()
                }
        );
    }

    @Override
    public void update(Client client) {
        getJdbcTemplate().update(
                "update client set surname = ?, name = ?, email = ?, birth_date = ?, sex = ? where id = ?",
                new Object[]{
                        client.getSurname(),
                        client.getName(),
                        client.getEmail(),
                        client.getBirthDate(),
                        client.getSex().index(),
                        client.getId()
                });
    }

    @Override
    public void delete(Long id) {
        getJdbcTemplate().update(
                "delete from client where id = ?",
                new Object[]{id});
    }

    private class ClientMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Client client = new Client();
            client.setId(rs.getLong("ID"));
            client.setName(rs.getString("name"));
            client.setSurname(rs.getString("surname"));
            client.setEmail(rs.getString("email"));
            client.setBirthDate(rs.getDate("birth_date"));
            client.setSex(SexType.getById(rs.getInt("sex")));

            return client;
        }
    }
}
