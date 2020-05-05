package com.geekq.jdk18.guava;

/**
 * @author 轩北
 * @date 2020/5/4 12:23 下午
 *
 *
 * null 是表明的是某种确实的情况
 *
 * guava optional 作为一个新的特性引入到Java8 中
 *
 * jdk 8 也有
 *
 * guava
 * 不可变对象
 * 当对象被不可信库 调用时不可变形式是安全的
 * 不可变对象 对多个线程调用时 不存在竞态条件问题
 * 不可变集合不需要考虑变化 因此可以节约空间和时间
 * 不可变固定不变可作为常量安全使用
 *
 * ******* 创建不可变集合的三种方式 *******
 *
 * copyof ImmutableSet.copyOf(set)
 * of 方法 ImmutableSet.of("a","b","c")
 * Builder 工具 ImmutableSet.builder().build()
 *
 *
 * *********对流的操作 **********
 *
 * 源是可读的  ByteSource / charSource
 *
 * 汇是可写的 ByteSink / charSink
 *
 */
public class GuavaInit {
}
