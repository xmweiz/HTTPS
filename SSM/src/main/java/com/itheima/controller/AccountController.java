package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountController {
    private AccountService accountService;

    public String findAll(Model model){
        //调用service方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount();
        //重定向到findAll
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
