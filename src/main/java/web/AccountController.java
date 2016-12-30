package web;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AccountService;

import java.util.List;

/**
 * Created by gzy on 2016/12/29.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/getEmail")
    @ResponseBody
    public void getEmail(){
        List<Account> accountList = accountService.getEmail();
        for(Account account:accountList){
            System.out.println(account.getEmail());
        }
    }

}
