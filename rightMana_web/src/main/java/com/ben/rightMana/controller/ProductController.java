package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Product;
import com.ben.rightMana.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @time 16:53
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/queryAll")
    public String queryAll(){
        return "product-list";
    }

    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(@RequestBody HashMap<String, Object> map){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> trueMap = new HashMap<>();
            trueMap.put("pageno",map.get("pageno"));
            trueMap.put("pagesize",map.get("pagesize"));

            if (map.containsKey("queryText")){
                trueMap.put("queryText",map.get("queryText"));
            }

            List<Product> products = productService.pageQuery(map);
            PageInfo<Product> productPageInfo = new PageInfo<>(products);
            ajaxResult.setData(productPageInfo);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    /**
     * 新增产品
     * @param product
     */
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        // return "redirect:queryAll"; 这句代码相当于再次发送一个请求
        return "redirect:queryAll";
    }


    /**
     * 根据商品ID删除商品
     * @param productId 产品ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteProduct(@RequestParam(name = "productId") Integer productId){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            productService.deleteProduct(productId);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }

    /**
     * 根据产品ID找到相干产品，然后跳转到修改页面
     * @param productId
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(name = "productId") Integer productId){
        ModelAndView mv = new ModelAndView();

        // 先根据产品ID，查到产品的所有信息
        Product product = productService.queryById(productId);
        mv.addObject("product",product);
        mv.setViewName("product-edit");

        return mv;
    }

    /**
     * 更新产品
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String updateProduct(Product product){
        productService.updateProduct(product);

        return "redirect:queryAll";
    }

    /**
     * 批量删除产品
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletes")
    public Object deletes(@RequestParam(name = "ids") Integer[] productIds){

        AjaxResult ajaxResult = new AjaxResult();

        try {

            Map<String,Object> trueMap = new HashMap<>();
            trueMap.put("productIds",productIds);
            productService.deleteProducts(trueMap);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }

    /**
     * 批量开启产品
     * @param productIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/opens")
    public Object opens(@RequestParam(name = "ids") Integer[] productIds){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("productIds",productIds);
            productService.openStatus(map);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    /**
     * 批量屏蔽产品
     * @return
     */
    @ResponseBody
    @RequestMapping("/closes")
    public Object closes(@RequestParam(name = "ids") Integer[] productIds){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("productIds",productIds);
            productService.closeStatus(map);

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
            List<Product> products = productService.exportQuery(map);

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("产品表");

            XSSFRow row0 = sheet.createRow(0);

            String[] title = {"ID","产品名称","产品编码","出发城市","出发时间","产品价格","产品描述","状态"};

            for (int i = 0;i < title.length;i++){
                XSSFCell cell = row0.createCell(i);
                cell.setCellValue(title[i]);
            }

            XSSFRow row = null;

            for (int i = 0; i < products.size(); i++) {
                row = sheet.createRow(i + 1);
                Product product = products.get(i);

                XSSFCell proCell0 = row.createCell(0);
                proCell0.setCellValue(product.getId());

                XSSFCell proCell1 = row.createCell(1);
                proCell1.setCellValue(product.getProductNum());

                XSSFCell proCell2 = row.createCell(2);
                proCell2.setCellValue(product.getProductName());

                XSSFCell proCell3 = row.createCell(3);
                proCell3.setCellValue(product.getCityName());

                XSSFCell proCell4 = row.createCell(4);
                proCell4.setCellValue(product.getDepartureTimeStr());

                XSSFCell proCell5 = row.createCell(5);
                proCell5.setCellValue(product.getProductPrice().toString());

                XSSFCell proCell6 = row.createCell(6);
                proCell6.setCellValue(product.getProductDesc());

                XSSFCell proCell7 = row.createCell(7);
                proCell7.setCellValue(product.getProductStatusStr());

            }

            String fileName = URLEncoder.encode("产品表.xlsx","utf-8");
            response.setContentType("application/octet-stream");
            response.setHeader("content-disposition","attachment;filename=" + fileName);
            response.setHeader("filename", fileName);
            workbook.write(response.getOutputStream());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
