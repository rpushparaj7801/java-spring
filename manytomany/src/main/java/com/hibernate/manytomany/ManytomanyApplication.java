package com.hibernate.manytomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ManytomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class)
				.addAnnotatedClass(course.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

				course math = new course();
				math.setTitle("Mathematics");
				session.save(math);

				course science = new course();
				science.setTitle("Science");
				session.save(science);

				course history = new course();
				history.setTitle("History");
				session.save(history);

				course art = new course();
				art.setTitle("Art");
				session.save(art);


				student john = new student();
				john.setId(1);
				john.setName("John");
				Set<course> johnCourses = new HashSet<>();
				johnCourses.add(math);
				johnCourses.add(science);
				john.setCourses(johnCourses);
				session.save(john);

				student jane = new student();
				jane.setId(2);
				jane.setName("Jane");
				Set<course> janeCourses = new HashSet<>();
				janeCourses.add(science);
				janeCourses.add(history);
				jane.setCourses(janeCourses);
				session.save(jane);

				student mary = new student();
				mary.setId(3);
				mary.setName("Mary");
				Set<course> maryCourses = new HashSet<>();
				maryCourses.add(math);
				maryCourses.add(art);
				mary.setCourses(maryCourses);
				session.save(mary);

				student bob = new student();
				bob.setId(4);
				bob.setName("Bob");
				Set<course> bobCourses = new HashSet<>();
				bobCourses.add(history);
				bobCourses.add(art);
				bob.setCourses(bobCourses);
				session.save(bob);

				t.commit();
				session.close();


			}
		}




