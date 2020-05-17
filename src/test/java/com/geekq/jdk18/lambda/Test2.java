package com.geekq.jdk18.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19  21:58
 **/
public class Test2 {


    /**
     * version 1
     */
    @Test
    public void Test1(){
        Test2 test2 = new Test2();
        int i2 = test2.add2(2);
        int i3 = test2.add3(2);
        int i4 = test2.add4(2);
        System.out.println(i2+i3+i4);
    }




    /**
     * version 2
     */
    @Test
    public void Test2(){
        Test2 test2 = new Test2();
        int result2 = test2.compute(5, num -> num + 2);
        int result3 = test2.compute(5, num -> num + 2);
        int result4 = test2.compute(5, num -> num + 2);
        int results = test2.compute(5, num -> num * num);
        System.out.println(results);
    }


    public int compute(int i, Function<Integer,Integer> function){
        Integer result = function.apply(i);
        return result;
    }


    //逻辑提前定义好
    public int add2(int i){
        return i + 2;
    }

    //逻辑提前定义好
    public int add3(int i){
        return i + 3;
    }

    //逻辑提前定义好
    public int add4(int i){
        return i + 4;
    }
}
