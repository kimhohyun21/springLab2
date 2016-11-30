package myspring.aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String getEmpName())")
	public void loginAdvice(){
		System.out.println("미리 실행됨. 부가 관심사인 어드바이스 메서드 호출.");
	}
}
