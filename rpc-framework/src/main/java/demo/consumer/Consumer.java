package demo.consumer;

import client.ClientStubProxyFactory;
import client.net.NettyNetClient;
import common.protocol.JavaSerializeMessageProtocol;
import common.protocol.MessageProtocol;
import demo.ZookeeperServiceInfoDiscoverer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2723:00
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClientStubProxyFactory cspf = new ClientStubProxyFactory();
        //设置服务发现者
        cspf.setSid(new ZookeeperServiceInfoDiscoverer());
        //设置支持的协议
        Map<String, MessageProtocol> supportMessageProtocols = new HashMap<>();
        supportMessageProtocols.put("javas", new JavaSerializeMessageProtocol());
       //设置网络层 实现
        cspf.setNetClient(new NettyNetClient());
        //获取远程服务代理
        DemoService demoService = cspf.getProxy(DemoService.class);
        // 执行远程方法
        String hello = demoService.sayHello("world");
        //显示 调用结果
        System.out.println(hello);

        System.out.println(demoService.multiPoint(new Point(5,10),2));
    }
}
