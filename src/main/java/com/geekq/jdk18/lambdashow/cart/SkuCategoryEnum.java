package com.geekq.jdk18.lambdashow.cart;

/**
 * @author 轩北
 * @date 2020/4/30 11:21 上午
 */
public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    ;

    //商品类型的编号
    private Integer code ;
    //商品类型的名称
    private String name ;

    /**
     * 构造函数
     * @param code
     * @param name
     */
    SkuCategoryEnum(Integer code , String name ){
        this.code = code;
        this.name = name;
    }
}
