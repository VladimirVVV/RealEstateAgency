package com.agency.services;

import com.agency.entities.EstateShow;

import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
public interface EstateShowService {
    boolean create(EstateShow estateShow);
    List<EstateShow> list();
    List<EstateShow> listByUserId(Long userId);
}
