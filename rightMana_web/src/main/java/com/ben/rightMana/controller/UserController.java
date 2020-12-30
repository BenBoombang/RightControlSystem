package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import com.ben.rightMana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 查询用户以及用户可以新增的角色
     * @return
     */
    @RequestMapping("/queryUserByIdAndAllRole")
    public ModelAndView queryUserByIdAndAllRole(@RequestParam(name = "id") Integer userId){
        ModelAndView mv = new ModelAndView();

        // 首先根据 id 查询出当前用户的具体信息
        UserInfo userInfo = userService.queryDetailById(userId);

        // 然后根据 id 查询出当前用户还可以添加哪些角色
        List<Role> unAddRoles = userService.queryUnaddRole(userId);

        mv.addObject("user",userInfo);
        mv.addObject("roleList",unAddRoles);
        mv.setViewName("user-role-add");

        return mv;

    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "ids") Integer[] roleIds){
        userService.addRoleToUser(userId,roleIds);

        return "redirect:queryAll";
    }
}
