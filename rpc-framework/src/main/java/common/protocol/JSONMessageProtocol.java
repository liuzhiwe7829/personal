package common.protocol;

import com.alibaba.fastjson.JSON;

/**
 * @author zhiwei.liu003
 * @date 2020/2/27 22:15
 */
public class JSONMessageProtocol implements MessageProtocol {
    @Override
    public byte[] marshallingRequest(Request req) throws Exception {
        Request temp = new Request();
        temp.setServiceName(req.getServiceName());
        temp.setMethod(req.getMethod());
        temp.setHeaders(req.getHeaders());
        temp.setParametersTypes(req.getPrameterTypes());

        if(req.getPrameterTypes() !=null){
            Object[] params = req.getParameters();
            Object[] serizeParmas = new Object[params.length];
            for(int i = 0 ; i < params.length ; i++){
                serizeParmas[i] = JSON.toJSONString(params[i]);
            }
            temp.setParameters(serizeParmas);
        }
        return JSON.toJSONBytes(temp);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        Request req = JSON.parseObject(data,Request.class);
        if(req.getParameters()!=null){

        }
        return null;
    }

    @Override
    public byte[] marshallingResponse(Response rsp) throws Exception {
        return new byte[0];
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        return null;
    }
}
