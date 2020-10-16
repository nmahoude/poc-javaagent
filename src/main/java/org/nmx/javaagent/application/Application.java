package org.nmx.javaagent.application;

public class Application {

	public static void main(String[] args) {
		Application app = new Application();
		
		System.out.println("Starting");
		app.inMethod1();
		app.inMethod2();
		app.inMethod2();
		app.inMethod2();
		System.out.println("Ending");
	}

	private void inMethod1() {
		System.out.println("In method 1");
	}

	private void inMethod2() {
		System.out.println("In method 2");
	}

}
