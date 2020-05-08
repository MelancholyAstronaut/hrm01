import com.abc.services.INewsManagerServicesImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        INewsManagerServicesImpl iNewsManagerServices = (INewsManagerServicesImpl) applicationContext.getBean("newsManagerServices");


    }
}
