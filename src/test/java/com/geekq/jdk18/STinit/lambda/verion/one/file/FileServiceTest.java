package com.geekq.jdk18.STinit.lambda.verion.one.file;

import com.geekq.jdk18.lambdashow.file.FileService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author 轩北
 * @date 2020/5/1 10:55 上午
 */
public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        fileService.fileHandle("/Users/qiurunze/Documents/project/JDK18/" +
                "src/test/java/com/geekq/jdk18/STinit/lambda/verion" +
                "/one/file/FileServiceTest.java",fileContent -> {
            System.out.println(fileContent);
        });
    }
}
