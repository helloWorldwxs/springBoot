package com.example.util.thread;

import com.example.service.IntegralOrderService;
import com.example.util.SpringContextUtil;

/**
 * Copyright (C), 2015-2018
 * FileName: productThread
 * Author:   wuxiaosen
 * Date:     2018/7/12 0012 14:41
 * Description: 商品线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ProductThread implements Runnable{
/*

    private final ProductService productService = (ProductService) SpringContextUtil.getBean("productService");

    private final IntegralOrderService integralOrderService = (IntegralOrderService) SpringContextUtil.getBean("integralOrderService");

*/

    private Integer type;
    private Integer productId;
    private Integer userId;

    public ProductThread(Integer type,Integer productId,Integer userId){
        this.type = type;
        this.productId = productId;
        this.userId = userId;
    }
    @Override
    public void run() {
        //添加
        System.out.println("进入线程！");
        if(type==1){
           this.placeAnOrder(productId,userId);
        }
        //修改
        //删除
        //下单

    }

    public void placeAnOrder(Integer productId,Integer userId){
        //获取商品库存
      /* *//*Integer stock = productService.findByStock(productId);*//*
        Product product = productService.findById(productId);
       //当商品库存大于0时，进行下单
       if (product.getStock()>0){
           IntegralOrder integralOrder = new IntegralOrder();
           integralOrder.setName(product.getName());
           integralOrder.setCode(product.getCode());
           integralOrder.setState(0);
           integralOrder.setUserId(userId);
           Boolean bool = integralOrderService.add(integralOrder);
           Logger log = LogUtils.getBussinessLogger();
           log.info("添加订单成功！"+bool+"时间："+ DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
       }
*/
    }

}
