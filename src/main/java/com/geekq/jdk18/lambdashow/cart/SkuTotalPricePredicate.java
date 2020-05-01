package com.geekq.jdk18.lambdashow.cart;

/**
 * @author 轩北
 * @date 2020/4/30 3:04 下午
 * 对sku总价是否超出2000作为判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate {


    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice()>2000;
    }
}
