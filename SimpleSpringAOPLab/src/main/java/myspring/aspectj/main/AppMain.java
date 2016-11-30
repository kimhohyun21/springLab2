package myspring.aspectj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myspring.aspectj.service.EmployeeService;

public class AppMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeService employeeService=context.getBean("employeeService", EmployeeService.class);
		
		System.out.println(employeeService.getEmployee().getEmpName());
	}
}
