package com.emm.services.impl;

import com.emm.dao.AccountDao;
import com.emm.entities.Account;
import com.emm.entities.Client;
import com.emm.services.AccountService;
import com.emm.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 11.02.2018.
 */
@Service("showAccounts")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public List<Account> list() {
        return dao.findAll();
    }

    @Override
    public List<Map<String, String>> accountInfoList() {
        return dao.accountInfoList();
    }
}

