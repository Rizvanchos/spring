package ua.nure.hasanov.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.nure.hasanov.db.DatabaseManager;
import ua.nure.hasanov.magic.BlackMagicBox;
import ua.nure.hasanov.magic.Magician;
import ua.nure.hasanov.perform.Performable;
import ua.nure.hasanov.stage.instrument.Guitar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //performance(context);
        //properties(context);

        //hibernate();
        entityManager();
    }

    private static void entityManager() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("entityManager").createEntityManager();

        //Guitar guitar = entityManager.find(Guitar.class, 1);
        //System.out.println(guitar.getName());


        BlackMagicBox magicBox = new BlackMagicBox();
        magicBox.setWeight(123);

        Magician magician = new Magician();
        magician.setMagicBox(magicBox);

        entityManager.getTransaction().begin();
        entityManager.persist(magician);

        entityManager.getTransaction().commit();

        Magician magician1 = entityManager.find(Magician.class, 1);
        System.out.println(magicBox.getWeight());

        entityManager.close();
    }

    private static void hibernate() {
        Session session = new Configuration().addPackage("ua.nure.hasanov").addResource("hibernate.cfg.xml").configure().buildSessionFactory().openSession();
        session.beginTransaction();

        Guitar guitar = new Guitar();
        guitar.setName("Gibson");
        guitar.setColor("black");

        session.save(guitar);

        session.getTransaction().commit();
        session.close();
    }

    private static void performance(ApplicationContext context) {
        Performable performance = (Performable) context.getBean("duke");
        performance.perform();

        Performable poeticJuggler = (Performable) context.getBean("poeticJuggler");
        poeticJuggler.perform();

        Performable kenny = (Performable) context.getBean("kenny");
        kenny.perform();

        Performable jerry = (Performable) context.getBean("jerry");
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
