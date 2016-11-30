package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 	�ٽɱ�ɰ� �ΰ����
 * 	-�ٽɱ��(Core Concerns): ����(Biz) ������ �����ϴ� ���.
 * 	-�ΰ����(Cross-cutting Concerns): �ٽ� ����� �����ִ� �ΰ����� ���(�α�,���� ��)
 *  -OOP �⺻��Ģ�� �����ϴ��� �ٽɱ�ɿ� �ΰ������ �и��ؼ� ���ȭ�ϴ°��� �ſ� �����.
 *  - OOP = OOP+ AOP
 */

/*
 * AOP���
 * 	-Ÿ��(Target) : �ٽɱ���� ��� �ִ� ���, �ΰ������ �ο��� ����� ��.
 * 	-�����̽�(Advice) : �ΰ������ ��� �ִ� ���, Ÿ�ٿ� ������.
 *  -���� ����Ʈ(Join Point) : �����̽��� ����ɼ� �ִ� ��ġ.
 *  -����Ʈ ��(PointCut) : ����ǥ���� �ۼ�.
 *  -�ֽ���Ʈ(Aspect) : AOP�� �⺻���
 *  				 �����̽� + ����Ʈ �� (Advice+PointCut=Aspect)
 */

/*
 *  *Spring AOP�� ���� ���
 *  1)XML ����� POJO Ŭ������ �̿��� AOP����
 *  	-�ΰ������ �����ϴ� Advice Ŭ������ �ۼ���.
 *  	-XML ���� ���Ͽ� <aop:config>�� �̿��ؼ� �ֽ���Ʈ�� ������.
 *  2)@Aspect ������̼��� �̿��� AOP����
 *  
 */

/*
 * JoinPoint �������̽�
 * 	-Joinpoint�� Spring AOP Ȥ�� AspectJ���� AOP�� ����Ǵ� ������ ����.
 *  -�ش� ������ AspectJ���� JoinPoint��� �������̽��� ��Ÿ��.
 *  -getArgs() : �޼��� ��ť��Ʈ�� ��ȯ��.
 *  -getThis() : ���Ͻ� ��ü�� ��ȯ��.
 *  -getTarget() : ��� ��ü�� ��ȯ��.
 *  -getSignature() : �������� �Ǵ� �޼����� ����(description)�� ��ȯ��.
 *  -toString() : ��������Ǵ� �޼����� ������ �����.
 *  
 *  -��� �����̽��� org.aspectj.lang.JoinPoint Ÿ���� �Ķ���͸� 
 *   �����̽� �޼��忡 ù��° �Ű������� �����Ҽ� ����.
 *  -Around �����̽���  JoinPoint�� ���� Ŭ������ ProceedingJoinPoint Ÿ����
 *   �Ķ���͸� �ʼ������� �����ؾ� ��.
 *   
 */
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//Ÿ�� �޼����� signature ����
		String signatureString=joinPoint.getSignature().toShortString();
		
		System.out.println(signatureString +"����");
		
		//Ÿ�� �޼��尡 ȣ��Ǳ� ���� �ð�
		long start=System.currentTimeMillis();
		
		try{
			//Ÿ�� �޼��� ȣ��
			Object result=joinPoint.proceed();
			return result;
			
		}finally{
			//Ÿ�� �޼��尡 ȣ��Ǳ� ���� �ð�
			long finish=System.currentTimeMillis();
			
			System.out.println(signatureString +"����");
			System.out.println(signatureString + "���� �ð�" +
						(finish-start) +" ms");
		}
		
		
	}
}







