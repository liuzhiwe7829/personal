package common.protocol;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2722:15
 */
public interface MessageProtocol {
    /**
     * 编组
     * @param req
     * @return
     * @throws Exception
     */
    byte[] marshallingRequest(Request req) throws Exception;

    /**
     * 解组
     * @param data
     * @return
     * @throws Exception
     */
    Request unmarshallingRequest(byte[] data) throws Exception;

    byte[] marshallingResponse(Response rsp) throws Exception;

    Response unmarshallingResponse(byte[] data) throws Exception;
}
