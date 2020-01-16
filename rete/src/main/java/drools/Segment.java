package drools;

import lombok.Data;

@Data
public class Segment implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label("产品编码")
    private java.lang.String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private java.lang.String proName;
    @org.kie.api.definition.type.Label("出发城市")
    private java.lang.String startCity;
    @org.kie.api.definition.type.Label("到达城市")
    private java.lang.String arriveCity;
    @org.kie.api.definition.type.Label("舱位")
    private java.lang.String cabin;
    @org.kie.api.definition.type.Label("航班日期")
    private java.util.Date flightDate;
}
