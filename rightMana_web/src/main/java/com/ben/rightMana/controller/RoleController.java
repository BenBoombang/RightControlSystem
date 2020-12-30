package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 根据角色 id 查询角色的信息并查询出可以给这个角色添加的权限
     */
    @RequestMapping("/queryRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") Integer roleId){
        ModelAndView mv = new ModelAndView();

        Role role = roleService.queryDetailById(roleId);

        List<Permission> permissionList = roleService.queryUnaddPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");

        return mv;
    }

    // 给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(Integer roleId,@RequestParam(name = "ids") Integer[] permissionIds){
        ModelAndView mv = new ModelAndView();
        roleService.addPermissionToRole(roleId,permissionIds);

        return "redirect:queryAll";
    }
}
