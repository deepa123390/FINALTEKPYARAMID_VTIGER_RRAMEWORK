package create_org;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.utility.baseclass.BaseClass;
import com.generic.webdriverutilty.UtilityClassObject;
import com.vtiger.objectRepository.CreatingNewOrganisationPage;
import com.vtiger.objectRepository.Homepage;
import com.vtiger.objectRepository.OrganizationInformation;
import com.vtiger.objectRepository.Organizations;
//@Listeners(com.comcast.Listener_utility.ListenerImplementation.class)
public class CreateOrg_Test extends BaseClass {

	@Test(groups="smoke")

	public void createOrg_test() throws IOException {

		Homepage homepage = new Homepage(driver);

		homepage.getOrgLink().click();
		Organizations organizations = new Organizations(driver);
		organizations.getPlusImg().click();

		String orgname = eil.getDtataFromExcelFile("createorg", 1, 1) + "_" + jlib.getRandomNumber();
		String shipAddrss = eil.getDtataFromExcelFile("createorg", 1, 5);
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.getOrgName().sendKeys(orgname);
		creatingNewOrganisationPage.getShippingAdrs().sendKeys(shipAddrss);

		creatingNewOrganisationPage.getSavebtn().click();
		OrganizationInformation OrganizationInformationPage = new OrganizationInformation(driver);

		WebElement headerinfo = OrganizationInformationPage.getheaderInfo();

		wlib.waitForElementPrsent(driver, headerinfo);

		// validate
		String header = headerinfo.getText();
		Assert.assertTrue(header.contains(orgname));
		UtilityClassObject.getTest().log(Status.PASS, "HEADER INFO VALIDATED");

		String actualOrgName = OrganizationInformationPage.getactualOrgNameInfo().getText();
		actualOrgName = actualOrgName.trim();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualOrgName, orgname);
		soft.assertAll();
		UtilityClassObject.getTest().log(Status.PASS, "ORGANISATION NAME VALIDATED");
	}

	@Test(groups="regression")
	public void createOrg_with_PhoneNum_test() throws EncryptedDocumentException, IOException {

		Homepage homepage = new Homepage(driver);
		Organizations organizations = new Organizations(driver);
		homepage.getOrgLink().click();
		organizations.getPlusImg().click();

		String orgname = eil.getDtataFromExcelFile("createorg", 1, 1) + "_" + jlib.getRandomNumber();
		String shipAddrss = eil.getDtataFromExcelFile("createorg", 1, 5);
		String phoneNumber = eil.getDtataFromExcelFile("createorg", 1, 4);

		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.getOrgName().sendKeys(orgname);
		creatingNewOrganisationPage.getShippingAdrs().sendKeys(shipAddrss);
		creatingNewOrganisationPage.getPhoneNumberEdit().sendKeys(phoneNumber);

		creatingNewOrganisationPage.getSavebtn().click();

		// validate
		OrganizationInformation organizationInformationPage = new OrganizationInformation(driver);
		String headerText = organizationInformationPage.getheaderInfo().getText();
		Assert.assertTrue(headerText.contains(orgname));
		UtilityClassObject.getTest().log(Status.INFO, "ORGANISATION NAME VALIDATED");
		

		// VALIDATE PHONE NUMBER
		String actphoneNum = organizationInformationPage.getphoneNumberINFO().getText();
		actphoneNum = actphoneNum.trim();
		Assert.assertEquals(actphoneNum, phoneNumber);
		UtilityClassObject.getTest().log(Status.INFO, "PHONE NUMBER VALIDATED");
	}

	@Test(groups="regression")
	public void createOrg_with_Industry_test() throws InterruptedException, EncryptedDocumentException, IOException {
		Homepage homepage = new Homepage(driver);
		Organizations organizations = new Organizations(driver);
		homepage.getOrgLink().click();
		organizations.getPlusImg().click();

		String orgname = eil.getDtataFromExcelFile("createorg", 1, 1) + "_" + jlib.getRandomNumber();
		String shipAddrss = eil.getDtataFromExcelFile("createorg", 1, 5);
		String INDUSTRY = eil.getDtataFromExcelFile("createorg", 1, 2);
		String TYPE = eil.getDtataFromExcelFile("createorg", 1, 3);

		// Industry
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		WebElement industrydd = creatingNewOrganisationPage.getindustrydd();

		Select sel = new Select(industrydd);
		sel.selectByVisibleText(INDUSTRY);
		// type

		WebElement typedd = creatingNewOrganisationPage.gettypedd();
		Select seltype = new Select(typedd);
		seltype.selectByContainsVisibleText(TYPE);

		creatingNewOrganisationPage.getOrgName().sendKeys(orgname);
		creatingNewOrganisationPage.getShippingAdrs().sendKeys(shipAddrss);
		creatingNewOrganisationPage.getSavebtn().click();
		Thread.sleep(3000);

		// VALIDATION
		OrganizationInformation organizationInformationPage = new OrganizationInformation(driver);
		String value = organizationInformationPage.getindustryInfo().getText();
		value=value.trim();
		Assert.assertEquals(value, INDUSTRY);
		UtilityClassObject.getTest().log(Status.PASS, "INDUSTRY VALIDATED");

		String typevalue = organizationInformationPage.gettypeInfo().getText();
		typevalue=typevalue.trim();
		Assert.assertEquals(typevalue, typevalue);
		UtilityClassObject.getTest().log(Status.PASS, "TYPE VALIDATED");

	}

}
