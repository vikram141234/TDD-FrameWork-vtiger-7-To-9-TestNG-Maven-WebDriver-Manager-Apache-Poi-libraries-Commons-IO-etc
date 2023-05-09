package CombinationalPractice;

import org.testng.annotations.Test;

public class DebuggingPractice {

	@Test
	public void test()
	{
		System.out.println("Main");
		System.out.println("div Called");
		int c=div(10, 5);
		System.out.println(c);
		System.out.println("exe completed");
	}
	
	public static int div(int a,int b)
	{
		int c=a%b;
		return c;
	}
}
