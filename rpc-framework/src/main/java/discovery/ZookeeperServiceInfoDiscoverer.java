package discovery;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2821:17
 */
public class ZookeeperServiceInfoDiscoverer  implements ServiceInfoDiscoverer{
    ZkClient client;

    private  String centerRootPath = "/Rpc-framework";

    public ZookeeperServiceInfoDiscoverer(){

    }
    @Override
    public List<ServiceInfo> getServiceInfo(String name) {
        String servicePath = centerRootPath +"/" +name +"/service";
        List<String> children = client.getChildren(servicePath);
        List<ServiceInfo> resources = new ArrayList<ServiceInfo>();
        for(String ch: children){
            try{
                String deCh = URLDecoder.decode(ch,"UTF-8");
                ServiceInfo r = JSON.parseObject(deCh,ServiceInfo.class);
                resources.add(r);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return  resources;
    }
}
