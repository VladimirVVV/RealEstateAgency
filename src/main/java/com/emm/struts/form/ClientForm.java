package com.emm.struts.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vladimir on 07.02.2018.
 */
public class ClientForm extends ActionForm {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        // reset properties
        id = null;
    }

}