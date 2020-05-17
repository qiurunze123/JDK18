package com.geekq.jdk18.STinit.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 轩北
 * @date 2020/5/3 9:37 下午
 */
public class StreamConstructor {

    @Test
    public void streamFromValue(){
        Stream stream = Stream.of(1,2,3,4,5);

        stream.forEach(item-> System.out.println(item));
    }

    @Test
    public void streamFromArray(){

        int[] number = {1,2,3,4,5};

        IntStream stream = Arrays.stream(number);

        stream.forEach(item-> System.out.println(item));
    }

    @Test
    public void streamFromFile() throws IOException {
       Stream<String> stringStream =  Files.lines(Paths.get(""));
       stringStream.forEach(System.out::println);
    }

    @Test
    public void streamFromFunction(){
        Stream stream = Stream.iterate(0,n->n+2);
        stream.forEach(System.out::println);

        Stream stream1 = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);


    }

}
