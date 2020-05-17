package com.geekq.jdk18.STinit.lambda.verion.one;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuPredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 轩北
 * @date 2020/4/30 11:46 上午
 */
public class Veresion6 {

    @Test
    public void filterSkus(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //利用lambda 表达式来进行改造
        List<Sku> result = CartService.filterSkus(cartSkuList,(Sku sku )-> sku.getSkuPrice()>1000);
        System.out.println(JSON.toJSONString(result,true));
    }


}
