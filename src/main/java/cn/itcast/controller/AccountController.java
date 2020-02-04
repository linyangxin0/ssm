package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {

    //    自动注入类型注入
    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }

    @RequestMapping("/loginAjax")
    public @ResponseBody void loginAjax(String user_name, String password,HttpServletResponse response,HttpServletRequest request) throws IOException {
        Account account = accountService.getUserByName(user_name);
        if(user_name.equals("")||password.equals("")){
            response.getWriter().print("Illegal input");
        }else if(account==null){
            response.getWriter().print("Account does not exist");
        }else if(!account.getPassword().equals(password)){
            response.getWriter().print("Wrong account or password");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user_name);
        }
    }

    @RequestMapping("/logoutAjax")
    public void logoutAjax(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
    }

}
