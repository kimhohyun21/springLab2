package myspring.aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String getEmpName())")
	public void loginAdvice(){
		System.out.println("�̸� �����. �ΰ� ���ɻ��� �����̽� �޼��� ȣ��.");
	}
}
