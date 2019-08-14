import com.flj.bean.Person;
import com.flj.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:19
 **/
public class MainTest {

    public static void main(String[] args) {
        //配置方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person1 = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(person1);
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for(String str : beanNamesForType){
            System.out.println(str);
        }
    }
}
