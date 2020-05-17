package com.geekq.jdk18.lambda;

import com.alibaba.fastjson.JSON;
import com.geekq.STInit.PredicateTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19 0019 22:04
 **/
@Slf4j
public class TestPredicate {

    @Test
    public void testPre(){
        Predicate<String> predicate = s ->s.length()>5;
        log.info(String.valueOf(predicate.test("hello")));
    }

    /**
     * 这段程序的逻辑是找到集合里大于5的数据，打印到控制台
     */
    @Test
    public void testPre1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list1 = new ArrayList<>();
        list.stream().forEach(item->{
            if(item>5) {
                list1.add(item);
            }
        });

        System.out.println(JSON.toJSONString(list1));
    }

    /**
     * 这段程序的逻辑是找到集合里大于5的数据，打印到控制台
     */
    @Test
    public void testPre2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = TestPredicate.conditionFilter(list, integer -> integer > 5);
        result.forEach(System.out::println);

    }
    @Test
    public void testPre3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //输出大于5的数字
        List<Integer> result = TestPredicate.conditionFilter(list, integer -> integer > 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出大于等于5的数字
        result = TestPredicate.conditionFilter(list, integer -> integer >= 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出小于8的数字
        result = TestPredicate.conditionFilter(list, integer -> integer < 8);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出所有数字
        result = TestPredicate.conditionFilter(list, integer -> true);
        result.forEach(System.out::println);
        System.out.println("-------");
        TestPredicate.conditionFilterNegate(list, integer -> true);
        System.out.println("-------");

        System.out.println(Predicate.isEqual("test").test("test"));//true


    }

    /**
     * 第一个参数是待遍历的集合，第二个参数是Predicate类型的实例，还记得Predicate接口中的抽象方法定义吗，
     * 接收一个参数返回布尔类型。list.stream()是创建了一个针对此集合的Stream对象（先简单认识一下），
     * 然后调用Stream的filter方法对结果进行过滤
     * ，过滤的条件就是Predicate接口的实现，最后collect(Collectors.toList());是将过滤后的结果收集起来放置到一个新的集合中并返回
     * @param list
     * @param predicate
     * @return
     */
    public static  List<Integer>  conditionFilter(List<Integer> list , Predicate<Integer> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     *
     * and方法接收一个Predicate类型，也就是将传入的条件和当前条件以并且的关系过滤数据。
     * or方法同样接收一个Predicate类型，将传入的条件和当前的条件以或者的关系过滤数据
     * negate就是将当前条件取反。看下具体使用方式
     * @param list
     * @param predicate
     * @return
     */
    public static List<Integer> conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().filter(predicate.negate()).collect(Collectors.toList());
    }

    public static  List<Integer> conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate,Predicate<Integer> predicate2){
        return list.stream().filter(predicate.and(predicate2)).collect(Collectors.toList());
    }

    public static List<Integer> conditionFilterOr(List<Integer> list, Predicate<Integer> predicate,Predicate<Integer> predicate2){
        return list.stream().filter(predicate.or(predicate2)).collect(Collectors.toList());
    }
}
