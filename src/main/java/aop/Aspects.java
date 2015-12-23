package aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {
	
	@AfterReturning(pointcut="execution( * aop.PersonService.get*())", returning="person")
	public void executeReturn(Person person) {
		System.out.println("Aspect printing person after is is returned: " + person);
	}
	
	@AfterThrowing(pointcut="execution ( * aop.Person.*(..))", throwing="ex")
	public void executeError(Exception ex) {
		System.out.println("Aspect printing error: " + ex);
	}
	
	@Before("within(*) && args(person)")
	public void beforePassing(Person person) {
		System.out.println("Aspect printing person before passing to print method: " + person);
	}
}
