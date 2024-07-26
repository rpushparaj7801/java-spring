package com.cache.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondlevelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondlevelApplication.class, args);

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = config.buildSessionFactory();

		// First session and transaction
		Session session1 = sessionFactory.openSession();
		Transaction t1 = session1.beginTransaction();
		Employee a = (Employee) session1.get(Employee.class, 1);
		System.out.println(a);

		t1.commit();
		session1.close();

		// Second session and transaction
		Session session2 = sessionFactory.openSession();
		Transaction t2 = session2.beginTransaction();
		Employee a1 = (Employee) session2.get(Employee.class, 1);
		System.out.println(a1);
		t2.commit();
		session2.close();

		sessionFactory.close();
	}
}
