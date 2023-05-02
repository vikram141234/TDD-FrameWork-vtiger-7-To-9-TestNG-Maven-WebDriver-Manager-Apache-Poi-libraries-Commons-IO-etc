package RunTimeParametersORmavenParameters;

import org.testng.annotations.Test;

public class ReadDataFromCommandLine {

	@Test
	public void readData() {
		String Bvalue = System.getProperty("browser");
		String Uvalue = System.getProperty("url");
        String Uname = System.getProperty("uname");
        String Pwd = System.getProperty("pwd");
		
		System.out.println(Bvalue);
		System.out.println(Uvalue);
		System.out.println(Uname);
		System.out.println(Pwd);
		
	}
}
