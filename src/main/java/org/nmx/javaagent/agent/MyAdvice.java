package org.nmx.javaagent.agent;

import net.bytebuddy.asm.Advice;

public class MyAdvice {

	
	@Advice.OnMethodEnter
	static long onEnter(@Advice.Origin String method) {
		long start = System.currentTimeMillis();
		System.out.println("onmethod enter : "+method);
		return start;
	}
	
	@Advice.OnMethodExit
	static void onExit(@Advice.Origin String method, @Advice.Enter long start) {
		long end = System.currentTimeMillis();
		System.out.println("onmethod exit "+method+" in "+(end-start)+" ms");
	}
}
