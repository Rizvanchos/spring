package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import perform.Perfomable;

public class Demo {

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        final Perfomable perfomance = (Perfomable) context.getBean("duke");
        perfomance.perfom();

        final Perfomable poeticJuggler = (Perfomable) context.getBean("poeticJuggler");
        poeticJuggler.perfom();

        final Perfomable Kenny = (Perfomable) context.getBean("Kenny");
        Kenny.perfom();

        final Perfomable Jerry = (Perfomable) context.getBean("Jerry");
        Jerry.perfom();
    }

}
