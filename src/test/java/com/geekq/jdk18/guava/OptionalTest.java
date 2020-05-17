package com.geekq.jdk18.guava;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import jdk.nashorn.internal.runtime.options.Option;
import net.minidev.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 轩北
 * @date 2020/5/4 12:25 下午
 */
public class OptionalTest {

    @Test
    public void test() throws Throwable {
        /**
         * 三种创建optional 对象方式
         */
        Optional.empty();

//        Optional.of(null);

        //使用任意值创建optional对象
        Optional optional = Optional.ofNullable("zhangsan");
        /**
         * 判断是否引用缺失的方法
         * 避免使用
         */
        optional.isPresent();

        /**
         * 当optional 引用存在时执行
         * 类似的方法 map filter flatmap
         */
        optional.ifPresent(System.out::println);

        /**
         * 引用缺失时 执行
         */

        optional.orElse("引用缺失");

        optional.orElseGet(()->{
            return "自定义";
        });

        optional.orElseThrow(()->{
            throw new RuntimeException("引用缺失异常");
        });

    }


    public void  listStreamTest1(List<String>  list){

        Optional.ofNullable(list)
                .map(list1->list1.stream())
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

    @Test
    public void  listStreamTest(){

        List<String> li = new ArrayList<>();
        li.add("1111");
        listStreamTest1(li);
    }
}
