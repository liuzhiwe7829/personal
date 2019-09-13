package pattern.structure.proxy.cglibDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1015:35
 */
public class MyCglibFactory implements MethodInterceptor {

    private Tank target;

    public MyCglibFactory(Tank target) {
        this.target = target;
    }
    public Tank myCglibCreator(){
        Enhancer enhancer = new Enhancer();
        //设置需要代理的对象：目标（target),也是父类
        enhancer.setSuperclass(Tank.class);
        //设置代理对象，回调涉及模式：设置回调接口对象
        enhancer.setCallback(this);

        return (Tank)enhancer.create();
    }

    /**
     * 回调方法
     * @param o
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start time : " + start);
        method.invoke(target,args);
        long end = System.currentTimeMillis();
        System.out.println("end time : " + end);
        System.out.println("spend all time : "+ (end -start) /1000 + "s.");
        return null;
    }
}
