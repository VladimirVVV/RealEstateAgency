package com.emm.struts.action;

import com.emm.entities.Client;
import com.emm.entities.SexType;
import com.emm.services.ClientService;
import com.emm.struts.form.TestJsonForm;
import com.google.gson.Gson;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 10.02.2018.
 */

@Component
public class HelloWorldAction extends Action {

    private List<Client> clientList;
    @Autowired(required = true)
    private ClientService clientService;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {


        TestJsonForm helloWorldForm = (TestJsonForm) form;
        helloWorldForm.setMessage("Hello World! Struts");


        List clientList = clientService.list();
        Client cl1 = new Client();
        cl1.setId(1L);
        cl1.setBirthDate(new Date());
        cl1.setEmail("bli@gmail.com");
        cl1.setName("Irvin");
        cl1.setSurname("Belka");
        cl1.setSex(SexType.male);

        clientList.add(cl1);


        Gson gson = new Gson();
        String jsonInString = gson.toJson(clientList);
        request.setAttribute("JsonObj", jsonInString);

        return mapping.findForward("success");
    }

}