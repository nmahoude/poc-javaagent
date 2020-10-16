package org.nmx.javaagent.tree;

import java.util.HashMap;
import java.util.Map;

public class CallHierachies {
	private static Map<String, CallTree> trees = new HashMap<>();
	
	public static CallTree getTree(String id) {
		CallTree tree = trees.get(id);
		if (tree == null) {
			tree = new CallTree();
			trees.put(id, tree);
		}
		return tree;
	}
}
