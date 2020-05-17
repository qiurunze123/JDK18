package com.geekq.lambda.cart;

/**
 * 对Sku的总价是否超出2000作为判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
