package vtiger.Practice;

import java.io.IOException;

import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateContactWithOrganization extends BaseClass{

	    @Test
	    public void createContactWithOrg() throws IOException
	    {
	    	String ORGNAME=eUtility.readDataFromExcel("Contacts", 4, 3)+jUtility.getRandomNum();
	    	String CONTACTNAME = eUtility.readDataFromExcel("Contacts", 4, 2);
	    	
	    	HomePage hPage=new HomePage(driver);
	    	hPage.clickOnOrgLnk();
	    	
	    	OrganizationsPage oPage=new OrganizationsPage(driver);
	    	oPage.clickOnCreateOrgLookUpImg();
	    	
	    	CreateNewOrganizationPage cnoPage=new CreateNewOrganizationPage(driver);
	    	cnoPage.createNewOrgSwitchToContacts(ORGNAME);
	    
	    	ContactsPage cPage=new ContactsPage(driver);
	    	cPage.ClickOnCreateContactLookUpImg();
	    	
	    	CreateNewContactPage cncPage=new CreateNewContactPage(driver);
	    	cncPage.createNewContact(driver, CONTACTNAME, ORGNAME);
	    	
	    	ContactInfoPage ciP=new ContactInfoPage(driver);
	    	String header=ciP.getContactHeader();
	    	if(header.contains(CONTACTNAME))
	    	{
	    		System.out.println("---Pass---");
	    	}
	    	else 
	    	{
				System.out.println("---Fail---");
			}
	    	
	    	hPage.logOutOfApp(driver);
		

	}

}
