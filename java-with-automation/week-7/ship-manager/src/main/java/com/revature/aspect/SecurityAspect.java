package com.revature.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.dto.MessageDto;

@Aspect
@Component
public class SecurityAspect {

	@Autowired
	private HttpServletRequest request;
	
	// Most powerful type of advice
	// Around advice controls what gets returned from the joinpoint being executed
	// And can even prevent the joinpoint from executing
	@Around("@annotation(com.revature.annotation.UserProtected)")
	public Object userLoggedInOnlyProtector(ProceedingJoinPoint myProceedingJoinPoint) throws Throwable {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("currentUser") == null) {
			return ResponseEntity.status(401).body(new MessageDto("You are not authorized to access this endpoint. You must be logged in."));
		}
		
		// If the above does not happen, that means we are logged in, and are free to execute the actual endpoint itself
		Object returnValue = myProceedingJoinPoint.proceed(); // This actually allows the joinpoint to execute (the method annotated with @UserProtected)
		return returnValue;
//		return ResponseEntity.status(200).body(new MessageDto("Around advice working!!!"));
	}

}
