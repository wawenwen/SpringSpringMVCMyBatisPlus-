package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //去到登录界面
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    //实现登录功能
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model, HttpSession session){
        System.out.println(123);
        //调用service的方法
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uname",user.getUname());
        queryWrapper.eq("password",user.getPassword());s
        User u = userService.getOne(queryWrapper);
        System.out.println(u);
        if (u!=null){
            //账号密码不正确
            if (u.getFlag().equals("1")){
                //可以登录成功的
                session.setAttribute("activeName",u.getUname());
                return "success";
            }else{
                //账号被冻结
                model.addAttribute("errorMsg","账号被冻结，请联系客服");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            //账号或密码不正确
            model.addAttribute("errorMsg","账号或密码不正确");
            model.addAttribute("user",user);
            return "login";
        }

    }

    //提供一个方法，能访问我的淘宝
    @RequestMapping("/toMy")
    public  String toMy(){
        return "myTaoBao";
    }

    //提供一个方法，能访问购物车
    @RequestMapping("/toCar")
    public  String toCar(){
        return "shoppingCar";
    }

    @RequestMapping("/shouYe")
    public String shouYe(){
        return "main";
    }
}
