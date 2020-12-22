package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Orders> ordersList = ordersService.findAll();

        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");

        return mv;
    }
}
