package com.geekq.jdk18.lambdashow.cart;

/**
 * @author 轩北
 * @date 2020/4/30 3:03 下午
 * 对sku商品类型为图书类的判断标准
 */
public class SkuBooksCtegoryPredicate  implements SkuPredicate{

    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }

}
