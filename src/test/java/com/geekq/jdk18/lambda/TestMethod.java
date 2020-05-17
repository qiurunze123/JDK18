package com.geekq.jdk18.lambda;

import com.geekq.entity.Student;
import com.geekq.entity.StudentComparator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/20
 **/
@Slf4j
public class TestMethod {


    @Test
    public void  testMethod(){
        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",80);
        Student student4 = new Student("zhaoliu",90);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        students.sort((o1, o2) -> o1.getScore() - o2.getScore());
        students.forEach(student -> System.out.println(student.getScore()));
    }

    @Test
    public void  testMethod1(){
        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",80);
        Student student4 = new Student("zhaoliu",90);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);
        List<Student> students1 = students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        students1.forEach(student -> System.out.println(student.getScore()));
    }
}
