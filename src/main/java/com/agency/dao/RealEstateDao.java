package com.agency.dao;

import com.agency.entities.RealEstate;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface RealEstateDao {
    void save(RealEstate realEstate);
    List<RealEstate> findAll();
    List<RealEstate> findByUserId(Long userId);
    RealEstate findById(Long id);
}
