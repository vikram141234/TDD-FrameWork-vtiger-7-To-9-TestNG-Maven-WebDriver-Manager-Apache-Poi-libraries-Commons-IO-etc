package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateMultipleOrgIndDrpDwn extends BaseClass{


	@Test(dataProvider = "getData")
	public void createMultipleOrgIndTest(String ORG,String IND) throws IOException
	{
		
		String ORGNAME=ORG+jUtility.getRandomNum();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME, IND);

	    String Header=driver.findElement(By.className("dvHeaderText")).getText();
        
	    Assert.assertTrue(Header.contains(ORGNAME));
	}
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtility.readMultipleDataFromExcel("DataProviderOrgInd");
	}
	
}
		


