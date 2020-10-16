package org.nmx.javaagent.agent;

import java.lang.reflect.Method;

import org.nmx.javaagent.tree.CallHierachies;
import org.nmx.javaagent.tree.CallTree;

import net.bytebuddy.asm.Advice;

public class CallsAdvice {
	public static CallTree currentTree() {
		return CallHierachies.getTree(Long.toString(Thread.currentThread().getId()));
	}

	@Advice.OnMethodEnter
	static void onEnter(@Advice.Origin Method method) {
		currentTree().enter(method);
	}

	
	@Advice.OnMethodExit
	static void onExit(@Advice.Origin Method method) {
		currentTree().exit();
	}
}
