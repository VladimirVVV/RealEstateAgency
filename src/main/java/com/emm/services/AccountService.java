package com.emm.services;

import com.emm.entities.Account;

import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 11.02.2018.
 */
public interface AccountService {
    List<Account> list();
    List<Map<String, String>> accountInfoList();
}
