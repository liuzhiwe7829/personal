package pattern.structure.facade;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1423:51
 */
public class Slf4jTest {
    @Test
    public void testSlf4j(){
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.error("123");
    }
}
