package com.emm.services;

import com.emm.entities.Client;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface ClientService {
    boolean create(Client client);
    List<Client> list();
}
