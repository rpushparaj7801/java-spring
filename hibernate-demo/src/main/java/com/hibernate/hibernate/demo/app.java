package com.hibernate.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class app {

	public static void main(String[] args) {
		SpringApplication.run(app.class,args);



		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Transaction t=session1.beginTransaction();

//		employee e1 = new employee();
//		e1.setName("pushparaj");
//		e1.setDepartment("developer");
//		e1.setSalary(16500);

//		employee e2 = new employee();
//		e2.setName("vinoth kumar");
//		e2.setDepartment("developer");
//		e2.setSalary(18000);
//
//		session.save(e1);
//		session.save(e2);

		employee a= (employee) session1.get(employee.class,1);
		System.out.println(a);


		employee a1= (employee) session1.get(employee.class,1);
		System.out.println(a1);

		session1.close();










}
}
