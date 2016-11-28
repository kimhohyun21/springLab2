package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * �ٽɱ�ɰ� �ΰ����
 * 	- �ٽɱ��(Core Concerns) : ����(Biz) ������ �����ϴ±��.
 * 	- �ΰ����(Cross-cutting Concerns) : �ٽɱ���� �����ִ� �ΰ����� ���(�α�, ���� ��).
 * 	- OOP �⺻��Ģ�� �����ϴ��� �ٽɱ�ɿ� �̤�������� �и��ؼ� ���ȭ�ϴ� ���� �ſ� �����.
 * 	- OOP = OOP + AOP
*/

/*
 * AOP���
 * 	- Ÿ��(Target) : �ٽɱ���� ��� �ִ� ���, �ΰ������ �ο��� ����� ��
 * 	- �����̽�(Advice) : ������� ��� �ִ� ���, Ÿ�ٿ� ������.
 * 	- ���� ����Ʈ(Join Point) : �����̽��� ����� �� �ִ� ��ġ
 * 	- ����Ʈ ��(Point Cut) : ����ǥ����
 * 	- ������Ʈ(Aspect) : AOP �⺻���
 * 						�����̽� + ����Ʈ��
*/

/*
 * *Spring AOP�� ���� ���
 * 1) XML ����� POJO Ŭ������ �̿��� AOP����
 * 	- �ΰ������ �����ϴ� Advice Ŭ������ �ۼ���.
 * 	- XML ���� ���Ͽ� <aop:config>�� �̿��ؼ� ������Ʈ�� ������.
 * 2) @Aspect ������̼��� �̿��� AOP����
 * 	
*/

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		// Ÿ�� �޼����� singature ����
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println("PerformanceTraceAdvice �ȿ� singatureString"+signatureString+"����");
		
		// Ÿ�� �޼��尡 ȣ��Ǳ� ���� �ð�
		long start = System.currentTimeMillis();
		
		try {
			// Ÿ�� �޼��� ȣ��
			Object result = joinPoint.proceed();
			
			return result;
		} finally{
			// Ÿ�� �޼��尡 ȣ��Ǳ� ���� �ð�
			long finish = System.currentTimeMillis();
			
			System.out.println("PerformanceTraceAdvice �ȿ� singatureString"+signatureString+"����");
			System.out.println("PerformanceTraceAdvice �ȿ� singatureString"+signatureString+"����ð�"+
							(finish-start)+"ms");
		}
	      
   }
}
