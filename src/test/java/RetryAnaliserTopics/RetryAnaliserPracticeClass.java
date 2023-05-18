package RetryAnaliserTopics;

import org.testng.Assert;
import org.testng.annotations.Test;
// if we give retry analiser class level all the scripts in the class can retry acc to retry count
//Thats y we did not give in class level coz all test scripts will not fail
public class RetryAnaliserPracticeClass {
//Thats y We will give retryAnaliser in method Level 
	    @Test(retryAnalyzer =RetryAnaliserTopics.RetryAnaliserClassImplementationClass.class)
	    //After declaring retryAnaliser we have to give the implementation class qualified path 
		public void analiserPractice()
		{   //if we give fail it will fails
		//	Assert.fail();                   //if Assert.fail() is not there it will run by defaultly 3+1 times 
			System.out.println("Hi");   
		}
	    //This script is getting to fail coz we failed it by giving Assert.fail();
	    
}
