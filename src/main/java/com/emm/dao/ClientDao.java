package com.emm.dao;

import com.emm.entities.Client;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 07.02.2018.
 */
public interface ClientDao {
    List<Client> findAll();
    List<Map<String, String>> clientInfoList();
    void insert(Client client);
    void update(Client client);
}
