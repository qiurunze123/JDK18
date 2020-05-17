package com.geekq.entity;

/**
 * @author 邱润泽 GeekQ
 * @date 2020/4/20 0020
 **/
public class StudentComparator {

    public int compareStudentByScore(Student student1,Student student2){
        return student2.getScore() - student1.getScore();
    }
}
