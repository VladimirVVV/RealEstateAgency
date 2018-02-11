package com.emm.struts.action;

import com.emm.services.AccountService;
import org.apache.struts.action.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 11.02.2018.
 */
public class AccountInfoAction extends Action {
    @Autowired(required = true)
    private AccountService accountInfoList;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Map<String, String>> list = accountInfoList.accountInfoList();
//        List<Client> list = accountInfoList.list();
        DynaActionForm dynaAccountListForm = (DynaActionForm) form;
        dynaAccountListForm.set("accountList", list);

        return mapping.findForward("success");
    }

}