package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:06
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionService.queryAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }


    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:queryAll";
    }
}
