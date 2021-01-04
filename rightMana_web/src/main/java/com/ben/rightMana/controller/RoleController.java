package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String queryAll(){
        return "role-list";
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


    /**
     * 角色页面分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(@RequestParam(name = "pageno") Integer pageno,@RequestParam(name = "pagesize") Integer pagesize,@RequestParam(name = "queryText",required = false) String queryText){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("pageno",pageno);
            map.put("pagesize",pagesize);

            if (queryText != null){
                map.put("queryText",queryText);
            }

            List<Role> roleList = roleService.pageQuery(map);
            PageInfo<Role> rolePageInfo = new PageInfo<>(roleList);
            ajaxResult.setData(rolePageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }

    /**
     * 根据ID，跳转到对应的角色编辑界面
     * @param roleId
     * @return
     */
    @RequestMapping("/roleEdit")
    public ModelAndView roleEdit(@RequestParam(name = "id") Integer roleId){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.queryDetailById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-edit");

        return mv;
    }

    @RequestMapping("/update")
    public String update(Role role){
        roleService.updateRole(role);

        return "redirect:queryAll";
    }
}
