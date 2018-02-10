package com.emm.struts.action;

import com.emm.entities.Client;
import com.emm.services.ClientService;
import com.emm.struts.form.TestJsonForm;
import com.google.gson.Gson;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HelloWorldAction extends ActionSupport {

    private List<Client> clientList;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        TestJsonForm helloWorldForm = (TestJsonForm) form;
        helloWorldForm.setMessage("Hello World! Struts");


        ClientService clientService =
                (ClientService) getWebApplicationContext().getBean("showClient");


        List<Client> clientList = clientService.list();


        Gson gson = new Gson();
        String jsonInString = gson.toJson(clientList);
        request.setAttribute("JsonObj", jsonInString);

        return mapping.findForward("success");
    }

}