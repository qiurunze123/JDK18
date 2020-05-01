package com.geekq.jdk18.STinit.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author 轩北
 * @date 2020/5/1 10:52 下午
 */
public class StreamOperator {

    List<Sku> list;
    @Before
    public void init(){
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterTest(){
        list.stream().
                filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * map 的使用操作
     */
    @Test
    public void mapTest(){

        list.stream()
                /**
                 * 将一个sku对象转换成了一个string
                 */
                .map(sku -> sku.getSkuName())
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * 讲一个对象转换成流 3-13
     */
    @Test
    public void flatMapTest(){

        list.stream()

                /**
                 * 切割成一个字符流
                 */
                .flatMap(sku ->Arrays.stream(sku.getSkuName().split("")))
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }
}
