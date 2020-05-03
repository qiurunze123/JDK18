package com.geekq.jdk18.STinit.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.jdk18.lambdashow.cart.CartService;
import com.geekq.jdk18.lambdashow.cart.Sku;
import com.geekq.jdk18.lambdashow.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JsonbTester;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author 轩北
 * @date 2020/5/1 10:52 下午
 */
public class StreamOperator {

    List<Sku> list;
    @Before
    public void init(){
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterTest(){
        list.stream().
                filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * map 的使用操作
     */
    @Test
    public void mapTest(){

        list.stream()
                /**
                 * 将一个sku对象转换成了一个string
                 */
                .map(sku -> sku.getSkuName())
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * 讲一个对象转换成流 3-13
     */
    @Test
    public void flatMapTest(){

        list.stream()

                /**
                 * 切割成一个字符流
                 */
                .flatMap(sku ->Arrays.stream(sku.getSkuName().split("")))
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    @Test
    public void peek(){
        list.stream()
                //中间操作 peek
                .peek(sku -> System.out.println(sku.getSkuName()))

                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));

    }

    /**
     * sort 对流中元素进行排序 可选择自然排序或指定排序规则
     */
    @Test
    public void sortTest(){

        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))

                //有状态的操作 和 无状态的操作区别  会影响数据的排序
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));


    }


    /**
     * distinct 对流元素进行去重
     */
    @Test
    public void distinctTest(){
        list.stream().map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));

    }


    /**
     * skip 跳过前n条记录
     */
    @Test
    public void skipTest(){
        list.stream()

                .sorted(Comparator.comparing(Sku::getTotalPrice))

                .skip(3)

                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }


    /**
     * limit 截断前n条
     */
    @Test
    public void limitTest(){

        list.stream().sorted(Comparator.comparing(Sku::getTotalPrice))

                .limit(3)

                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     * 可以进行分页 结合起来的话 for example
     *
     * skip 0 * 3
     * skip 1 * 3
     * skip 2 * 3
     */
    @Test
    public void limitSkipTest(){

        list.stream().sorted(Comparator.comparing(Sku::getTotalPrice))

                .skip(1 * 3)

                .limit(3)

                .forEach(item-> System.out.println(JSON.toJSONString(item,true)));
    }

    /**
     *  allmatch 终端 操作 也是一个短路操作
     *
     *  所有元素匹配返回true
     */
    @Test
    public void allMatchTest(){
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                // allmatch 终端 操作 也是一个短路操作
                .allMatch(sku -> sku.getTotalPrice()>100);

        System.out.println(match);
    }


    /**
     * anymatch 任何元素匹配 返回true
     */
    @Test
    public void anyMatchTest(){
        boolean  match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))

                .anyMatch(sku -> sku.getTotalPrice()>100);
        System.out.println(match);
    }


    /**
     * 任何元素都不匹配返回true
     */
    @Test
    public  void  noneMatchTest(){
        boolean match = list.stream()

                .peek(sku -> System.out.println(sku.getSkuName()))

                .noneMatch(sku -> sku.getTotalPrice()>10_000);

        System.out.println(match);

    }

    /**
     * ***************  findfisrt  findany 在并行的操作上有区别 **********************
     */


    @Test
    public void findFirstTest(){

        Optional<Sku> optionalSku = list.stream()
                .findFirst();
        System.out.println(JSON.toJSONString(optionalSku.get(),true));
    }

    @Test
    public void findAnyTest(){

        Optional<Sku> optionalSku = list.stream().findAny();

        System.out.println(JSON.toJSONString(optionalSku.get(),true));

    }

    @Test
    public void maxTest(){

        OptionalDouble optionalDouble = list.stream()

                .mapToDouble(Sku::getTotalPrice)

                .max();

        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void minTest(){

        OptionalDouble optionalDouble = list.stream()

                .mapToDouble(Sku::getTotalPrice)

                .min();

        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void countTest(){
      long count =   list.stream().count();

        System.out.println(count);
    }


}
