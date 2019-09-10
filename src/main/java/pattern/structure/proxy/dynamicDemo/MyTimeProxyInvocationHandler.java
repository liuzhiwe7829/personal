package pattern.structure.proxy.dynamicDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhiwei.liu003
 * @date 2019/9/100:11
 */
public class MyTimeProxyInvocationHandler implements InvocationHandler {

    private Object target; //此处为Object 非 movable或 Flyable


    public MyTimeProxyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy：代理对象  一切对象
     * @param method：目标方法
     * @param args：目标方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start time : " + start);
        //调用目标方法  invoke 调用
        method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("end time : " + end);
        System.out.println("spend all time :" + (end - start));
        return null;
    }
}
