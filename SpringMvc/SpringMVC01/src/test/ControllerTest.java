import com.aynu.edu.Demo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    @Test
    public void testController() throws Exception{
        Demo d1 = new Demo();
        assertEquals("success",d1.sayHello());
    }
}
