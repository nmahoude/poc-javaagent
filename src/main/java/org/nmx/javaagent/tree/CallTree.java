package org.nmx.javaagent.tree;

import java.lang.reflect.Method;

import org.nmx.javaagent.output.plantuml.PlantumlVisitor;

public class CallTree {

	CallNode root = new CallNode(null, null);
	CallNode currentNode = root;
	
	public void enter(Method method) {
		currentNode = currentNode.enterChild(method);
	}

	public void exit() {
		currentNode = currentNode.exitChild();
		if (currentNode == root) {
			CallHierachies.output(this);
		}
	}

	public void accept(CallTreeVisitor visitor) {
		visitor.enter(this);
		root.accept(visitor);
		visitor.exit(this);
	}
}
