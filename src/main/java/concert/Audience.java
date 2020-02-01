package concert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	private Log log = LogFactory.getLog(Audience.class);
	
	@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance(){}
	
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp){
		try {
			System.out.println("关掉手机进入剧场");
			System.out.println("找到座位坐下");
			jp.proceed();
			System.out.println("表演很精彩，鼓掌喝彩");
			
		} catch (Throwable e) {
			System.out.println("表演失败，喝倒彩，要求退款");
		}
	}
	

}
