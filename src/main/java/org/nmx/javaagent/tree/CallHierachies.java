package org.nmx.javaagent.tree;

import java.util.HashMap;
import java.util.Map;

import org.nmx.javaagent.output.plantuml.PlantumlVisitor;
import org.nmx.javaagent.output.sysout.SysoutVisitor;

public class CallHierachies {
	private static Map<String, CallTree> trees = new HashMap<>();
	private static CallTreeVisitor visitor = new SysoutVisitor();
	
	public static CallTree getTree(String id) {
		CallTree tree = trees.get(id);
		if (tree == null) {
			tree = new CallTree();
			trees.put(id, tree);
		}
		return tree;
	}

	public static void setOutput(CallTreeVisitor visitor) {
		CallHierachies.visitor = visitor;
	}

	public static void output(CallTree callTree) {
		callTree.accept(visitor);
	}
}
