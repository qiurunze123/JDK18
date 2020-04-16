package com.geekq.STInit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author 邱润泽 bullock
 */
public class FunctionTest1 {

    public static void main(String[] args) {
        FunctionTest1 functionTest = new FunctionTest1();
        int result2 = functionTest.compute(5,num->num+2);
        System.out.println(result2);


        List<String> list = Arrays.asList("hello","world","helloworld");


        Stream<String> list1 = list.stream().filter(s->s.length()>5).map(s->s.toUpperCase());


        list1.forEach(item -> System.out.println(item));
    }


    public int compute(int i , Function<Integer,Integer> function){

        Integer result = function.apply(i);

        return result;
    }

}
