package pattern.structure.proxy.dynamicDemo;

import java.lang.reflect.Method;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1017:18
 * 能处理任何方法的 调用 提供一个 Method就能对这个方法进行特殊处理
 * 特殊处理的方式是由子类（实现类) 决定
 */
public interface MyInvocationHandler {
    void  invoke(Object o, Method m);
}
