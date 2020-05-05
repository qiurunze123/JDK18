package com.geekq.jdk18.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Chars;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 轩北
 * @date 2020/5/5 10:46 上午
 */
public class ImmutableTest {

    /**
     * 引用传递
     * @param list
     */
    public static void test(List<Integer> list){

        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList = Collections.unmodifiableList(list);
        test(newList);
        System.out.println(list);
    }

    public void immutableTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /**
         * 三种方式创建ImmutableSet 没有元素顺序的arrayList视角
         */
        ImmutableSet immutableSet = ImmutableSet.copyOf(list);
        ImmutableSet immutableSet2 = ImmutableSet.of(1,2,3);
        /**
         * 以build方式创建
         */
        ImmutableSet.builder().add(1).addAll(Sets.newHashSet(2,3))
                .add(4)
                .build();
    }
    private static final String text =
            "《南陵别儿童入京》" +
                    "白酒新熟山中归，黄鸡啄黍秋正肥。" +
                    "呼童烹鸡酌白酒，儿女嬉笑牵人衣。" +
                    "高歌取醉欲自慰，起舞落日争光辉。" +
                    "游说万乘苦不早，著鞭跨马涉远道。" +
                    "会稽愚妇轻买臣，余亦辞家西入秦。" +
                    "仰天大笑出门去，我辈岂是蓬蒿人。";
    /**
     * 实战 使用Multiset 来实现统计一篇文章中出现的文字的次数功能
     */
    @Test
    public void multisetTest(){

        Multiset<Character> multiset = HashMultiset.create();

        //string 转换成 char 数组
        char[] chars = text.toCharArray();

        Chars.asList(chars).stream()
                .forEach(charItem->multiset.add(charItem));

        System.out.println("size :" + multiset.size());
        System.out.println("count :" + multiset.count('人'));



    }
}
