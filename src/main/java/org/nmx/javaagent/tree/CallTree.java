package org.nmx.javaagent.tree;

import java.lang.reflect.Method;

import org.nmx.javaagent.plantuml.PlantumlVisitor;

public class CallTree {

	CallNode root = new CallNode(null, null);
	CallNode currentNode = root;
	
	public void enter(Method method) {
		currentNode = currentNode.enterChild(method);
	}

	public void exit() {
		currentNode = currentNode.exitChild();
		if (currentNode == root) {
			accept(new PlantumlVisitor());
		}
	}

	private void accept(CallTreeVisitor visitor) {
		visitor.enter(this);
		root.accept(visitor);
		visitor.exit(this);
	}

	public void output() {
		root.output("");
	}
}
