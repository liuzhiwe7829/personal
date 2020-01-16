package drools;

import lombok.Data;

@Data
public class Location implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label(value = "\u56FD\u5BB6")
    private java.lang.String country;
    @org.kie.api.definition.type.Label(value = "\u7701\u4EFD")
    private java.lang.String province;
    @org.kie.api.definition.type.Label(value = "\u57CE\u5E02")
    private java.lang.String city;

    public Location(String s, String s1, String xmn) {
    }
}
