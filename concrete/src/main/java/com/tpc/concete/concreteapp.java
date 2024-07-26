package com.tpc.concete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class concreteapp {
    public static void main(String[] args) {


        SpringApplication.run(concreteapp.class,args);

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml")
                    .addAnnotatedClass(employee.class)
                    .addAnnotatedClass(contractemployee.class)
                    .addAnnotatedClass(regularemployee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        employee e1 = new employee();


        e1.setName("pushparaj");


        regularemployee e2 = new regularemployee();
        e2.setName("vinoth");
        e2.setSalary(20000);
        e2.setBonus(2000);

        contractemployee e3 = new contractemployee();
        e3.setName("vinoth kumar");
        e3.setContractduration(4);
        e3.setPayperhour(500);


        session.save(e1);
        session.save(e2);
        session.save(e3);

        t.commit();
        session.close();
        System.out.println("successfully saved");

    }
}
