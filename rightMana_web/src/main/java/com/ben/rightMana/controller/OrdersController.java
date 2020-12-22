package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:03
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // 查询全部订单 —— 未分页
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//
//        ModelAndView mv = new ModelAndView();
//
//        List<Orders> ordersList = ordersService.findAll();
//
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//
//        return mv;
//    }

    // 使用上分页插件
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        // PageInfo 就传统项目中的 page bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
}
