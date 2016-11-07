package com.agency.dao.impl;

import com.agency.dao.RealEstateDao;
import com.agency.entities.RealEstate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Service
public class RealEstateDaoImpl extends AbstractEntityDAO<RealEstate> implements RealEstateDao {
    @Override
    protected Class<RealEstate> getEntityClass() {
        return RealEstate.class;
    }

    @Override
    public List<RealEstate> findByUserId(Long userId) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("userId", userId));

        return criteria.list();
    }

}
