package com.geekq.jdk18.STinit.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuCategoryEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author 轩北
 * @date 2020/5/1 11:22 上午
 */
public class StreamVs {

    /**
     * 1. 想看看购物车里有什么东西
     * 2.图书类的商品都给买
     * 3.其余的商品中买俩件最贵的
     * 4.只要俩件商品的名称和总价
     */


    /**
     * 原始形式完成
     */
    @Test
    public void oldCartHandle(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        /**
         * 1 打印所有商品
         */
        for (Sku sku:cartSkuList) {
            System.out.println(JSON.toJSONString(sku ,true));
        }

        /**
         * 图书类的过滤掉
         */
        List<Sku> notBooksSkuList = new ArrayList<>();
        for (Sku sku:cartSkuList) {
            if(!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())){
                notBooksSkuList.add(sku);
            }
        }

        /**
         * 总价进行排序 取top 2
         */
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
               if(o1.getTotalPrice()>o2.getTotalPrice()){
                   return -1;
               }else if(o1.getTotalPrice()<o2.getTotalPrice()){
                   return 1;
               }else{
                   return 0;
               }
            }
        });

        List<Sku> top2SkuList = new ArrayList<>();
        for (int i = 0; i <2 ; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        /**
         * 4.求商品总价
         */

        Double money = 0.0;
        for (Sku sku:top2SkuList) {
            money+=sku.getTotalPrice();
        }

        /**
         * 获取俩件商品的名称
         */

        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku:top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        /**
         * 打印结果
         */
        System.out.println(JSON.toJSONString(resultSkuNameList,true));
        System.out.println("商品总价 ："+money);





    }


    /**
     * 已stream 方式 实现需求
     */
    public void newCartHandle(){


        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

        List<String> result = CartService.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(JSON.toJSONString(sku,true)))
                /**
                 * 过滤不等于提出类的商品
                 */
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                /**
                 * 排序
                 */
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                /**
                 * 前俩个
                 */
                .limit(2)
                /**
                 * 对金额进行累加
                 */
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                /**
                 * 获取商品名称
                 */
                .map(sku -> sku.getSkuName())
                //对结果进行收集
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result,true));


    }
}
