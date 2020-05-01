package com.geekq.jdk18.STinit.lambda.verion.one;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuPredicate;
import com.geekq.jdk18.lambdashow.cart.SkuTotalPricePredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 轩北
 * @date 2020/4/30 11:46 上午
 */
public class Veresion5 {

    @Test
    public void filterSkus(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //利用匿名内部类
        List<Sku> result = CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuPrice()>1000;
            }
        });
        System.out.println(JSON.toJSONString(result,true));
    }


}
