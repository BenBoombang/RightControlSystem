package com.ben.rightMana.service;

import com.ben.rightMana.domain.Product;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 16:26
 */
public interface ProductService {
    // 查询所有商品信息
    List<Product> findAll();

    void save(Product product);
}
