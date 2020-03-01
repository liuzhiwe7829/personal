package discovery;

import java.util.List;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2820:59
 */
public interface ServiceInfoDiscoverer {
    List<ServiceInfo> getServiceInfo(String name);
}
