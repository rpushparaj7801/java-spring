package com.hibernate.list;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListApplication.class, args);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml")
                .addAnnotatedClass(author.class)
                .addAnnotatedClass(book.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();


        author author1 = new author();
        author1.setName("J.K. Rowling");

        book book1_1 = new book();
        book1_1.setTitle("Harry Potter and the Sorcerer's Stone");
        book1_1.setAuthor(author1);

        book book1_2 = new book();
        book1_2.setTitle("Harry Potter and the Chamber of Secrets");
        book1_2.setAuthor(author1);

        book book1_3 = new book();
        book1_3.setTitle("Harry Potter and the Prisoner of Azkaban");
        book1_3.setAuthor(author1);


        author1.getBooks().add(book1_1);
        author1.getBooks().add(book1_2);
        author1.getBooks().add(book1_3);

        session.save(author1);

        author author2 = new author();
        author2.setName("George R.R. Martin");

        book book2_1 = new book();
        book2_1.setTitle("A Game of Thrones");
        book2_1.setAuthor(author2);

        book book2_2 = new book();
        book2_2.setTitle("A Clash of Kings");
        book2_2.setAuthor(author2);

        book book2_3 = new book();
        book2_3.setTitle("A Storm of Swords");
        book2_3.setAuthor(author2);

        author2.getBooks().add(book2_1);
        author2.getBooks().add(book2_2);
        author2.getBooks().add(book2_3);

        session.save(author2);
        session.close();


    }

}
