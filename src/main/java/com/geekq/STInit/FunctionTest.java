package com.geekq.STInit;

/**
 * @author 邱润泽 bullock
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        int i2 = functionTest.add2(2);
        int i3 = functionTest.add3(2);
        int i4 = functionTest.add4(2);
    }

    //逻辑提前定义好
    public int add2(int i) {
        return i + 2;
    }

    //逻辑提前定义好
    public int add3(int i) {
        return i + 3;
    }

    //逻辑提前定义好
    public int add4(int i) {
        return i + 4;
    }


}
