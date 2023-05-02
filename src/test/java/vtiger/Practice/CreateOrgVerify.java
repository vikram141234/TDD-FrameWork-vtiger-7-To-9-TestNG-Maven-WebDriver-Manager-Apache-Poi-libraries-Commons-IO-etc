package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateOrgVerify extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createOrg() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtility.readDataFromExcel("Contacts", 4, 3)+jUtility.getRandomNum();
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnOrgLnk();
		
		OrganizationsPage oPage=new OrganizationsPage(driver);
		oPage.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnoPage=new CreateNewOrganizationPage(driver);
		cnoPage.createNewOrg(ORGNAME);
		
	    OrganizationInfoPage oiPage=new OrganizationInfoPage(driver);
	    String Header = oiPage.getOrgHeader();
	    if(Header.contains(ORGNAME))
	    {
	    	System.out.println("---Pass---Only Org");
	    }
	    else 
	    {
	    	System.out.println("---Fail---Only Org");
		}
	    
	    hPage.logOutOfApp(driver);
	}

}
