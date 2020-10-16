package org.nmx.javaagent.tree;

public class SysoutVisitor implements CallTreeVisitor {

	String currentDecal = "";
	
	@Override
	public void enter(CallNode node) {
		node.output(currentDecal);
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