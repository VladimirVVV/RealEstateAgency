package com.emm.struts.action;

import com.emm.services.ClientService;
import org.apache.struts.action.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 10.02.2018.
 */
public class ClientInfoAction extends Action {
    @Autowired(required = true)
    private ClientService clientService;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Map<String, String>> list = clientService.clientInfoList();
//        List<Client> list = clientService.list();
        DynaActionForm dynaClientListForm = (DynaActionForm) form;
        dynaClientListForm.set("clientList", list);

        return mapping.findForward("success");
    }

}
