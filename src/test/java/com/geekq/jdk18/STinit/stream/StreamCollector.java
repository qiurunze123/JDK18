package com.geekq.jdk18.STinit.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 轩北
 * @date 2020/5/3 9:56 下午
 *
 * 常见预收集器使用
 */
public class StreamCollector {

    @Test
    public void toList(){
        List<Sku> list = CartService.getCartSkuList();

        List<Sku> result = list.stream().filter(sku -> sku.getTotalPrice()>100)

                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result,true));
    }


    /**
     * 分组
     */
    @Test
    public void group(){
        List<Sku> list = CartService.getCartSkuList();

        //Map 分组条件 结果结合
        Map<Object,List<Sku>> group =  list.stream().
               collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));

        System.out.println(JSON.toJSONString(group,true));
    }


    /**
     * 分区
     */
    @Test
    public void partition(){

        List<Sku> list = CartService.getCartSkuList();

        Map<Boolean,List<Sku>> partition = list.stream().
                collect(Collectors.partitioningBy
                (sku -> sku.getTotalPrice()>100));

        System.out.println(JSON.toJSONString(partition,true));
    }
}
