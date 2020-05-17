package com.geekq.jdk18.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19 0019 22:49
 **/
@Slf4j
public class TestOptional {

    /**
     *   Optional类如何避免空指针问题
     *
     *   ofNullable方法接收一个可能为null的参数，将参数的值赋给Optional类中的成员变量value
     *   ifPresent方法接收一个Consumer类型函数式接口实例，
     *   再将成员变量value交给Consumer的accept方法处理前
     *   会校验成员变量value是否为null，如果value是null，
     *   则什么也不会执行，避免了空指针问题。下方是ifPresent源码
     */
    @Test
    public void TestOptional(){
        String str = "hello";
        Optional<String> optional = Optional.ofNullable(null);
        optional.ifPresent(s -> System.out.println(s));//value为hello，正常输出
    }

    /**
     * 为空想返回一个默认值
     */
    @Test
    public void TestOptional1(){
        String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.orElseGet(() -> "welcome"));
    }
}
