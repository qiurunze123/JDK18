package com.geekq.jdk18.stream;

import com.alibaba.fastjson.JSON;
import com.geekq.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/20 0020
 **/
@Slf4j
public class TestStream {

    /**
     * 流操作 所有的流操作会被组合到一个 stream pipeline中
     * 这点类似linux中的pipeline概念，将多个简单操作连接在一起组成一个功能强大的操作
     * 一个 stream pileline首先会有一个数据源，这个数据源可能是数组、集合、生成器函数或是IO通道
     * 流操作过程中并不会修改源中的数据；然后还有零个或多个中间操作，每个中间操作会将接收到的流转换成另一个流（比如filter）
     * 最后还有一个终止操作，会生成一个最终结果（比如sum）。流是一种惰性操作，所有对源数据的计算只在终止操作被初始化的时候才会执行
     */
    @Test
    public void testStream() {
//第一种 通过Stream接口的of静态方法创建一个流
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//第二种 通过Arrays类的stream方法，实际上第一种of方法底层也是调用的Arrays.stream(values);
        String[] array = new String[]{"hello", "world", "helloworld"};
        Stream<String> stream3 = Arrays.stream(array);
//第三种 通过集合的stream方法，该方法是Collection接口的默认方法，所有集合都继承了该方法
        Stream<String> stream2 = Arrays.asList("hello", "world", "helloworld").stream();
    }


    @Test
    public void testStream1() {
        List<String> list = Arrays.asList("hell","world","helloworld");
        List<String> listS =list.stream().filter(s -> s.length()>=5).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(listS));

    }


    @Test
    public void testStream2() {
        List<String> list = Arrays.asList("hell","world","world");
        Set<String> listS =list.stream().filter(s -> s.length()>=5).map(s -> s.toUpperCase()).collect(Collectors.toSet());
        System.out.println(JSON.toJSONString(listS));
    }

    /**
     * 使用UUID.randomUUID()::toString 方法引用的方式创建了Supplier，然后取出第一个元素，
     * 这里的findFirst返回的是 Optional，因为流中有可能没有元素，
     * 为了避免空指针，在使用前 ifPresent 进行是否存在的判断。
     */
    @Test
    public void testStream3() {
        Stream.generate(UUID.randomUUID()::toString).findFirst().ifPresent(System.out::println);
        Stream.iterate(1,item -> item + 2).limit(10).forEach(System.out::println);
        //Stream陷阱 distinct()会一直等待产生的结果去重，将distinct()和limit(6)调换位置，先限制结果集再去重就可以了
//        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        //去重
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);

    }


    @Test
    public void testStream4() {

        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("zhangsan",80);
        Student student4 = new Student("zhaoliu",90);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(JSON.toJSONString(collect));
    }


}
