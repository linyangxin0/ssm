package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/List")
public class ListController {

    @Autowired
    private AccountService accountService;

//    @RequestMapping("/findAll")
//    public ModelAndView finAll(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
//        List<Account> list = accountService.findAll();
//        arg1.setHeader("Content-type", "text/json;charset=UTF-8");
//        JSONArray jsonArray=new JSONArray();
//        jsonArray.addAll(list);
//        byte[] reArr=jsonArray.toString().getBytes();
//        arg1.getOutputStream().write(reArr);
//        return null;
//    }

//    @RequestMapping("/findAll")
//    public @ResponseBody Object finAll(ModelMap model) {
//        List<Account> list = accountService.findAll();
//        JSONArray s=JSONArray.fromObject(list);
//        model.addAttribute("list", s);
//        return "list";
//    }

    @RequestMapping("/findAll")
    public @ResponseBody List<Account> finAll() {
        return accountService.findAll();
    }

    @RequestMapping("/addUser")
    public @ResponseBody void addUser(Account account){
        accountService.addUser(account);
    }
}
