import com.qjhjames.aop.IStudent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class Test {
    public static void main(String[] args) {
                // TODO Auto-generated method stub
              ApplicationContext ctx =
                       new FileSystemXmlApplicationContext("src/test/applicationContext.xml");

              IStudent person = (IStudent)ctx.getBean("student");
              person.addStudent("dragon");

        //      person.addStudent("javadragon");
            }
}
