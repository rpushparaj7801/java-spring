package com.hibernate.set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(author.class)
				.addAnnotatedClass(book.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();


		author author = new author();
		author.setName("J.K. Rowling");

		book book1 = new book();
		book1.setTitle("Harry Potter and the Sorcerer's Stone");
		book1.setAuthor(author);

		book book2 = new book();
		book2.setTitle("Harry Potter and the Chamber of Secrets");
		book2.setAuthor(author);

		book book3 = new book();
		book3.setTitle("Harry Potter and the Chamber of Secrets");
		book3.setAuthor(author);

		author.getBooks().add(book1);
		author.getBooks().add(book2);
		author.getBooks().add(book3);

		session.save(author);



		t.commit();
		session.close();

	}

}
