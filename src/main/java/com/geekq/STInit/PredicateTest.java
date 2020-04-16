package com.geekq.STInit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 邱润泽 bullock
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = s->s.length()>5;
        System.out.println(predicate.test("heo"));
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest  predicateTest = new PredicateTest();
        List<Integer> resultL = predicateTest.conditionFilter(list,integer -> integer>5);
        resultL.forEach(resultK-> System.out.println(resultK));
    }

    public List<Integer> conditionFilter(List<Integer> list,Predicate<Integer> predicate){

        return  list.stream().filter(predicate).collect(Collectors.toList());

    }
}
