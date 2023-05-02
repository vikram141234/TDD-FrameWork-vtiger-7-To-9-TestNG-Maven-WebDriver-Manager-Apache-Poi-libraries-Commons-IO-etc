package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{//Rule-1:Create a seperate class for every webpage

    //Rule-2:Identify the elements using annotations
	@FindBy(name="accountname")private WebElement orgNameEdt;
	
	@FindBy(name="industry")private WebElement industryDropDwn;
	
	@FindBy(xpath="//select[@name='accounttype']")private WebElement typeDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
//	@FindBy(linkText="Organizations")private WebElement orgPage;
	
	@FindBy(linkText="Contacts")private WebElement contactLnk;
	
	//Rule-3:Create a constructor to initilise these elements
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-4:Provide getters to access these variables
	public WebElement getCreateOrgBtn() {
		return orgNameEdt;
	}
	
	public WebElement getIndustryDropDwn() {
		return industryDropDwn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}

	public WebElement getContactPage() {
		return contactLnk;
	}
	
	//Business Library - To optimize the test script
	/**
	 * This method will create org with mandatory fields
	 * @param ORGNAME
	 */
    
	public void createNewOrg(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	public void createNewOrg(String ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDwn,INDUSTRY);
		saveBtn.click();
	}
	
//	public void createNewOrg(String ORGNAME,String TYPE)
//	{
//		orgNameEdt.sendKeys(ORGNAME);
//		handleDropdown(typeDropDwn, TYPE);
//		saveBtn.click();
//	}
	
	public void createNewOrgSwitchToContacts(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
		contactLnk.click();
	}


}
