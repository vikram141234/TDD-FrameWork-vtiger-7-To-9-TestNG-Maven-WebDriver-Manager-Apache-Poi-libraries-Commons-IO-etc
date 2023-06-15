package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//Rule-1:Create a seperate class for every webpage

    //Rule-2:Identify the elements using annotations
	@FindBy(xpath="//img[@title='Create Organization...']")private WebElement CreateOrgBtn;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")private WebElement ContactLnk;
	
	//Rule-3:Create a constructor to initilise these elements
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	//Rule-4:Provide getters to access these variables
	public WebElement clickOnCreateOrgBtn() {
		return CreateOrgBtn;
	}
	
	public WebElement getContactLnk() {
		return ContactLnk;
	}
	//Business Library - To optimize the test script
	/**
	 * This method will click on create org Contact Button
	 */
	public void clickOnCreateOrgLookUpImg() 
	{
		CreateOrgBtn.click();
	}
	
	public void clickOnContactLnk()
	{
		ContactLnk.click();
	}

	
}
