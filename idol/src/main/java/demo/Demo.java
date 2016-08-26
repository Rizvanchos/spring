package demo;

import db.DatabaseManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import perform.Performable;

public class Demo {

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        performance(context);
        properties(context);
    }

    private static void performance(final ApplicationContext context) {
        final Performable performance = (Performable) context.getBean("duke");
        performance.perform();

        final Performable poeticJuggler = (Performable) context.getBean("poeticJuggler");
        poeticJuggler.perform();

        final Performable Kenny = (Performable) context.getBean("Kenny");
        Kenny.perform();

        final Performable Jerry = (Performable) context.getBean("Jerry");
        Jerry.perform();

        final Performable magician = (Performable) context.getBean("magician");
        magician.perform();

        final Performable virtuoso = (Performable) context.getBean("virtuoso");
        virtuoso.perform();
    }

    private static void properties(final ApplicationContext context) {
        final DatabaseManager dbManager = (DatabaseManager) context.getBean("databaseManager");

        System.out.println(dbManager.getUrl());
        System.out.println(dbManager.getUsername());
        System.out.println(dbManager.getPassword());
    }

}
