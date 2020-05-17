package com.geekq.jdk18.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示如何使用流(Source)与汇(Sink)来对文件进行常用操作
 *
 *
 */
public class IOTest {


    @Test
    public void copyFile() throws IOException {
        /**
         * 创建对应的Source和Sink
         */
        CharSource charSource = Files.asCharSource(
                new File("SourceText.txt"),
                Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(
                new File("TargetText.txt"),
                Charsets.UTF_8);

        /**
         * 拷贝
         */
        charSource.copyTo(charSink);

        /***
         *
         * 还有许多 files 文件操作方式
         */

    }

}
