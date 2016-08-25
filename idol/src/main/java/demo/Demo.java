package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import perform.Perfomable;

public class Demo {

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        final Perfomable perfomance = (Perfomable) context.getBean("duke");
        perfomance.perfom();
    }

}
