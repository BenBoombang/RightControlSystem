package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
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
 * @time 20:03
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // 使用上分页插件
    @ResponseBody
    @RequestMapping("/findAll")
    public Object findAll(@RequestParam(name = "page",required = false,defaultValue = "1")int page, @RequestParam(name = "size",required = false,defaultValue = "3")int size){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            // 由于查询可能伴随着一些条件筛选，所以决定将参数封装到 map 中传递
            Map<String,Object> map = new HashMap<>();
            map.put("page",page);
            map.put("size",size);

            List<Orders> ordersList = ordersService.findAll(map);

            // PageInfo 就传统项目中的 page bean
            PageInfo pageInfo = new PageInfo(ordersList);
            // pageInfo.setSize(count);

            ajaxResult.setData(pageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }

    @RequestMapping("/main")
    public String main(){
        return "orders-page-list";
    }


    @RequestMapping("/queryById")
    public ModelAndView queryById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv = new ModelAndView();

        Orders order = ordersService.queryById(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");

        return mv;
    }
}
