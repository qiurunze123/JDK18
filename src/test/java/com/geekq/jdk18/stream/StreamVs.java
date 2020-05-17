package com.geekq.jdk18.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.lambda.cart.CartService;
import com.geekq.lambda.cart.Sku;
import com.geekq.lambda.cart.SkuCategoryEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 对比：原始集合操作与Stream集合操作
 */
@Slf4j
public class StreamVs {

    /**
     * 1 想看看购物车中都有什么商品
     * 2 图书类商品都给买
     * 3 其余的商品中买两件最贵的
     * 4 只需要两件商品的名称和总价
     */

    /**
     * 以原始集合操作实现需求
     */
    @Test
    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        /**
         * 1 打印所有商品
         */
        for (Sku sku: cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        /**
         * 2 图书类过滤掉
         */
        List<Sku> notBooksSkuList = new ArrayList<Sku>();
        for (Sku sku: cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

        /**
         * 排序
         */
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()) {
                    return -1;
                } else if (sku1.getTotalPrice() < sku2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        /**
         * TOP2
         */
        List<Sku> top2SkuList = new ArrayList<Sku>();
        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        /**
         * 4 求两件商品的总价
         */
        Double money = 0.0;
        for (Sku sku: top2SkuList) {
            // money = money + sku.getTotalPrice();
            money += sku.getTotalPrice();
        }

        /**
         * 获取两件商品的名称
         */
        List<String> resultSkuNameList = new ArrayList<String>();
        for (Sku sku: top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        /**
         * 打印输入结果
         */
        System.out.println(
                JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money);

    }

    /**
     * 以Stream流方式实现需求
     *
     *   * 1 想看看购物车中都有什么商品
     *      * 2 图书类商品都给买
     *      * 3 其余的商品中买两件最贵的
     *      * 4 只需要两件商品的名称和总价
     */
    @Test
    public void newCartHandle() {

        List<Sku> cartSkuList = CartService.getCartSkuList()
                .stream().peek((Sku sku)->{
                    System.out.println(JSON.toJSONString(sku));
                }).filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                //按照从小到大排序  reverse 变为从大到小
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2).collect(Collectors.toList());

        AtomicReference<Double> money =
                new AtomicReference<>(Double.valueOf(0.0));
        cartSkuList.forEach((Sku sku)->{
            money.set(sku.getSkuPrice()+money.get());
        });

        List<String> skuName =   cartSkuList.stream().map(sku -> sku.getSkuName()).collect(Collectors.toList());

        log.info("skuName :: =======" + JSON.toJSONString(skuName));
    }

}
