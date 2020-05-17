package com.geekq.jdk18.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19 0019 21:34
 **/
public class Test1 {


    /**
     * 一个接口，有且仅有一个抽象方法，被@FunctionalInterface修饰，典型的函数式接口
     *
     * lambda表达式来创建一个函数式接口实例
     * 那这个lambda表达式的入参和返回必须符合这个函数式接口中唯一的抽象方法的定义
     *
     * 创建函数式接口类型的三种方式：
     * 1.lambda表达式
     * 2.方法引用
     * 3.构造方法引用
     * 注意：无论是哪种方式，必须要符合抽象方法的方法定义
     */
    @Test
    public void  test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.forEach(item -> System.out.println(item));
    }
}
