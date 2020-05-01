package com.geekq.jdk18.STinit.lambda.verion.one;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuCategoryEnum;
import com.geekq.jdk18.lambdashow.cart.SkuTotalPricePredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 轩北
 * @date 2020/4/30 11:46 上午
 */
public class Veresion4 {

    @Test
    public void filterSkus(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList,new SkuTotalPricePredicate());
        System.out.println(JSON.toJSONString(result,true));
    }


}
