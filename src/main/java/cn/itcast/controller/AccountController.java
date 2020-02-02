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
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {

    //    自动注入类型注入
    @Autowired
    private AccountService accountService;

//    @RequestMapping("/findAll")
////    public String finAll(Model model) {
////        List<Account> list = accountService.findAll();
////        model.addAttribute("list", list);
////        return "list";
////    }


    //保存
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpServletResponse response) {
        Account account = accountService.getUserByName(request.getParameter("user_name"));
        if (account == null) {
            model.addAttribute("msg", "用户名未注册");
            return "/account";
        }
        String password = account.getPassword();
        if (password.equals(request.getParameter("password"))) {
            return "/userList";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "/account";
        }
    }

    @RequestMapping("/loginAjax")
    public @ResponseBody
    void loginAjax(String user_name, String password,HttpServletResponse response) throws IOException {
        Account account = accountService.getUserByName(user_name);
        if(user_name.equals("")||password.equals("")){
            response.getWriter().print("Illegal input");
        }else if(account==null){
            response.getWriter().print("Account does not exist");
        }else if(!account.getPassword().equals(password)){
            response.getWriter().print("Wrong account or password");
        }
    }

}
