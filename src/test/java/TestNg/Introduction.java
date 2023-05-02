package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Introduction {

	@Test(priority=1,dependsOnMethods="wakeUp")
	public void eat()
	{
		System.out.println("User Finished Eating");
	}
	
	@Test(priority=2)
	public void sleep()
	{
		System.out.println("User slept");
	}
	
	@Test(priority=0)
	public void wakeUp()
	{
	      Assert.fail();
		System.out.println("User Wokeup");
	}
	
	
	
}
