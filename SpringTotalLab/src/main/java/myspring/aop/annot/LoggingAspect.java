package myspring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * *Spring AOP�� ���� ���
 * 1)
 * 2) @Aspect ������̼��� �̿��� AOP ����
 * 		- @Aspect ������̼��� �̿��ؼ� �ΰ������ �����ϴ�
 *  		Aspect Ŭ������ �ۼ���.
 *  		=> �����̽��� �����ϴ� �޼���� ����Ʈ���� ������. 
 *  	- XML ���� ���Ͽ� <aop:aspectj-autoproxy />�� ������.
 */

/*
 * @Aspect
 * 		- Aspect Ŭ������ ������ �� @AspectJ ������̼���  �����.
 */

/*
 * 	Aspect Ŭ����(LoggingAspect)�� 4���� ������ �����̽��� ����Ʈ���� ����
 * 		==> Ÿ�� ��ü�� �Ķ���Ϳ� ���ϰ�, ���ܹ߻� �� ���� �޽����� ����ϴ� ��� ����.
 * 		-Advice ���� : Before, AfterReturing, AfterThrowing, After
 * 		-�����޼����: before(JoinPoint joinPoint)
 * 				   afterReturing(JoinPoint joinPoint, Object ret) 
 * 				   afterThrowing(JoinPoint joinPoint, Throwable ex)
 * 				   afterFinally(JoinPoint joinPoint)	
 * 	
 * 		-Advice�� �����ϴ� ������̼�
 * 			@Before("pointcut") : Ÿ�� ��ü�� �޼��尡 ����Ǳ� ���� ȣ��Ǵ� �����̽�.
 * 								  JoinPoint�� ���� �Ķ���� ������ ������.
 * 			@After("pointcut") : Ÿ�� ��ü�� �޼��尡 ���������� ������� ��,
 * 								 ���ܰ� �߻����� �� ��� ȣ��Ǵ� �����̽�.
 * 			@Around("pointcut") : Ÿ�� ��ü�� �޼��尡 ȣ��Ǵ� �� ������ ��� ���� �� �ִ�
 * 								  ���� ������ ����� ���� �����̽�.
 * 			@AfterReturing(pointcut="",returning="")
 * 								: Ÿ�� ��ü�� �޼��尡 ���������� ������ ��ģ �Ŀ�
 * 							        ȣ��Ǵ� �����̽�.
 * 								���ϰ��� ������ ���� returning �Ӽ��� ���ϰ��� ������ 
 * 								���� �̸��� �����ؾ� ��.
 * 			@AfterThrowing(pointcut="",throwing="")
 * 								: Ÿ�� ��ü�� �޼��尡 ���ܰ� �߻��ϸ� 
 * 							            ȣ��Ǵ� �����̽�.
 * 								  �߻��� ���ܸ� ������ ���� throwing �Ӽ��� �߻��� 
 * 								���ܸ� ������ ���� �̸��� �����ؾ� ��.
 * 
 * 
 */

@Component			//Bean���� ���
@Aspect				//�ֽ���Ʈ�� ����ϴ� Ŭ������ ����
public class LoggingAspect {
	
	/*
	 * 	Before �����̽� => Ÿ�� ��ü�� �޼����,�Ķ���͸� ���.
	 * 		myspring ��Ű�� �Ǵ� �� ���� ��Ű���� �ִ� ��� public �޼��尡 ȣ��Ǳ� ������ ȣ���.
	 */
	@Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@Before [ " +signatureString+ " ] �޼��� ���� ��ó�� ����");
		for(Object arg : joinPoint.getArgs()){
			System.out.println("@Before [ " +signatureString+ " ] �ƱԸ�Ʈ" + arg);
		}
	}
	
	
	/*
	 *  AfterReturning �����̽�
	 *  	-@AfterReturing �����̽��� �̿��ؼ� ����Ǵ� 
	 *  	Ÿ�ٰ�ü�� �޼����� ���ϰ��� ����ϴ� �����̽�.
	 *  	-afterReturing �޼���� myspring.user.service ��Ű�� ������ �ִ�
	 *  	��� public �޼��尡 ���� ����� ���Ŀ� ��µ�.
	 *  	-���ϰ��� ���� �Ҷ��� returning �Ӽ��� �̿��ؼ� ���� ���� ���� 
	 *  	���� �̸��� �����ؾ� ��.
	 * 
	 */
	@AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))",returning="ret")
	public void afterReturing(JoinPoint joinPoint, Object ret){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ " +signatureString+ " ] �޼��� ���� ��ó�� ����");
		System.out.println("@AfterReturning [ " +signatureString+ " ] ���ϰ�=" +ret);
	}
	
	
	/*
	 *  AfterThrowing �����̽�
	 *  	-@AfterThrowing �����̽��� �̿��ؼ� ����Ǵ�
	 *  	Ÿ�� ��ü�� �޼����� ���� �޽����� ����ϴ� �����̽���.
	 *  	-afterThrowing �޼���� Ŭ�������� UserService�� 
	 *  	���۵Ǵ� Ŭ������ ���� ��� �޼��尡 ���ܰ� �߻��� ���Ŀ� ȣ���.
	 *  	-�߻��� ���ܸ� ������ ���� throwing �Ӽ��� �̿��ؼ�
	 *  	���ܰ�ü�� ���� ������ �����ؾ� ��.
	 */
	@AfterThrowing(pointcut="execution(* *..UserService*.*(..))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing [ " +signatureString+ " ] �޼��� ���� �� ���ܹ߻� ");
		System.out.println("@AfterThrowing [ " +signatureString+ " ] ����=" +ex.getMessage());
	}
	
	/*
	 *  After �����̽�
	 *  	-@After �����̽��� �̿��ؼ� ����Ǵ� Ÿ�� ��ü�� �޼������ ����ϴ� �����̽���.
	 *  	-�޼������ User�� ������ �޼������ ���� ������� ���� ���ܰ� �߻������� ��� ȣ��.
	 *  	-�ݵ�� ��ȯ�ؾ� �ϴ� ���ҽ��� �ְų�
	 *  	 �ż��� ���� ����� �׻� �α׷� ���ܾ� �ϴ� ��쿡 ��밡��.
	 *  	-���� ���̳� ���ܸ� ���� �����Ҽ��� ����.
	 */
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint){
		String signatureString=joinPoint.getSignature().getName();
		System.out.println("@After [ " +signatureString+ " ] �޼��� ���� �Ϸ� ");
	}
	
	
}














