package com.ben.rightMana.controller;

import com.ben.rightMana.domain.UserInfo;
import com.ben.rightMana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:34
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.queryAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryDetailById")
    public ModelAndView queryDetailById(Integer userId){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.queryDetailById(userId);
        mv.addObject("user",user);
        mv.setViewName("user-show");

        return mv;
    }
}
