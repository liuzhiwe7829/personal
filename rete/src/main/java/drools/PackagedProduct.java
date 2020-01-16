package drools;

import lombok.Data;

@Data
public class PackagedProduct implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label(value = "\u6210\u5458\u4EA7\u54C1ID\u5217\u8868")
    private java.util.List<java.lang.String> itemProductCodes;
}