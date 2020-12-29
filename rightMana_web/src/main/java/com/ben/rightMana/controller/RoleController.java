package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Role;
import com.ben.rightMana.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:52
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.queryAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");

        return mv;
    }


    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:queryAll";
    }
}
