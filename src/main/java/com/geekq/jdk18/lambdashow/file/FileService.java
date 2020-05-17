package com.geekq.jdk18.lambdashow.file;

import java.io.*;

/**
 * @author 轩北
 * @date 2020/5/1 10:48 上午
 * 文件服务类 work
 */
public class FileService {

    /**
     * 通过URL 获取本地文件内容 调用函数式接口 处理
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url , FileConsumer fileConsumer) throws IOException {
      BufferedReader bufferedReader =
              new BufferedReader(new InputStreamReader(new FileInputStream(url)));

      String line ;

      StringBuilder stringBuilder = new StringBuilder();

      while((line = bufferedReader.readLine())!=null){
          stringBuilder.append(line+"\n");
      }
      //调用函数式接口方法 讲文件内容传递给lambda表达式 实现业务逻辑
      fileConsumer.fileHandler(stringBuilder.toString());

    }
}
