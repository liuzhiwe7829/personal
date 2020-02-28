package common.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwei.liu003
 * @date 2020/2/2722:16
 */
public class Response implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4317845782629589997L;
    private Status status;
    private Map<String, String> headers = new HashMap<>();

    private Object returnValue;


    private Exception exception;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }


}
