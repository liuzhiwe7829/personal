package client.net;

import discovery.ServiceInfo;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2721:50
 */
public interface NetClient {
    byte [] sendRequest(byte[] data , ServiceInfo sinfo) throws Throwable;
}
