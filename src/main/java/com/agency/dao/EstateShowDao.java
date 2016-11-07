package com.agency.dao;

import com.agency.entities.EstateShow;
import com.agency.entities.RealEstate;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface EstateShowDao {
    void save(EstateShow estateShow);
    List<EstateShow> findBy(RealEstate realEstate, Date meetingTimeStart, Date meetingDateEnd);
    List<EstateShow> findBy(Long userId);
    List<EstateShow> findAll();
}
