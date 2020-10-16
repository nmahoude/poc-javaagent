package org.nmx.javaagent.output.sysout;

import java.lang.reflect.Method;

import org.nmx.javaagent.tree.CallNode;
import org.nmx.javaagent.tree.CallTree;
import org.nmx.javaagent.tree.CallTreeVisitor;

public class SysoutVisitor implements CallTreeVisitor {

	String currentDecal = "";
	
	@Override
	public void enter(CallNode node) {
		if (node.method() != null) {
			Method method = node.method();
			System.out.println(currentDecal+" "+method.getDeclaringClass().getCanonicalName()+" in "+method.getName()+" calls = "+node.callsCount()+" total duration = "+node.totalDuration());
		} else {
			System.out.println("ROOT");
		}

		currentDecal = currentDecal+"  ";
	}

	@Override
	public void exit(CallNode node) {
		currentDecal = currentDecal.substring(0, currentDecal.length()-2);
	}

	@Override
	public void enter(CallTree tree) {
	}

	@Override
	public void exit(CallTree tree) {
	}

}