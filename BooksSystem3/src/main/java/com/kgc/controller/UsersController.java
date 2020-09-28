package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Book_info;
import com.kgc.pojo.Users;
import com.kgc.service.Book_infoService;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-09-28 17:24
 */
@Controller
public class UsersController {
    @Resource
    UsersService usersService;
    @Resource
    Book_infoService book_infoService;
    @RequestMapping("/")
    public String index() {
        return "login";
    }
    @RequestMapping("/dologin")
    public String dologin(String userCode, String password, HttpSession session) {
        List<Users> sellog = usersService.sellog();
        for (int i = 0; i < sellog.size(); i++) {
            if (sellog.get(i).getUserCode().equals(userCode) && sellog.get(i).getPassword().equals(password)) {
                session.setAttribute("username", sellog.get(i).getUserCode());
                return "index";
            }
        }
        session.setAttribute("msg", "账号或密码不存在");
        return "login";
    }
    @RequestMapping("/cha")
    public String cha(Model model,@RequestParam("lei") Integer lei, @RequestParam("title") String title, @RequestParam("jie") Integer jie, @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex){
        int pageSize = 5;
        PageInfo<Book_info> select = book_infoService.select(lei, title, jie, pageIndex, pageSize);
       model.addAttribute("page",select);
        return "index";
    }


}
