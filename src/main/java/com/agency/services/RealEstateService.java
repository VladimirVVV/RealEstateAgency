package com.agency.services;

import com.agency.entities.RealEstate;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface RealEstateService {
    boolean create(RealEstate realEstate);
    List<RealEstate> list();
    List<RealEstate> listByUserId(Long userId);
    RealEstate getById(Long id);
}
