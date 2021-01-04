package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.ProductDao;
import com.ben.rightMana.domain.Product;
import com.ben.rightMana.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 16:26
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> pageQuery(Map<String,Object> map) {
        PageHelper.startPage(Integer.valueOf(map.get("pageno").toString()),Integer.valueOf(map.get("pagesize").toString()) );
        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }
        return productDao.pageQuery(queryText);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public Product queryById(Integer productId) {
        return productDao.queryById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProducts(Map<String, Object> map) {
        productDao.deleteProducts(map);
    }

    @Override
    public void openStatus(Map<String, Object> map) {
        productDao.openStatus(map);
    }

    @Override
    public void closeStatus(Map<String, Object> map) {
        productDao.closeStatus(map);
    }

    @Override
    public List<Product> exportQuery(Map<String, Object> map) {
        return productDao.exportQuery(map);
    }

}
