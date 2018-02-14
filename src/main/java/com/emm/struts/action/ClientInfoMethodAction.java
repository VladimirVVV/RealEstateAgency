package com.emm.struts.action;

import com.emm.services.ClientService;
import com.emm.struts.form.ClientForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vladimir on 14.02.2018.
 */
public class ClientInfoMethodAction extends DispatchAction {
    @Autowired(required = true)
    private ClientService clientService;
    public ActionForward addAccount(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("add_account");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClientForm clientForm = (ClientForm) form;
        clientService.delete(clientForm.getId());

        return mapping.findForward("success");
    }
}
