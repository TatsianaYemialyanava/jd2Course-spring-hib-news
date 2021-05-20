package by.htp.les04.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCreationLoggingAspect {

	@After("execution(public void by.htp.les04.service.impl.UserServiceImpl.createUser(by.htp.les04.bean.User)))")
	public void afterCreateUserAdvice() {

		System.out.println("\n==>>> Create user");	
	}
}
