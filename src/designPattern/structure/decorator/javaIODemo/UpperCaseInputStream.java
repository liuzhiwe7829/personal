package designPattern.structure.decorator.javaIODemo;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhiwei.liu003
 * @date 2019/9/813:18
 */
public class UpperCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    //实现两个read()方法，将大写转化成小写的读入
    @Override
    public int read() throws IOException {
        int index = super.read();
        return index == -1 ? index : Character.toUpperCase((char) (index));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int index = super.read(b, off, len);
        for (int i = 0; i < index; i++) {
            b[i] = (byte) Character.toUpperCase((char) (b[i]));
        }
        return index;
    }
}
