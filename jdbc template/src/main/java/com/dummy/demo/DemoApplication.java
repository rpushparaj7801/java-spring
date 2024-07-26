package com.dummy.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);


		Employee emp1 = new Employee(1, "John Doe", 50000.0);
		Employee emp2 = new Employee(2, "John vino", 567000.0);
		Employee emp3 = new Employee(3, "John raj", 50000.0);
		employeeDao.saveEmployee(emp1);
		employeeDao.saveEmployee(emp2);
		employeeDao.saveEmployee(emp3);

		System.out.println("Employee created: " + emp1 +emp2+emp3);



		emp1.setSalary(90000.0);
		emp1.setName("pushparaj");
		employeeDao.updateEmployee(emp1);

		System.out.println("Employee updated: " + emp1);


//		Employee retrievedEmployee = employeeDao.getEmployeeById(emp1.getId());
//		System.out.println("Retrieved Employee: " + retrievedEmployee);
//
//		employeeDao.deleteEmployee(retrievedEmployee.getId());
//		System.out.println("Employee deleted.");


	}
}
