package com.geekq.jdk18.STinit.lambda.verion.one;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 轩北
 * @date 2020/4/30 11:46 上午
 */
public class Veresion1 {
    @Test
    public void filterElectronicsSkus(){

        List<Sku> cartSkuList = CartService.getCartSkuList();
        // 查询购物车种数码类的商品
        List<Sku> result = CartService.filterElectroicsSkus(cartSkuList);
        System.out.println(JSON.toJSONString(result,true));
    }


}
