package com.tps.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubclassApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cgf.xml")
				.addAnnotatedClass(employee.class)
				.addAnnotatedClass(RegularEmployee.class)
				.addAnnotatedClass(ContractEmployee.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();


		employee e1 = new employee();
		e1.setName("pushparaj");
		session.save(e1);

		RegularEmployee r1 = new RegularEmployee();
		r1.setName("vintoh");
		r1.setSalary(20000);
		r1.setBonus(2000);
		session.save(r1);

		ContractEmployee c1 = new ContractEmployee();
		c1.setName("vinoth kumar");
		c1.setContractDuration(2);
		c1.setPayPerHour(1000);
		session.save(c1);

		t.commit();
		session.close();
		System.out.println("saved successfully");


	}

}
