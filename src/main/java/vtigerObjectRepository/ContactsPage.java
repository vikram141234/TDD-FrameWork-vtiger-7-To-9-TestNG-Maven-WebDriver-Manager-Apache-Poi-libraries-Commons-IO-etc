package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")private WebElement createContactLookUpImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsLnk() {
		return createContactLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create contact lookup Img
	 */
	public void ClickOnCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
	}
}
