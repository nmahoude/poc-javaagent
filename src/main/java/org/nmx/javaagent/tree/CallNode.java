package org.nmx.javaagent.tree;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CallNode {
	private Method method;

	private CallNode parent;
	List<CallNode> childs = new ArrayList<>();
	
	private int calls;
	private long duration = 0;
	
	private long currentStart = 0;
	
	public CallNode(CallNode parent, Method method) {
		super();
		this.parent = parent;
		this.method = method;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallNode other = (CallNode) obj;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}



	public void accept(CallTreeVisitor visitor) {
		visitor.enter(this);
		for (CallNode child : childs) {
			child.accept(visitor);
		}
		visitor.exit(this);
	}
	
	public CallNode enterChild(Method method) {
		
		CallNode child = null;

		if (!childs.isEmpty()) {
			CallNode callNode = childs.get(childs.size()-1);
			if (callNode.isMethod(method)) {
				child = callNode;
			}
		}
		
//		for (CallNode c: childs) {
//			if (c.isMethod(method)) {
//				child = c;
//				break;
//			}
//		}
		if (child == null) {
			child = new CallNode(this, method);
			childs.add(child);
		}
		child.currentStart = System.currentTimeMillis();
		return child;
	}

	private boolean isMethod(Method method) {
		return this.method.equals(method);
	}



	public CallNode exitChild() {
		calls++;
		duration += (System.currentTimeMillis() - currentStart);
		return this.parent;
	}



	public String getMethodName() {
		return method == null ? "" : method.getName();
	}



	public CallNode getParent() {
		return parent;
	}



	public Method method() {
		return method;
	}



	public long totalDuration() {
		return duration;
	}


	public long averageDuration() {
		return duration / calls;
	}

	public int callsCount() {
		return calls;
	}
}
