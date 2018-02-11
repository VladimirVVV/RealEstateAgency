package com.emm.dao;

import com.emm.entities.Account;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 11.02.2018.
 */
public interface AccountDao {
    List<Account> findAll();
    List<Map<String, String>> accountInfoList();
}
