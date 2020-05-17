package com.geekq.jdk18.lambdashow.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 轩北
 * @date 2020/4/30 11:18 上午
 */
public class CartService {

    // 加入到购物车中的商品信息
    private static List<Sku> cartSkuList =
            new ArrayList<Sku>(){
                {
                    add(new Sku(654032, "无人机",
                            4999.00, 1,
                            4999.00, SkuCategoryEnum.ELECTRONICS));

                    add(new Sku(642934, "VR一体机",
                            2299.00, 1,
                            2299.00, SkuCategoryEnum.ELECTRONICS));

                    add(new Sku(645321, "纯色衬衫",
                            409.00, 3,
                            1227.00, SkuCategoryEnum.CLOTHING));

                    add(new Sku(654327, "牛仔裤",
                            528.00, 1,
                            528.00, SkuCategoryEnum.CLOTHING));

                    add(new Sku(675489, "跑步机",
                            2699.00, 1,
                            2699.00, SkuCategoryEnum.SPORTS));

                    add(new Sku(644564, "Java编程思想",
                            79.80, 1,
                            79.80, SkuCategoryEnum.BOOKS));

                    add(new Sku(678678, "Java核心技术",
                            149.00, 1,
                            149.00, SkuCategoryEnum.BOOKS));

                    add(new Sku(697894, "算法",
                            78.20, 1,
                            78.20, SkuCategoryEnum.BOOKS));

                    add(new Sku(696968, "TensorFlow进阶指南",
                            85.10, 1,
                            85.10, SkuCategoryEnum.BOOKS));
                }
            };

    /**
     * 获取商品信息列表
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     *  version 1.0.0
     *  找出购物车所有电子商品
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectroicsSkus(List<Sku> cartSkuList){

        List<Sku> result = new ArrayList<>();

        for (Sku  sku: cartSkuList) {
            if(SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())){
                result.add(sku);
            }
        }

        return  result;
    }


    /**
     * version 2
     * 根据传入商品类型参数 找到购物车中同种商品类型的商品列表
     *
     * good mean  根据传入类型就能查找结果
     * @param cartSkuList
     * @param categoryEnum
     * @return
     */
    public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList,
                                                 SkuCategoryEnum categoryEnum){
        List<Sku> result = new ArrayList<>();
        for (Sku  sku: cartSkuList) {
            if(categoryEnum.equals(sku.getSkuCategory())){
                result.add(sku);
            }
        }
        return  result;

    }


    /**
     * 如果根据商品类型判断，sku类型与输入类型比较
     * 如果根据商品总价判断，sku总价与输入总价比较
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categoryOrPrice -- true 根据商品类型 --false 根据商品总价
     * @return
     */

    public static List<Sku> filterSkus(
            List<Sku> cartSkuList,SkuCategoryEnum categoryEnum, Double totalPrice,Boolean categoryOrPrice){
        List<Sku> result = new ArrayList<Sku>();

        for (Sku sku: cartSkuList) {
            if (
                    (categoryOrPrice
                            && categoryEnum.equals(sku.getSkuCategory())
                            || (!categoryOrPrice
                                    && sku.getTotalPrice() > totalPrice))) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * version 4.0.0
     * 根据不同sku判断标准 对Sku列表进行过滤
     * @param cartSkuList
     * @param predicate
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> cartSkuList,SkuPredicate predicate){

        List<Sku> result = new ArrayList<>();
        for (Sku  sku: cartSkuList) {
            if(predicate.test(sku)){
                result.add(sku);
            }
        }
        return result;
    }


}
