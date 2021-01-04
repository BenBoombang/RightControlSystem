package com.ben.rightMana.service;

import com.ben.rightMana.domain.Product;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 16:26
 */
public interface ProductService {

    void save(Product product);

    // 异步查询所有商品信息
    List<Product> pageQuery(Map<String,Object> map);

    void deleteProduct(Integer productId);

    Product queryById(Integer productId);

    void updateProduct(Product product);

    void deleteProducts(Map<String, Object> map);

    void openStatus(Map<String, Object> map);

    void closeStatus(Map<String, Object> map);

    List<Product> exportQuery(Map<String, Object> map);
}
