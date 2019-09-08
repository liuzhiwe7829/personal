package designPattern.structure.decorator.javaIODemo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhiwei.liu003
 * @date 2019/9/821:15
 */
public class MyTest {
    public static void main(String[] args) throws IOException{
        InputStream in = new UpperCaseInputStream(new BufferedInputStream(new FileInputStream("D://CrackCaptcha.log")));
        int len;
        while((len = in.read()) >= 0)
            System.out.println((char)(len));
        in.close();
    }
}
