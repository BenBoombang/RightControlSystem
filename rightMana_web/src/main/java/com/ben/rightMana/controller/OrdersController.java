package com.ben.rightMana.controller;

import com.ben.rightMana.domain.AjaxResult;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
 * @time 20:03
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // 使用上分页插件
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(@RequestParam(name = "pageno") Integer pageno,@RequestParam(name = "pagesize") Integer pagesize,@RequestParam(name = "queryText",required = false) String queryText){

        AjaxResult ajaxResult = new AjaxResult();

        try {
//            int pageno = Integer.valueOf(map.get("pageno").toString());
//            int pagesize = Integer.valueOf(map.get("pagesize").toString());

            // 由于查询可能伴随着一些条件筛选，所以决定将参数封装到 map 中传递
            Map<String,Object> trueMap = new HashMap<>();
            trueMap.put("page",pageno);
            trueMap.put("size",pagesize);
//            if (map.containsKey("queryText")){
//                trueMap.put("queryText",map.get("queryText"));
//            }
            if (queryText != null){
                trueMap.put("queryText",queryText);
            }

            List<Orders> ordersList = ordersService.pageQuery(trueMap);

            // PageInfo 就传统项目中的 page bean
            PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
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
    public ModelAndView queryById(@RequestParam(name = "id") String id){
        ModelAndView mv = new ModelAndView();

        Orders order = ordersService.queryById(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");

        return mv;
    }


    /**
     * 删除一条选定的订单
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestParam(name = "id") Integer orderId){

        AjaxResult ajaxResult = new AjaxResult();

        try {
            ordersService.delete(orderId);

            ajaxResult.setSucc(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSucc(false);
        }

        return ajaxResult;
    }


    /**
     * 导出到Excel 功能
     * @param queryText
     * @param response
     */
    @RequestMapping("/export")
    public void export(@RequestParam(name = "queryText",required = false) String queryText, HttpServletResponse response){

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("queryText","");
            if (!StringUtils.isEmpty(queryText)){
                map.put("queryText",queryText);
            }

            List<Orders> ordersList = ordersService.exportQuery(map);

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("订单表");

            XSSFRow row0 = sheet.createRow(0);

            String[] title = {"ID","订单编码","下单时间","出行人数","描述","支付类型","支付情况"};

            for (int i = 0;i < title.length;i++){
                XSSFCell cell = row0.createCell(i);
                cell.setCellValue(title[i]);
            }

            XSSFRow row = null;

            for (int i = 0; i < ordersList.size(); i++) {
                row = sheet.createRow(i + 1);
                Orders orders = ordersList.get(i);

                XSSFCell proCell0 = row.createCell(0);
                proCell0.setCellValue(orders.getId());

                XSSFCell proCell1 = row.createCell(1);
                proCell1.setCellValue(orders.getOrderNum());

                XSSFCell proCell2 = row.createCell(2);
                proCell2.setCellValue(orders.getOrderTimeStr());

                XSSFCell proCell3 = row.createCell(3);
                proCell3.setCellValue(orders.getPeopleCount());

                XSSFCell proCell4 = row.createCell(4);
                proCell4.setCellValue(orders.getOrderDesc());

                XSSFCell proCell5 = row.createCell(5);
                proCell5.setCellValue(orders.getPayTypeStr());

                XSSFCell proCell6 = row.createCell(6);
                proCell6.setCellValue(orders.getOrderStatusStr());

            }

            String fileName = URLEncoder.encode("订单表.xlsx","utf-8");
            response.setContentType("application/octet-stream");
            response.setHeader("content-disposition","attachment;filename=" + fileName);
            response.setHeader("filename", fileName);
            workbook.write(response.getOutputStream());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
