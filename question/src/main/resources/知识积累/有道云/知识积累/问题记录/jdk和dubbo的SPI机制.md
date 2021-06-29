[toc]
##### 一：SPI是什么
```
service provider Interface 服务提供接口，jdk1.6中开始提供，
使用：在META/services/xx文件，配置一个文件，文件名为接口的全路径名称，内容为具体的实现类全路径名。
jdk将会使用ServiceLoader.load()方法去解析和加载接口和其中的实现类，按需执行不通的方法。

例如jdbc中，jdk提供driver接口，不通厂商实现方式不同，mysql、oracle ，在对数据库驱动driver实现方式上，可以采用spi机制。
mysql-contactor.jar包中会在META/services路径下，拓展了java.sql.Driver接口，jdk会在META/services路径下扫描改文件，加载msql的实现类
```
![image](B4530207B9074F52A12BF1641107FDFF)
##### 二：jdk的SPI
###### 2.1 设计接口和实现类
```
public interface Animal {
    void sound ();
}

---

public class Cat implements Animal{
    public void sound(){
        System.out.println("小喵在叫");
    }
}
---

public class Dog implements Animal{
    public void sound(){
        System.out.println("狗在叫");
    }
}
```
###### 2.2 配置META-INF类
![image](CB7C89D209E249059FE60A0DE5EECBE7)
###### 2.3 读取配置
```
public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        final Iterator<Animal> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Animal next =  iterator.next();
            next.sound();
        }
    }
}
```
##### 2.4 原理
```
graph LR
A(ServiceLoader) -->B[上下文类加载器] 
B -->C[懒加载器]
C-->D[config]
D-->E(解析器和类加载)
```
##### 2.5 缺点
```
①无法按需加载。虽然 ServiceLoader
 做了延迟载入，使用了LazyIterator,但是基本只能通过遍历全部获取，
 接口的实现类得全部载入并实例化一遍。
 如果你并不想用某些实现类，或者某些类实例化很耗时，它也被载入并实例化了,
 假如我只需要其中一个,其它的并不需要这就形成了一定的资源消耗浪费

②不具有IOC的功能,假如我有一个实现类,如何将它注入到我的容器中呢，类之间依赖关系如何完成呢？

③serviceLoader不是线程安全的,会出现线程安全的问题
```





##### 三：dubbo的SPI
```
dubbo在原有的spi基础上主要有以下的改变,
①配置文件采用键值对配置的方式，使用起来更加灵活和简单
② 增强了原本SPI的功能，使得SPI具备ioc和aop的功能，这在原本的java中spi是不支持的。
dubbo的spi是通过ExtensionLoader来解析的，
通过ExtensionLoader来加载指定的实现类，配置文件的路径在META-INF/dubbo路径下
```
###### 3.1dubbo 负载均衡机制
```
3.1：dubbo的负载均衡机制其中就采用了spi机制,
选择哪个负载均衡策略是通过@SPI注解来实现的：

利用ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(name)
来获取具体的LoadBalance的实现类,
其中name是对应配置文件(见下文)中的键；
```
![image](77599B5CE0484716BBD6B9CEA68BD05F)
![image](47501EFC0E8E48598BE19F764397D093)

---
##### 3.2 dubbo的META_INF
```
com.alibaba.dubbo.rpc.cluster.LoadBalance
dubbo的spi配置是采用键值对的方式,
键值对最大的好处就是可以以键来获取值，取值比较简单和方便。
```
```
random=com.alibaba.dubbo.rpc.cluster.loadbalance.RandomLoadBalance
roundrobin=com.alibaba.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance
leastactive=com.alibaba.dubbo.rpc.cluster.loadbalance.LeastActiveLoadBalance
consistenthash=com.alibaba.dubbo.rpc.cluster.loadbalance.ConsistentHashLoadBalance
```
```
graph LR
A[注解SPI]-->B[ExtensionLoader]
B-->C[loadBalance]
```
###### 3.3 @SPI和@Adaptive注解的作用是什么
```
Dubbo 通过注解@Adaptive 作为标记实现了一个适配器类，dubbo将会为这个动态类生成代理对象;
ExtensionLoader中默认实现类或者通过实现类名称（@SPI注解指定的名称）来获取实现类
为什么会出现@Adaptive注解？
主要原始是因为dubbo的加载拓展是为了从配置文件加载，很动态，但是实现类却要固定写死或者灵活实现，所以就要区分开。用@Adaptive表示由框架自己生成，不需要人为实现。
在dubbo加载SPI时会动态创建SPIAdaptive实现ExtensionLoader。从URL获取密钥，改密钥通过@Adaptive呦接口定义的注释提供
```
###### 3.4 dubbo的spi读取配置和实现原理
###### 3.4.1 流程图
```
graph TB
    subgraph   创建新的Extension 
     a2[getExtensionClasses]-->b2[反射创建拓展对象]
     b2-->c2[IOC injectExtension]
     c2-->d2[包裹Wrapper]
    end
    subgraph 主
    A(getExtension)-->B(getOrCreateHolder)
    B-->C[双重锁校验 createExtension]
    end 
```
###### 3.4.2 源码解析
```
ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(Constants.DEFAULT_LOADBALANCE)
```
###### 3.4.2.1 getExtension
```
    /** 根据指定参数获取Extension拓展信息
     * Find the extension with the given name. If the specified name is not found, then {@link IllegalStateException}
     * will be thrown.
     */
   public T getExtension(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Extension name == null");//参数校验
        }
        if ("true".equals(name)) { //获取默认拓展
            return getDefaultExtension();
        }
        //从缓存中获取 holder
        final Holder<Object> holder = getOrCreateHolder(name);
        Object instance = holder.get();
        if (instance == null) {//双重锁校验holder获取实现的实例
            synchronized (holder) {
                instance = holder.get();
                if (instance == null) {
                    instance = createExtension(name);//创建新的Extension
                    holder.set(instance);
                }
            }
        }
        return (T) instance;
    }

```
###### 3.4.2.2 getOrCreateHolder
```

private Holder<Object> getOrCreateHolder(String name) {
        Holder<Object> holder = cachedInstances.get(name);
        if (holder == null) {
            cachedInstances.putIfAbsent(name, new Holder<>());
            holder = cachedInstances.get(name);
        }
        return holder;
    }
```
###### 3.4.2.3 createExtension
```
private T createExtension(String name) {
        //根据建再取配置的类文件路径下读取接口实现类的class
        Class<?> clazz = getExtensionClasses().get(name);
        if (clazz == null) {
            throw findException(name);
        }
        try {
            T instance = (T) EXTENSION_INSTANCES.get(clazz);
            if (instance == null) {
                EXTENSION_INSTANCES.putIfAbsent(clazz, clazz.newInstance());
                //利用dubbo的IOC注入接口实现类的实例
                instance = (T) EXTENSION_INSTANCES.get(clazz);
            }
            injectExtension(instance);
            Set<Class<?>> wrapperClasses = cachedWrapperClasses;
            if (CollectionUtils.isNotEmpty(wrapperClasses)) {
             //循环wrapper的实例
                for (Class<?> wrapperClass : wrapperClasses) {
                    instance = injectExtension((T) wrapperClass.getConstructor(type).newInstance(instance));
                    //将当前的instance作为参数传给wrapper实例，通过反射创建wrapper,向wrapper实例中注入依赖，最后将wrapper实例再次赋值instance实例变量
                }
            }
            return instance;
        } catch (Throwable t) {
            throw new IllegalStateException("Extension instance (name: " + name + ", class: " +
                    type + ") couldn't be instantiated: " + t.getMessage(), t);
        }
    }
```
###### 3.5 dubbo的IOC机制
```
dubbo的IOC是通过setter方法来实现注入的,
通过遍历对象实例的所有方法,找到其setter方法在进行截取，
从objectFactory中获取扩展类再进行反射执行。
这样的话,就算实现实例中有依赖的扩展实例，都可以注入完成，
是dubbo的IOC体现。ojectFactory 变量的类型为 AdaptiveExtensionFactory，
AdaptiveExtensionFactory 内部维护了一个 ExtensionFactory 列表
，用于存储其他类型的 ExtensionFactory。
```
```
private T injectExtension(T instance) {
        if (objectFactory == null) {
            return instance;
        }
        try {
        //反射获取所有的实例方法
            for (Method method : instance.getClass().getMethods()) {
                if (!isSetter(method)) { //找到set方法，并且参数长度大于1
                    continue;
                }
                /**遇到@DisableInject直接跳过
                 */
                if (method.getAnnotation(DisableInject.class) != null) {
                    continue;
                }
                Class<?> pt = method.getParameterTypes()[0];
                if (ReflectUtils.isPrimitives(pt)) {
                    continue;
                }
                try {
                //set方法中截取对象名称
                    String property = getSetterProperty(method);
                    Object object = objectFactory.getExtension(pt, property);
                    //从对象工厂中根据对象名称获取拓展类
                    if (object != null) {
                    //反射调用
                        method.invoke(instance, object);
                    }
                } catch (Exception e) {
                    logger.error("Failed to inject via method " + method.getName()
                            + " of interface " + type.getName() + ": " + e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return instance;
    }

```
```
private boolean isSetter(Method method) {
    return method.getName().startsWith("set")
            && method.getParameterTypes().length == 1
            && Modifier.isPublic(method.getModifiers());
}
```
```
set方法中截取对象名称
    private String getSetterProperty(Method method) {
        return method.getName().length() > 3 ? method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4) : "";
    }
```


参考 [jdk和dubbo的SPI机制](https://www.cnblogs.com/wyq178/p/12171881.html)



