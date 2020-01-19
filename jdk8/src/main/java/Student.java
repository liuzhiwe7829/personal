import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhiwei.liu003
 * @date 2020/1/1911:48
 */
@Data
public class Student {
    int id;
    String groupId;
    String name;

    public Student(int i, String one, String zhao) {
        this.id = i;
        this.groupId = one;
        this.name = zhao;
    }
}
