import knight.impl.BraveKnight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        final BraveKnight knight = (BraveKnight) context.getBean("knight");

        knight.embarkQuest();
    }
}
