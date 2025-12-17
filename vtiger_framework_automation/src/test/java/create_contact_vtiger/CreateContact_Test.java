package create_contact_vtiger;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.utility.baseclass.BaseClass;
import com.generic.fileutilty.ExcelUtility;
import com.generic.webdriverutilty.UtilityClassObject;
import com.vtiger.objectRepository.Contact;
import com.vtiger.objectRepository.ContactInformation;
import com.vtiger.objectRepository.CreatingNewContactPage;
import com.vtiger.objectRepository.CreatingNewOrganisationPage;
import com.vtiger.objectRepository.Homepage;
import com.vtiger.objectRepository.OrganizationInformation;
import com.vtiger.objectRepository.Organizations;
import com.vtiger.objectRepository.OrganizationsLookUpWindow;

//@Listeners(com.comcast.Listener_utility.ListenerImplementation.class)
public class CreateContact_Test extends BaseClass {

	@Test(groups="smoke")
	public void createContact() throws IOException {

		Contact c = new Contact(driver);
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformation ContactInformationPage = new ContactInformation(driver);

		String lastName = eil.getDtataFromExcelFile("contacts", 1, 0);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to HomePage");
		Homepage hp = new Homepage(driver);
		hp.getContactsLink().click();
		c.getplusicon().click();
		creatingNewContactPage.getlastNameEdit().sendKeys(lastName);
		creatingNewContactPage.getsavebtn().click();

		// validate last name
		String actlastName = ContactInformationPage.getlastnameinfo().getText();
		actlastName = actlastName.trim();
		Assert.assertEquals(actlastName, lastName);
		UtilityClassObject.getTest().log(Status.PASS, "LAST NAME VALIDATED");

	}

	@Test(groups="regression")
	public void createContactWithSupportDate_test() throws InterruptedException, IOException {

		Contact contactPage = new Contact(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformation ContactInformationPage = new ContactInformation(driver);

		ExcelUtility eil = new ExcelUtility();
		String lastName = eil.getDtataFromExcelFile("contacts", 1, 0);

		// GET CURRENT/start DATE

		String startDate = jlib.getDateYYYYMMDD();

		// GET post/pre/endt DATE
		String enddate = jlib.getRequiredDateYYYYMMDD(30);
//System.out.println(enddate);
		Homepage homepage = new Homepage(driver);
		homepage.getContactsLink().click();
		contactPage.getplusicon().click();
		creatingNewContactPage.getlastNameEdit().sendKeys(lastName);

		creatingNewContactPage.getsupportDateEdit().sendKeys(startDate);
		WebElement endDateTF = creatingNewContactPage.getendDateEdit();
		endDateTF.clear();
		endDateTF.sendKeys(enddate);

		creatingNewContactPage.getsavebtn().click();

		Thread.sleep(2000);
//validate
		String actStartDate = ContactInformationPage.getactualStartDateInfo().getText();

		actStartDate = actStartDate.trim();
		Assert.assertEquals(actStartDate, startDate);
		UtilityClassObject.getTest().log(Status.INFO, "START DATE VALIDATED");

		String actEndDate = ContactInformationPage.getactualEndDateInfo().getText();
		// actEndDate=actEndDate.trim();
		Assert.assertEquals(actEndDate, enddate);
		UtilityClassObject.getTest().log(Status.INFO, "END DATE VALIDATED");

	}

	@Test(groups="regression")
	public void createContactwithOrgIntegration_test()
			throws InterruptedException, EncryptedDocumentException, IOException {

		// create org

		Contact contactPage = new Contact(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformation contactInformationpage = new ContactInformation(driver);

		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		Organizations organizationsPage = new Organizations(driver);

		OrganizationInformation OrganizationInformationPage = new OrganizationInformation(driver);

		OrganizationsLookUpWindow OrganizationsLookUpWindowPage = new OrganizationsLookUpWindow(driver);

		Homepage homepage = new Homepage(driver);
		homepage.getOrgLink().click();
		organizationsPage.getPlusImg().click();

		String orgname = eil.getDtataFromExcelFile("createorg", 1, 1) + "_" + jlib.getRandomNumber();
		String shipAddrss = eil.getDtataFromExcelFile("createorg", 1, 5);
		String lastName = eil.getDtataFromExcelFile("contacts", 1, 0);

		creatingNewOrganisationPage.getOrgName().sendKeys(orgname);
		creatingNewOrganisationPage.getShippingAdrs().sendKeys(shipAddrss);

		creatingNewOrganisationPage.getSavebtn().click();

		Thread.sleep(2000);

		homepage.getContactsLink().click();
		contactPage.getplusicon().click();
		creatingNewContactPage.getlastNameEdit().sendKeys(lastName);
		creatingNewContactPage.getlookUpIcon().click();
		// switch to window
		wlib.switchToBrowserTab(driver, "module=Accounts");

		OrganizationsLookUpWindowPage.getserachEdit().sendKeys(orgname);
		OrganizationsLookUpWindowPage.getserachbtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		// switch to parent window
		wlib.switchToBrowserTab(driver, "module=Contacts&action");
		Thread.sleep(2000);

		creatingNewContactPage.getsavebtn().click();

		// validate orgname
		String actualOrgName = OrganizationInformationPage.getactualOrgNameInfo().getText();
		actualOrgName = actualOrgName.trim();
		Assert.assertEquals(actualOrgName, orgname);
		UtilityClassObject.getTest().log(Status.INFO, "ORGANISATION NAME VALIDATED");
	}

}
