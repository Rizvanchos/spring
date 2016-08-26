package ua.nure.hasanov.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.nure.hasanov.db.DatabaseManager;
import ua.nure.hasanov.perform.Performable;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        performance(context);
        properties(context);
    }

    private static void performance(ApplicationContext context) {
        Performable performance = (Performable) context.getBean("duke");
        performance.perform();

        Performable poeticJuggler = (Performable) context.getBean("poeticJuggler");
        poeticJuggler.perform();

        Performable kenny = (Performable) context.getBean("Kenny");
        kenny.perform();

        Performable jerry = (Performable) context.getBean("Jerry");
        jerry.perform();

        Performable magician = (Performable) context.getBean("magician");
        magician.perform();

        Performable virtuoso = (Performable) context.getBean("virtuoso");
        virtuoso.perform();
    }

    private static void properties(ApplicationContext context) {
        DatabaseManager dbManager = (DatabaseManager) context.getBean("databaseManager");

        System.out.println(dbManager.getUrl());
        System.out.println(dbManager.getUsername());
        System.out.println(dbManager.getPassword());
    }

}
