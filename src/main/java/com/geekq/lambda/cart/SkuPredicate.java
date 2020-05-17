package com.geekq.lambda.cart;

/**
 * Sku选择谓词接口
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);

}
