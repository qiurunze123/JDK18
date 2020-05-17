package com.geekq.jdk18.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/19 0019 22:29
 *
 *
 **/
@Slf4j
public class TestFunction {

    /**
     * 除了apply这个抽象方法，Function接口中还内置了两个比较常用的默认方法
     * compose方法接收一个Function参数before，该方法说明是返回一个组合的函数，首先会应用before，
     * 然后应用当前对象，换句话说就是先执行before对象的apply，再执行当前对象的apply，将两个执行逻辑串起来。
     * andThen方法接收一个Function参数after，与compose方法相反，它是先执行当前对象的apply方法，再执行after对象的方法
     */
    @Test
    public void TestFunction(){

    }
}
