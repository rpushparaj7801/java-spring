package com.hibernate.manytoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytooneApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(employee.class)
				.addAnnotatedClass(department.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t= session.beginTransaction();

		department d = new department();
		d.setId(01);
		d.setName("developer");
		session.save(d);

		employee e1 = new employee();
		e1.setId(01);
		e1.setName("pushpa");
		e1.setDepartment(d);
		session.save(e1);

		employee e2 = new employee();
		e2.setId(02);
		e2.setName("vinoth ");
		e2.setDepartment(d);
		session.save(e2);

		department d1 = new department();
		d1.setId(01);
		d1.setName("support");
		session.save(d1);

		employee e3 = new employee();
		e3.setId(03);
		e3.setName("vinoth kumar");
		e3.setDepartment(d1);
		session.save(e3);

		employee e4 = new employee();
		e4.setId(04);
		e4.setName("pushparaj");
		e4.setDepartment(d1);
		session.save(e4);









		t.commit();
		session.close();

		System.out.println("success");


	}

}
