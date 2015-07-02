package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class befordaop {
	
	@Before("execution(public * com.server.Loginserver.check(..))")
	public void saybefore()
	{
		System.out.println("beforeִ��");
	}

}
