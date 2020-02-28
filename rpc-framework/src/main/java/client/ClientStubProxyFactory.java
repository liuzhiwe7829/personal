package client;

import common.protocol.MessageProtocol;
import sun.security.krb5.internal.NetClient;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2622:08
 */
public class ClientStubProxyFactory {

    private ServiceInfoDiscoverer sid;

    private Map<String, MessageProtocol> supportMessageProtocols;

    private NetClient netClient;
    private Map<Class<?>, Object> objectCache = new HashMap<>();


    public <T> T getProxy(Class<T> interf) {
        T obj = (T) this.objectCache.get(interf);
        if (obj == null) {
            obj = (T) Proxy.newProxyInstance(interf.getClassLoader(), new Class<?>[]{interf},
                    new ClientStubInvocationHandler(interf));
            this.objectCache.put(interf, obj);
        }
        return obj;
    }

    public ServiceInfoDiscoverer getSid() {
        return sid;
    }

    public void setSid(ServiceInfoDiscoverer sid) {
        this.sid = sid;
    }

    public Map<String,MessageProtocol> getSupportMessageProtocols(){

    }
}
