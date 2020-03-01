package client.net;

import discovery.ServiceInfo;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2721:51
 */
public class NettyNetClient  implements  NetClient{
    @Override
    public byte[] sendRequest(byte[] data, ServiceInfo sinfo) throws Throwable {
        return new byte[0];
    }
}
