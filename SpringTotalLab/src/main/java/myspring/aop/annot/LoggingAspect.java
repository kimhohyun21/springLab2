package myspring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * *Spring AOP의 구현 방식
 * 1)
 * 2) @Aspect 어노테이션을 이용한 AOP 구현
 * 		- @Aspect 어노테이션을 이용해서 부가기능을 제공하는
 *  		Aspect 클래스를 작성함.
 *  		=> 어드바이스를 구현하는 메서드와 포인트컷을 포함함. 
 *  	- XML 설정 파일에 <aop:aspectj-autoproxy />를 설정함.
 */

/*
 * @Aspect
 * 		- Aspect 클래스를 선언할 때 @AspectJ 어노테이션을  사용함.
 */

/*
 * 	Aspect 클래스(LoggingAspect)는 4가지 유형의 어드바이스와 포인트컷을 설정
 * 		==> 타겟 객체의 파라미터와 리턴값, 예외발생 시 예외 메시지를 출력하는 기능 제공.
 * 		-Advice 유형 : Before, AfterReturing, AfterThrowing, After
 * 		-구현메서드명: before(JoinPoint joinPoint)
 * 				   afterReturing(JoinPoint joinPoint, Object ret) 
 * 				   afterThrowing(JoinPoint joinPoint, Throwable ex)
 * 				   afterFinally(JoinPoint joinPoint)	
 * 	
 * 		-Advice를 정의하는 어노테이션
 * 			@Before("pointcut") : 타겟 객체의 메서드가 실행되기 전에 호출되는 어드바이스.
 * 								  JoinPoint를 통해 파라미터 정보를 참조함.
 * 			@After("pointcut") : 타겟 객체의 메서드가 정상적으로 종료됐을 때,
 * 								 예외가 발생했을 때 모두 호출되는 어드바이스.
 * 			@Around("pointcut") : 타겟 객체의 메서드가 호출되는 전 과정을 모두 담을 수 있는
 * 								  가장 강력한 기능을 가진 어드바이스.
 * 			@AfterReturing(pointcut="",returning="")
 * 								: 타겟 객체의 메서드가 정상적으로 실행을 마친 후에
 * 							        호출되는 어드바이스.
 * 								리턴값을 참조할 때는 returning 속성에 리턴값을 저장할 
 * 								변수 이름을 지정해야 함.
 * 			@AfterThrowing(pointcut="",throwing="")
 * 								: 타겟 객체의 메서드가 예외가 발생하면 
 * 							            호출되는 어드바이스.
 * 								  발생된 예외를 참조할 때는 throwing 속성에 발생한 
 * 								예외를 저장할 변수 이름을 지정해야 함.
 * 
 * 
 */

@Component			//Bean으로 등록
@Aspect				//애스팩트로 사용하는 클래스로 정의
public class LoggingAspect {
	
	/*
	 * 	Before 어드바이스 => 타겟 객체의 메서드명,파라미터를 출력.
	 * 		myspring 패키지 또는 그 하위 패키지에 있는 모든 public 메서드가 호출되기 이전에 호출됨.
	 */
	@Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@Before [ " +signatureString+ " ] 메서드 실행 전처리 수행");
		for(Object arg : joinPoint.getArgs()){
			System.out.println("@Before [ " +signatureString+ " ] 아규먼트" + arg);
		}
	}
	
	
	/*
	 *  AfterReturning 어드바이스
	 *  	-@AfterReturing 어드바이스를 이용해서 실행되는 
	 *  	타겟객체의 메서드명과 리턴값을 출력하는 어드바이스.
	 *  	-afterReturing 메서드는 myspring.user.service 패키지 하위에 있는
	 *  	모든 public 메서드가 정상 종료된 이후에 출력됨.
	 *  	-리턴값을 참조 할때는 returning 속성을 이용해서 리턴 값을 담을 
	 *  	변수 이름을 지정해야 함.
	 * 
	 */
	@AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))",returning="ret")
	public void afterReturing(JoinPoint joinPoint, Object ret){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ " +signatureString+ " ] 메서드 실행 후처리 수행");
		System.out.println("@AfterReturning [ " +signatureString+ " ] 리턴값=" +ret);
	}
	
	
	/*
	 *  AfterThrowing 어드바이스
	 *  	-@AfterThrowing 어드바이스를 이용해서 실행되는
	 *  	타켓 객체의 메서드명과 예외 메시지를 출력하는 어드바이스임.
	 *  	-afterThrowing 메서드는 클래스명이 UserService로 
	 *  	시작되는 클래스에 속한 모든 메서드가 예외가 발생된 이후에 호출됨.
	 *  	-발생된 예외를 참조할 때는 throwing 속성을 이용해서
	 *  	예외객체를 담을 변수을 지정해야 함.
	 */
	@AfterThrowing(pointcut="execution(* *..UserService*.*(..))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing [ " +signatureString+ " ] 메서드 실행 중 예외발생 ");
		System.out.println("@AfterThrowing [ " +signatureString+ " ] 예외=" +ex.getMessage());
	}
	
	/*
	 *  After 어드바이스
	 *  	-@After 어드바이스를 이용해서 실행되는 타겟 객체의 메서드명을 출력하는 어드바이스임.
	 *  	-메서드명이 User로 끝나는 메서드들이 정상 종료됐을 때와 예외가 발생했을때 모두 호출.
	 *  	-반드시 반환해야 하는 리소스가 있거나
	 *  	 매서드 실행 결과를 항상 로그로 남겨야 하는 경우에 사용가능.
	 *  	-리턴 값이나 예외를 직접 전달할수는 없음.
	 */
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@After [ " +signatureString+ " ] 메서드 실행 완료 ");
	}
	
	
}














