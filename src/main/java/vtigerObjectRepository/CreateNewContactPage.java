package vtigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{ //Rule-1:Create a seperate class for every webpage
	
	//Rule-2:Identify the elements using annotations
	
	@FindBy(name="lastname")private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")private WebElement orgLookUpImg;
	
	@FindBy(name="search_text")private WebElement orgSearchEdt;
	
	@FindBy(name="search")private WebElement orgSearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	//Rule-3:Create a constructor to initilise these elements
	
	public CreateNewContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Rule-4:Provide getters to access these variables
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library - To optimize the test script
	/**
	 * This method will create contact with mandatory fields
	 * @param CONTACTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}

	/**
	 * This method will create new contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
	}
		}
