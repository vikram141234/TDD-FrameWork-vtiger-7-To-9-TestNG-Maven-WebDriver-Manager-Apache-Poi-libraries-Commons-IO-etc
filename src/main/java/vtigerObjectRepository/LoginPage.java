package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class LoginPage {  //Rule-1:Create a seperate class for every webpage

     //Rule-2:Identify the elements using annotations
	@FindBy(name="user_name")private WebElement userNameEdt;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})private WebElement passwordEdt;
		
	@FindBy(id="submitButton")private WebElement submitBtn;
		
	//Rule-3:Create a constructor to initilise these elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-4:Provide getters to access these variables

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library - To optimize the test script
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}
	
	
	

}
