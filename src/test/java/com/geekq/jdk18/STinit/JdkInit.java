package com.geekq.jdk18.STinit;

/**
 * 如何进行高效的编程
 * -----------------------------------
 * let's go !!!
 * 函数式编程
 * 流程编程
 * 线程池精进
 * 资源关闭
 * 工具集
 * 验证框架
 * 实用工具
 * 开发工具
 * 自测工具
 * -----------------------------------
 *
 * Java8 引入函数式编程风格
 *
 * 可以理解为一种匿名函数的代替
 *
 * 通过行为参数化传递代码
 * -------------------------------------
 *  lambda表达形式
 * （parameters） -> expression
 *  (parameters) -> {statement;}
 *
 *  形式1 没有参数
 *  （）-> System.out.println(" hello world ");
 *  形式2 只有一个参数
 *  name -> 表达式
 *  形式三  没有参数 但是逻辑复杂
 *  （）-> {System.out.println(" hello ");
 *         System.out.pringln(" wolrd ");
 *          }
 *   形式四 含有俩个参数的方法
 *   BinaryOperator<Long > functionAdd = (x,y) -> x+y ;
 *   Long result = fuctionAdd.apply(1L,2L);
 *
 *   形式五 对参数显示声明（声不声明都可以）
 *   ******  函数式接口 ********
 *   接口中只有一个抽象方法
 *   Java8 的函数式接口 注解： @FunctionInterface
 *   函数式接口的抽象方法签名 ： 函数式描述符
 *
 *   ******* 常用接口及使用  JDK 提供的泛化接口  ********
 *   Predicate<T>
 *   Consumer<T>
 *   Function<T,R>
 *   Supplier<T>
 *   UnaryOperator<T>
 *   BinaryOperator<T>
 *
 *   ***** 方法引用 215 ******
 *
 *   调用特定方法的lambda表达式的快捷写法 可以让你重复使用现有的方法定义
 *
 *
 *   ***** stream 流编程 *****
 *
 *   实战分别使用集合操作及流操作完成对实际应用场景中数据处理 直观感受流操作带来的便捷性
 *
 *   支持数据处理操作的源生成的元素序列
 *
 *   ******** 流的组成 *********
 *
 *   cart --- filter --- sorted ---- map --- collect
 *   数据源    ｜ 中间操作                ｜    终端操作
 *
 *   ****** 流的构建 *******
 *
 *   1.由值创建流
 *   2.由数组创建流
 *   3.由文件生成流
 *   4.由函数生成流 （无限流）
 *
 *   ******* 收集器 *******
 *
 *   将流的元素累积成一个结果
 *   作用于终端操作collect上
 *   collect collector collectors
 *
 *   预定义收集器功能
 *
 *   将流元素规约和汇总为一个值
 *   将流元素分组
 *   将流元素分区
 *
 */
public class JdkInit {



}
