package com.kgc.lo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.lo.pojo.BookInfo;
import com.kgc.lo.pojo.Users;
import com.kgc.lo.service.BookInfoService;
import com.kgc.lo.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    UsersService usersService;
    @Resource
    BookInfoService bookInfoService;

    @RequestMapping("/")
    public String chu() {
        return "login";
    }

    @RequestMapping("/tuichu")
    public String tuichu() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        List<Users> users = usersService.selectAll();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserCode().equals(username)&&users.get(i).getPassword().equals(password)){
                session.setAttribute("username",users.get(i).getUserCode());
                return "redirect:/chushi?pageNum=1";
            }
        }
        session.setAttribute("msg","账号或密码不存在");
        return "login";
    }

    @RequestMapping("/tiaocha")
    public String chushi(int lei,String title,int jie,Model model){
         int pageNum=1;
        Integer pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<BookInfo> select = bookInfoService.select(lei, title, jie);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(select);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }
    @RequestMapping("/chushi{pageNum}")
    public String chushi(Model model,int pageNum){
        Integer pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<BookInfo> select = bookInfoService.selectAll();
        PageInfo<BookInfo> pageInfo = new PageInfo<>(select);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

}
