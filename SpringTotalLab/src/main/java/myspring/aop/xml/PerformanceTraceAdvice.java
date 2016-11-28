package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 핵심기능과 부가기능
 * 	- 핵심기능(Core Concerns) : 업무(Biz) 로직을 포함하는기능.
 * 	- 부가기능(Cross-cutting Concerns) : 핵심기능을 도와주는 부가적인 기능(로깅, 보안 등).
 * 	- OOP 기본원칙을 적용하더라도 핵심기능에 ㅜㅂ가기능을 분리해서 모듈화하는 것은 매우 어려움.
 * 	- OOP = OOP + AOP
*/

/*
 * AOP용어
 * 	- 타겟(Target) : 핵심기능을 담고 있는 모듈, 부가기능을 부여할 대상이 됨
 * 	- 어드바이스(Advice) : 모듈기능을 담고 있는 모듈, 타겟에 제공함.
 * 	- 조인 포인트(Join Point) : 어드바이스를 적용될 수 있는 위치
 * 	- 포인트 컷(Point Cut) : 정규표현식
 * 	- 에스펙트(Aspect) : AOP 기본모듈
 * 						어드바이스 + 포인트컷
*/

/*
 * *Spring AOP의 구현 방식
 * 1) XML 기반의 POJO 클래스를 이용한 AOP구현
 * 	- 부가기능을 제고하는 Advice 클래스를 작성함.
 * 	- XML 설정 파일에 <aop:config>를 이용해서 에스팩트를 설정함.
 * 2) @Aspect 어노테이션을 이용한 AOP구현
 * 	
*/

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		// 타겟 메서드의 singature 정보
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println("PerformanceTraceAdvice 안에 singatureString"+signatureString+"시작");
		
		// 타겟 메서드가 호출되기 전의 시간
		long start = System.currentTimeMillis();
		
		try {
			// 타겟 메서드 호출
			Object result = joinPoint.proceed();
			
			return result;
		} finally{
			// 타겟 메서드가 호출되기 후의 시간
			long finish = System.currentTimeMillis();
			
			System.out.println("PerformanceTraceAdvice 안에 singatureString"+signatureString+"종료");
			System.out.println("PerformanceTraceAdvice 안에 singatureString"+signatureString+"실행시간"+
							(finish-start)+"ms");
		}
	      
   }
}
