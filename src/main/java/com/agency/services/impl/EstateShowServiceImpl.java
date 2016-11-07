package com.agency.services.impl;

import com.agency.dao.EstateShowDao;
import com.agency.entities.EstateShow;
import com.agency.entities.RealEstate;
import com.agency.services.EstateShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Service("showEstateService")
@Transactional
public class EstateShowServiceImpl implements EstateShowService {
    @Autowired
    private EstateShowDao dao;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public boolean create(EstateShow estateShow) {
        Date meetingTime = estateShow.getMeetingTime();
        RealEstate realEstate = estateShow.getRealEstate();
        if (!thereIsAGap(realEstate, meetingTime)) {
            return false;
        }
        dao.save(estateShow);
        return true;
    }

    private boolean thereIsAGap(RealEstate realEstate, Date meetingTime) {
        int minutesDelta = 20;
        Date meetingTimeEnd = add(meetingTime, minutesDelta);

        List lst = listBy(realEstate, meetingTime, meetingTimeEnd);
        return lst.isEmpty();
    }

    private Date add(Date meetingTime, int minutesDelta) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(meetingTime);
        cal.add(Calendar.MINUTE, minutesDelta);

        return cal.getTime();
    }

    private List<EstateShow> listBy(RealEstate realEstate, Date meetingTimeStart, Date meetingTimeEnd) {
        return dao.findBy(realEstate, meetingTimeStart, meetingTimeEnd);
    }

    @Override
    public List<EstateShow> list() {
        return dao.findAll();
    }

    @Override
    public List<EstateShow> listByUserId(Long userId) {
        return dao.findBy(userId);
    }
}
