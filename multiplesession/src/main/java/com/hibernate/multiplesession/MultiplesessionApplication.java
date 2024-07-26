package com.hibernate.multiplesession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MultiplesessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplesessionApplication.class, args);
//
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		student s1 = new student();
		s1.setId(1);
		s1.setName("pushparaj");
		s1.setSname("xyz school");

		session.save(s1);
		transaction.commit();
		session.close();




		Configuration configuration1 = new Configuration();
		configuration1.configure("hibernate1.cfg.xml")
				.addAnnotatedClass(student.class);
		SessionFactory sessionFactory1 = configuration1.buildSessionFactory();
		Session session1 = sessionFactory1.openSession();
		Transaction transaction1 = session1.beginTransaction();
		student s2 = new student();
		s2.setId(1);
		s2.setName("pushparaj");
		s2.setSname("xyz school");

		session1.save(s2);
		session1.close();
		transaction1.commit();

	}

}
