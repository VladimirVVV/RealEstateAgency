package com.agency.controllers;

import com.agency.entities.EstateShow;
import com.agency.entities.RealEstate;
import com.agency.services.EstateShowService;
import com.agency.services.RealEstateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 01.11.2016.
 */
@Controller
public class RealEstateListController {
    final Logger logger = LoggerFactory.getLogger(RealEstateListController.class);
    @Autowired
    private EstateShowService estateShowService;
    @Autowired
    private RealEstateService realEstateService;

    @RequestMapping(method = RequestMethod.GET, value = "/real_estates")
    public String showAllRealEstate(ModelMap model) {
        List<RealEstate> realEstates = realEstateService.list();
        model.put("realEstates", realEstates);

        return "realEstateList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/real_estate")
    public String showRealEstate(HttpServletRequest request, ModelMap model) {
        Long userId;
        Long realEstateId;

        try {
            userId = Long.valueOf(request.getParameter("user_id"));
            realEstateId = Long.valueOf(request.getParameter("id"));
        } catch (Exception e) {
            model.addAttribute("error", "Arguments must be numbers!");
            return "showingEstateForm";
        }

        RealEstate realEstate = realEstateService.getById(realEstateId);
        model.addAttribute("realEstate", realEstate);

        return "showingEstateForm";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registrate_meeting")
    public String registrateShowingRealEstate(HttpServletRequest request, ModelMap model) {
        EstateShow estateShow;
        try {
            estateShow = obtainEstateShow(request);
        } catch (Exception e) {
            model.addAttribute("error", e.toString());
            return "showingEstateForm";
        }

        if (!estateShowService.create(estateShow)) {
            model.addAttribute("error", "This time gap is already is occupied!!! ");
            model.addAttribute("realEstate", estateShow.getRealEstate());
            return "showingEstateForm";
        }

        List<EstateShow> lst = estateShowService.list();
        model.addAttribute("estateShowList", lst);
        return "showingEstateMeetings";
    }

    private EstateShow obtainEstateShow(HttpServletRequest request) throws ParseException {
        String clientSurname = request.getParameter("clientSurname");
        String clientName = request.getParameter("clientName");
        String clientPatronymic = request.getParameter("clientPatronymic");
        String clientPhone = request.getParameter("clientPhone");
        long realEstateId = Long.parseLong(request.getParameter("realEstateId"));
        String clientDateParam = request.getParameter("clientDate") + " " + request.getParameter("clientTime");

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date clientDate = format.parse(clientDateParam);

        EstateShow estateShow = new EstateShow();
        estateShow.setClientSurname(clientSurname);
        estateShow.setClientName(clientName);
        estateShow.setClientPatronymic(clientPatronymic);
        estateShow.setClientPhone(clientPhone);
        RealEstate realEstate = realEstateService.getById(realEstateId);
        estateShow.setRealEstate(realEstate);
        estateShow.setMeetingTime(clientDate);

        return estateShow;
    }
}
