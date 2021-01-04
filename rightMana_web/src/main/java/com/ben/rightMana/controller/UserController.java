package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import com.ben.rightMana.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String queryAll(){
        return "user-list";
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


    /**
     * 用户页面的分页查询函数
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(@RequestParam(name = "pageno",defaultValue = "1",required = false) Integer pageno,@RequestParam(name = "pagesize",defaultValue = "3",required = false) Integer pagesize,@RequestParam(value = "queryText",required = false) String queryText){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("pageno",pageno);
            map.put("pagesize",pagesize);
            if (queryText != null){
                map.put("queryText",queryText);
            }
            List<UserInfo> memberList = userService.pageQuery(map);

            PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(memberList);

            ajaxResult.setData(userInfoPageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }

    /**
     * 批量开启用户
     * @param userIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/opens")
    public Object opens(@RequestParam(name = "ids") Integer[] userIds){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("userIds",userIds);
            userService.openStatus(map);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    @ResponseBody
    @RequestMapping("/closes")
    public Object closes(@RequestParam(name = "ids") Integer[] userIds){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("userIds",userIds);
            userService.closeStatus(map);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    @RequestMapping("/export")
    public void export(@RequestParam(name = "queryText",required = false) String queryText, HttpServletResponse response){

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("queryText","");
            if (!StringUtils.isEmpty(queryText)){
                map.put("queryText",queryText);
            }
            List<UserInfo> userInfoList = userService.exportQuery(map);

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("用户表");

            XSSFRow row0 = sheet.createRow(0);

            String[] title = {"ID","邮箱","用户名","手机号","状态"};

            for (int i = 0;i < title.length;i++){
                XSSFCell cell = row0.createCell(i);
                cell.setCellValue(title[i]);
            }

            XSSFRow row = null;

            for (int i = 0; i < userInfoList.size(); i++) {
                row = sheet.createRow(i + 1);
                UserInfo userInfo = userInfoList.get(i);

                XSSFCell proCell0 = row.createCell(0);
                proCell0.setCellValue(userInfo.getId());

                XSSFCell proCell1 = row.createCell(1);
                proCell1.setCellValue(userInfo.getEmail());

                XSSFCell proCell2 = row.createCell(2);
                proCell2.setCellValue(userInfo.getUsername());

                XSSFCell proCell3 = row.createCell(3);
                proCell3.setCellValue(userInfo.getPhoneNum());

                XSSFCell proCell4 = row.createCell(4);
                proCell4.setCellValue(userInfo.getStatusStr());

            }

            String fileName = URLEncoder.encode("用户表.xlsx","utf-8");
            response.setContentType("application/octet-stream");
            response.setHeader("content-disposition","attachment;filename=" + fileName);
            response.setHeader("filename", fileName);
            workbook.write(response.getOutputStream());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
