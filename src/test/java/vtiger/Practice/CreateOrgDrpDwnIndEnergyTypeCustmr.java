package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateOrgDrpDwnIndEnergyTypeCustmr extends BaseClass{

	@Test(groups="RegressionSuite")
	public void createOrgIndTypeDrpDwn() throws EncryptedDocumentException, IOException 
	{
		String ORGNAME = eUtility.readDataFromExcel("Organization", 7, 2)+jUtility.getRandomNum();
		String INDNAME = eUtility.readDataFromExcel("Organization", 7, 3);
//		String TYPENAME = eUtility.readDataFromExcel("Organization", 7, 4);
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnOrgLnk();
		
		OrganizationsPage oPage=new OrganizationsPage(driver);
		oPage.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnoPage=new CreateNewOrganizationPage(driver);
		cnoPage.createNewOrg(ORGNAME, INDNAME);
		
		
		
		OrganizationInfoPage oiPage=new OrganizationInfoPage(driver);
		String header=oiPage.getOrgHeader();
		
		if(header.contains(ORGNAME))
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
