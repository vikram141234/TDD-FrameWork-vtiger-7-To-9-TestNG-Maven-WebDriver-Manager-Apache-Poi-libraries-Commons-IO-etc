package vtigerObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;

public class ContactInfoPage {//Rule-1:Create a seperate class for every webpage

    //Rule-2:Identify the elements using annotations
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement contactHeaderText;
	
	//Rule-3:Create a constructor to initilise these elements   //span[@class='dvHeaderText']   old
	public ContactInfoPage(WebDriver driver)     //span[@class='dvHeaderText']
	{
		PageFactory.initElements(driver, this);
	}
	//Rule-4:Provide getters to access these variables
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Library - To optimize the test script
	/**
	 * This method will capture header text and return to the caller
	 * @return 
	 */
    public String getContactHeader()
    {
    	return contactHeaderText.getText();
    }
    
 
	
	
}
