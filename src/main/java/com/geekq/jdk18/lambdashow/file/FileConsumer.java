package com.geekq.jdk18.lambdashow.file;

/**
 * @author 轩北
 * @date 2020/5/1 10:48 上午
 *
 * 文件处理函数式接口
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     * @param fileContent 文件内容字符串
     */
    void fileHandler(String fileContent);
}
