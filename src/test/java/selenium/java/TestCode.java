package selenium.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCode {

	public static void main(String[] args) {
		StepDef obj=new StepDef();
		Class c = obj.getClass();
		
		try {
			Method m=c.getMethod("helloWorld");
			m.invoke(new StepDef());
			
			m=c.getMethod("hello"	, String.class);
			m.invoke(new StepDef(), "Mrityunjay");
			
			m=c.getMethod("returnHello");
			String data=(String) m.invoke(new StepDef());
			System.out.println(data);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
