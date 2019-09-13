package pattern.structure.proxy.dynamicDemo;
import java.lang.reflect.Method;
public class My$Proxy0 implements pattern.structure.proxy.dynamicDemo.Flyable{
    pattern.structure.proxy.dynamicDemo.MyInvocationHandler h;
    public My$Proxy0(MyInvocationHandler h) {
        this.h = h;
    }
    @Override
    public void fly(){
       try {
           Method md = pattern.structure.proxy.dynamicDemo.Flyable.class.getMethod("fly");
           h.invoke(this, md);
       }catch(Exception e) {
           e.printStackTrace();
       }
   }
}