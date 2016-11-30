package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 	핵심기능과 부가기능
 * 	-핵심기능(Core Concerns): 업무(Biz) 로직을 포함하는 기능.
 * 	-부가기능(Cross-cutting Concerns): 핵심 기능을 도와주는 부가적인 기능(로깅,보안 등)
 *  -OOP 기본원칙을 적용하더라도 핵심기능에 부가기능을 분리해서 모듈화하는것은 매우 어려움.
 *  - OOP = OOP+ AOP
 */

/*
 * AOP용어
 * 	-타겟(Target) : 핵심기능을 담고 있는 모듈, 부가기능을 부여할 대상이 됨.
 * 	-어드바이스(Advice) : 부가기능을 담고 있는 모듈, 타겟에 제공함.
 *  -조인 포인트(Join Point) : 어드바이스를 적용될수 있는 위치.
 *  -포인트 컷(PointCut) : 정규표현식 작성.
 *  -애스펙트(Aspect) : AOP의 기본모듈
 *  				 어드바이스 + 포인트 컷 (Advice+PointCut=Aspect)
 */

/*
 *  *Spring AOP의 구현 방식
 *  1)XML 기반의 POJO 클래스를 이용한 AOP구현
 *  	-부가기능을 제고하는 Advice 클래스를 작성함.
 *  	-XML 설정 파일에 <aop:config>를 이용해서 애스팩트를 설정함.
 *  2)@Aspect 어노테이션을 이용한 AOP구현
 *  
 */

/*
 * JoinPoint 인터페이스
 * 	-Joinpoint는 Spring AOP 혹은 AspectJ에서 AOP가 적용되는 지점을 뜻함.
 *  -해당 지점을 AspectJ에서 JoinPoint라는 인터페이스로 나타냄.
 *  -getArgs() : 메서드 아큐멘트를 반환함.
 *  -getThis() : 프록시 객체를 반환함.
 *  -getTarget() : 대상 객체를 반환함.
 *  -getSignature() : 어드바이즈 되는 메서드의 설명(description)을 반환함.
 *  -toString() : 어드바이즈되는 메서드의 설명을 출력함.
 *  
 *  -모든 어드바이스는 org.aspectj.lang.JoinPoint 타입의 파라미터를 
 *   어드바이스 메서드에 첫번째 매개변수로 선언할수 있음.
 *  -Around 어드바이스는  JoinPoint의 하위 클래스인 ProceedingJoinPoint 타입의
 *   파라미터를 필수적으로 선언해야 함.
 *   
 */
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//타겟 메서드의 signature 정보
		String signatureString=joinPoint.getSignature().toShortString();
		
		System.out.println(signatureString +"시작");
		
		//타겟 메서드가 호출되기 전의 시간
		long start=System.currentTimeMillis();
		
		try{
			//타게 메서드 호출
			Object result=joinPoint.proceed();
			return result;
			
		}finally{
			//타겟 메서드가 호출되기 후의 시간
			long finish=System.currentTimeMillis();
			
			System.out.println(signatureString +"종료");
			System.out.println(signatureString + "실행 시간" +
						(finish-start) +" ms");
		}
		
		
	}
}







