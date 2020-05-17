package com.geekq.jdk18.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19 0019 22:21
 **/
@Slf4j
public class TestStreamApi {

    /**
     * 存在一个字符串集合，我们想把所有长度大于5的字符串转换成大写输出到控制台
     * version 1
     */
    @Test
    public void TestStreamApi(){
        List<String> list = Arrays.asList("hello","world","helloworld");

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).length() > 5){
                System.out.println(list.get(i).toUpperCase());
            }
        }
    }

    /**
     * version 2   存在一个字符串集合，我们想把所有长度大于5的字符串转换成大写输出到控制台
     *
     * filter方法，接收一个Predicate函数式接口类型作为参数，并返回一个Stream对象，从上一篇我们知道可以由一个接收一个参数返回布尔类型的lambda表达式来创建Predicate函数式接口实例，所以看到filter接收的参数是s -> s.length() > 5
     *
     * map方法，接收Function函数式接口类型，接收一个参数，有返回值s -> s.toUpperCase() 正是做了这件事情
     *
     * forEach方法，接收Consumer函数式接口类型，接收一个参数，不返回值 这里使用方法引用的其中一种形式System.out::println来创建了Consumer实例。
     */
    @Test
    public void TestStreamApi2(){
        List<String> list = Arrays.asList("hello","world","helloworld");
        list.stream().filter(item->item.length()>5).map(s->s.toUpperCase()).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 交给新的集合
     */
    @Test
    public void TestStreamApi3(){
        String  abc = null;

        Optional cookiesV =  Optional.ofNullable(abc);
        cookiesV.orElseGet(()->{
            log.error(" ***cookies 为null! 请登录***");
            return null;
        });
        List<String> list = Arrays.asList();
        List<String> listNew =  new ArrayList<>();
        list.stream().filter(item->item.length()>5).map(s->s.length()).collect(Collectors.toList())
                .forEach(System.out::println);
        listNew.stream().forEach(System.out::println);
    }


    @Test
    public void TestStreamApi4(){
        Cookie c1 =  new Cookie("1","1");
        Cookie c2 =  new Cookie("2","2");
        Cookie c3 =  new Cookie("3","3");
        Cookie c4 =  new Cookie("4","4");

        Cookie[] cookies = null;
        Optional cookiesV =  Optional.ofNullable(cookies);
        List<String> tokens =  Arrays.asList(cookies).stream().
                filter(cookie -> cookie.getName().equals("5"))
                .map(cookie -> cookie.getValue())
                .collect(Collectors.toList());
        System.out.println(tokens);

    }


}
