package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 16:23
 */
public interface ProductDao {

    // 查询所有商品信息
    List<Product> pageQuery(@Param("queryText") String queryText);

    void save(Product product);

    // 根据id查对应的产品
    Product findById(String id);

    @Delete("delete from product where id = #{productId}")
    void deleteProduct(Integer productId);

    @Select("select * from product where id = #{productId}")
    Product queryById(Integer productId);

    void updateProduct(Product product);

    void deleteProducts(Map<String, Object> map);

    void openStatus(Map<String, Object> map);

    void closeStatus(Map<String, Object> map);

    List<Product> exportQuery(Map<String, Object> map);
}
