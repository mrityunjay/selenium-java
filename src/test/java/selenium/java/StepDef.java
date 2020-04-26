package selenium.java;

public class StepDef {

	public void helloWorld() {
		System.out.println("Hello World");
		
	}
	
	public void hello(String name) {
		System.out.println("Hello "+name);
	}
	
	public String returnHello() {
		return "Hello Wold from returnHello method";
	}
}
