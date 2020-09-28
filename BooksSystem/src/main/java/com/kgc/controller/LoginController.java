package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.BookInfo;
import com.kgc.pojo.Users;
import com.kgc.service.BookInfoService;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2020-09-28 16:53
 */
@Controller
public class LoginController {
    @Resource
    UsersService usersService;
    @Resource
    BookInfoService bookInfoService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("login")
    public String doLogin(String username, String password, Model model, HttpSession session){
        Users users = usersService.selectByUserName(username);
        if (users!=null){
        if (users.getPassword().equals(password)){
            session.setAttribute("username",username);
            PageInfo<BookInfo> pageInfo = bookInfoService.selectAll(null, null, null, 1, 5);
            model.addAttribute("pageInfo",pageInfo);
            return "index";
        }}
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
    @RequestMapping("tiaocha")
    public String tiaocha(Integer lei,String title,Integer jie, Model model){
        PageInfo<BookInfo> pageInfo = bookInfoService.selectAll(lei, title, jie, 1, 5);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
    @RequestMapping("chushi")
    public String chushi(Integer pageNum,Model model){
        PageInfo<BookInfo> pageInfo = bookInfoService.selectAll(null, null, null, pageNum, 5);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
}
