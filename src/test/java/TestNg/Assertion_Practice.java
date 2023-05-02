package TestNg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Practice {

	@Test
	public void softAssertpractice()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertEquals(1, 0);
		System.out.println("Step-3");
		sa.assertTrue(false);
		System.out.println("Step-4");
		System.out.println("Step-5");
		System.out.println("Step-6");
	}
	@Test
	public void hardAssertPractice()
	{
		System.out.println("Second Script Step-1");
		Assert.assertEquals(true,false);
		System.out.println("Second Script Step-2");
	}
}
