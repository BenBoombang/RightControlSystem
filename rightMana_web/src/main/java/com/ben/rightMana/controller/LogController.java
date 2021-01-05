package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.SysLog;
import com.ben.rightMana.service.LogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 18:46
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/queryAll")
    public String queryAll(){
        return "syslog-list";
    }


    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(@RequestParam(name = "pageno") Integer pageno,@RequestParam(name = "pagesize") Integer pagesize,@RequestParam(name = "queryText",required = false) String queryText){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("pageno",pageno);
            map.put("pagesize",pagesize);
            if (!StringUtils.isEmpty(queryText)){
                map.put("queryText",queryText);
            }
            List<SysLog> logList = logService.pageQuery(map);

            PageInfo<SysLog> sysLogPageInfo = new PageInfo<>(logList);

            ajaxResult.setData(sysLogPageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }


        return ajaxResult;
    }
}
