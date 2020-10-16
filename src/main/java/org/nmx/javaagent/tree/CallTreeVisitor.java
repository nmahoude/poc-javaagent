package org.nmx.javaagent.tree;

public interface CallTreeVisitor {

	public void enter(CallTree tree);
	public void exit(CallTree tree);
	
	
	public void enter(CallNode node);
	public void exit(CallNode node);
}
