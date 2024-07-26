package com.tph.Hierarchy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HierarchyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HierarchyApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RegularEmployee.class)
				.addAnnotatedClass(ContractEmployee.class)
				.addAnnotatedClass(Employee.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session ss=factory.openSession();

		Transaction t = ss.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("pushpa");
		ss.save(e1);

		Employee e2 = new Employee();
		e2.setName("pushparaj");
		ss.save(e2);



		RegularEmployee r1 = new RegularEmployee();
		r1.setName("vinoth ");
		r1.setSalary(600000);
		r1.setBonus(4000);
		ss.save(r1);

		RegularEmployee r2 = new RegularEmployee();
		r2.setName("vinoth kumar");
		r2.setSalary(600000);
		r2.setBonus(4000);
		ss.save(r2);

		ContractEmployee c1 = new ContractEmployee();
		c1.setName("raj");
		c1.setContract_duration(10);
		c1.setPayPerHour(500);
		ss.save(c1);

		ContractEmployee c2 = new ContractEmployee();
		c2.setName("vino");
		c2.setContract_duration(10);
		c2.setPayPerHour(500);
		ss.save(c2);




		t.commit();
		ss.close();
		factory.close();

		System.out.println("successfully saved");
	}
}

