package org.nmx.javaagent.output.plantuml;

import org.nmx.javaagent.tree.CallNode;
import org.nmx.javaagent.tree.CallTree;
import org.nmx.javaagent.tree.CallTreeVisitor;

public class PlantumlVisitor implements CallTreeVisitor {
	private static final String HEADER = "@startuml";
	private static final String FOOTER = "@enduml";
	
	private static final String FILENAME = "plantUML.txt";
	
	CallNode currentParent = null;
	
	@Override
	public void enter(CallNode node) {
		if (node.getParent() != null) {
			System.out.println(node.getParent().getMethodName()+" -> "+node.getMethodName());
		}
	}

	@Override
	public void exit(CallNode node) {
	}

	@Override
	public void enter(CallTree tree) {
		System.out.println(HEADER);
	}

	@Override
	public void exit(CallTree tree) {
		System.out.println(FOOTER);
	}

}
