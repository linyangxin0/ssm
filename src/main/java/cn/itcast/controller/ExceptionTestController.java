package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unUse")
public class ExceptionTestController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        try{
            int a=10/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("查询所有用户出现错误");
        }
        return "success";
    }


    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("controller执行了");
        return "success";
    }

}
