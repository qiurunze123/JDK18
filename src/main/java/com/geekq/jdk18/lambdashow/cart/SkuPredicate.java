package com.geekq.jdk18.lambdashow.cart;

/**
 * @author 轩北
 * @date 2020/4/30 2:58 下午
 *
 * Sku 选择谓词接口
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku  sku);
}
