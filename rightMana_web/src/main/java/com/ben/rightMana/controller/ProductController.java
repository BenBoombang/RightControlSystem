package com.ben.rightMana.controller;

import com.ben.rightMana.domain.Product;
import com.ben.rightMana.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 16:53
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll();

        mv.addObject("productList",products);
        mv.setViewName("product-list");

        return mv;
    }


    /**
     * 新增产品
     * @param product
     */
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        // return "redirect:findAll"; 这句代码相当于再次发送一个请求
        return "redirect:findAll";
    }
}
