package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by liukai on 2018/7/24.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public String login( ){
        return "admin/login";
    }
    @RequestMapping("/checkPass")
    public String checkPass(Admin admin,HttpSession session,Model model){
        Admin admin_find=adminService.findByName(admin.getName());
        if(admin_find==null||!ifPass(admin_find,admin.getPassword())){
            model.addAttribute("msg","用户名或密码错误");
            return "admin/login";
        }else{
            session.setAttribute("logAdmin",admin_find);
            return "admin/index";
        }
    }
    public boolean ifPass(Admin admin,String pass){
        if(pass.equals(admin.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}
