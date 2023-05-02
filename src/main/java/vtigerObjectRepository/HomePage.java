package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{//Rule-1:Create a seperate class for every webpage

    //Rule-2:Identify the elements using annotations
	@FindBy(linkText="Organizations")private WebElement OrganizationLnk;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")private WebElement ContactLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement AdministratorLnk;
	
	@FindBy(xpath="//a[.='Sign Out']")private WebElement SignOutLnk;
	//Rule-3:Create a constructor to initilise these elements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule-4:Provide getters to access these variables
	
	
	
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}
	public WebElement getContactLnk() {
		return ContactLnk;
	}
	
	public WebElement getAdministrationLnk() {
		return AdministratorLnk;
	}
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	//Business Library - To optimize the test script
	/**
	 * This Method will click on Org link
	 */
	public void clickOnOrgLnk()
	{	
		OrganizationLnk.click();
	}
	/**
	 * This Method will click on Contact link
	 */
	public void clickOnContactLnk()
	{
		ContactLnk.click();
	}
	
	/**
	 * This Method will click on Admin link
	 */
	public void clickOnAdminLnk()
	{
		AdministratorLnk.click();
	}
	/**
	 * This Method will perform SignOut Operation.
	 */
	public void logOutOfApp(WebDriver driver)
	{
		
		mouseHoverAction(driver,AdministratorLnk);
		SignOutLnk.click();
	}

}
 