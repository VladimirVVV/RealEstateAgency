package com.emm.services.impl;

import com.emm.dao.ClientDao;
import com.emm.entities.Client;
import com.emm.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Service("showClient")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao dao;

    //  @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Transactional
    @Override
    public boolean create(Client client) {
        dao.insert(client);
        return true;
    }

    @Override
    public List<Client> list() {
        return dao.findAll();
    }
}
