import com.alibaba.fastjson.JSONArray;

/**
 * @author zhiwei.liu003
 * @date 2019/10/2814:32
 */
public class JSONTest {

    public static void main(String args[]){
        String indicatorCode = "01";

        System.out.println(JSONArray.parseObject(indicatorCode));
    }
}
