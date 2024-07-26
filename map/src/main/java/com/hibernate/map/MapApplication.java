package com.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(author.class)
				.addAnnotatedClass(book.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		author a1 = new author();
		a1.setName("vinoth");

		book b1 = new book();
		b1.setTitle("this is vinth");
		b1.setGenre("comedy");
		a1.addBook(b1); // The genre "comedy" will be used as the key

		session.save(a1);

		author a2 = new author();
		a2.setName("pushparaj");

		book b2 = new book();
		b2.setTitle("this is pushpa");
		b2.setGenre("horror");
		a2.addBook(b2);
		// The genre "horror" will be used as the key

		session.save(a2);

		t.commit();
		session.close();
		sessionFactory.close();
	}
}
