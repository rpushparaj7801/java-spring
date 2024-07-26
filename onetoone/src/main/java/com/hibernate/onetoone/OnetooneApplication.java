package com.hibernate.onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnetooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Address.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

				Address address1 = new Address();
				address1.setStreet("123 Main St");
				address1.setCity("Springfield");
				address1.setState("IL");
				address1.setZipCode(62701);
				session.save(address1);

				Employee employee1 = new Employee();
				employee1.setName("John Doe");
				employee1.setAddress(address1);
				session.persist(employee1);



				Address address2 = new Address();
				address2.setStreet("456 Elm St");
				address2.setCity("Shelbyville");
				address2.setState("IL");
				address2.setZipCode(62565);
				session.persist(address2);

				Employee employee2 = new Employee();
				employee2.setName("Jane Smith");
				employee2.setAddress(address2);
				session.persist(employee2);



				Address address3 = new Address();
				address3.setStreet("789 Oak St");
				address3.setCity("Capital City");
				address3.setState("IL");
				address3.setZipCode(62703);
				session.persist(address3);

				Employee employee3 = new Employee();
				employee3.setName("Alice Johnson");
				employee3.setAddress(address3);
				session.persist(employee3);

		t.commit();
		session.close();



				System.out.println("3 employees saved successfully!");
			}
		}




