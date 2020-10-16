package org.nmx.javaagent.agent;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

public class Agent {

	public static void premain(String agentArgs, Instrumentation instrumentation) {
		System.out.println("Instrumenting classes for callTree");

		new AgentBuilder.Default()
				.type(ElementMatchers.nameContains("org.nmx.javaagent.application"))
				.transform((builder, typeDescription, classLoader,module) 
						-> builder.method(ElementMatchers.any()).intercept(Advice.to(CallsAdvice.class)))
				.installOn(instrumentation);

	}
}
