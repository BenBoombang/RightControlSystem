package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.service.PermissionService;
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
 * @time 21:06
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/queryAll")
    public String queryAll(){
        return "permission-list";
    }


    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:queryAll";
    }


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
            List<Permission> permissionList = permissionService.pageQuery(map);
            PageInfo<Permission> permissionPageInfo = new PageInfo<>(permissionList);

            ajaxResult.setData(permissionPageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    @RequestMapping("/editPermission")
    public ModelAndView editPermission(@RequestParam(name = "id") Integer permissionId){
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.queryById(permissionId);
        mv.addObject("permission",permission);
        mv.setViewName("permission-edit");

        return mv;
    }


    @RequestMapping("/update")
    public String update(Permission permission){

        permissionService.updatePermission(permission);

        return "redirect:queryAll";

    }
}
