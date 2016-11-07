package com.agency.dao.impl;

import com.agency.dao.EstateShowDao;
import com.agency.entities.EstateShow;
import com.agency.entities.RealEstate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Service
public class EstateShowDaoImpl extends AbstractEntityDAO<EstateShow> implements EstateShowDao {
    @Override
    protected Class<EstateShow> getEntityClass() {
        return EstateShow.class;
    }

    public List<EstateShow> findBy(RealEstate realEstate, Date meetingTimeStart, Date meetingDateEnd) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("realEstate", realEstate));
        criteria.add(Restrictions.between("meetingTime", meetingTimeStart, meetingDateEnd));

        return criteria.list();
    }

    @Override
    public List<EstateShow> findBy(Long userId) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("realEstate.userId", userId));

        return criteria.list();
    }
}
