package demo;

import common.protocol.JavaSerializeMessageProtocol;
import server.NettyRpcServer;
import server.RequestHandler;
import server.RpcServer;
import server.register.ServiceObject;
import server.register.ServiceRegister;
import server.register.ZookeeperExportServiceRegister;
import util.PropertiesUtils;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2820:54
 */
public class Provider {
    public  static  void main(String[] args) throws Exception{
        int port = Integer.parseInt(PropertiesUtils.getProperties("rpc.port"));
        String protocol = PropertiesUtils.getProperties("rpc.protocol");

        // 服务注册
        ServiceRegister sr = new ZookeeperExportServiceRegister();
        DemoService ds = new DemoServiceImpl();
        ServiceObject so = new ServiceObject(DemoService.class.getName(), DemoService.class, ds);
        sr.register(so, protocol, port);

        RequestHandler reqHandler = new RequestHandler(new JavaSerializeMessageProtocol(), sr);

        RpcServer server = new NettyRpcServer(port, protocol, reqHandler);
        server.start();
        System.in.read(); // 按任意键退出
        server.stop();
    }
}
