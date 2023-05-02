package vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage { //Rule-1:Create a seperate class for every webpage

	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement OrgHeaderText;
	
	// creating constructor
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//generating getters
	public WebElement getContactHeader() {
		return OrgHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture header text and return to the caller
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}

}
