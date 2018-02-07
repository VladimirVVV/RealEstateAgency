package com.emm.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by vladimir on 12.04.2016.
 */
public abstract class AbstractEntityDAO extends JdbcDaoSupport {
    public AbstractEntityDAO(DataSource dataSource) {
        setDataSource(dataSource);
    }
}
