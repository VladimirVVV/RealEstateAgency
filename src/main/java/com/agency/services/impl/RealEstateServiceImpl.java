package com.agency.services.impl;

import com.agency.dao.RealEstateDao;
import com.agency.entities.RealEstate;
import com.agency.services.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Service("realEstateServiceImpl")
@Transactional
public class RealEstateServiceImpl implements RealEstateService {
    @Autowired
    private RealEstateDao dao;

    @Override
    public boolean create(RealEstate realEstate) {
        dao.save(realEstate);
        return true;
    }

    @Override
    public List<RealEstate> list() {
        return dao.findAll();
    }

    @Override
    public List<RealEstate> listByUserId(Long userId) {
        return dao.findByUserId(userId);
    }

    @Override
    public RealEstate getById(Long id) {
        return dao.findById(id);
    }
}
