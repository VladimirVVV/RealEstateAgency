package com.emm.services;

import com.emm.entities.Client;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface ClientService {
    boolean create(Client client);
    List<Client> list();
    List<Map<String, String>> clientInfoList();
}
