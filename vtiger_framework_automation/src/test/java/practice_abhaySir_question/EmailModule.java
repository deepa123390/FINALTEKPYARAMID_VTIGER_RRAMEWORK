package practice_abhaySir_question;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.generic.fileutilty.FileUtility;
import com.generic.webdriverutilty.WebDriverUtility;

public class EmailModule {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		FileUtility fil=new FileUtility();
		String URL=	fil.getDatafromPropertiesFile("url");
		String USERNAME=fil.getDatafromPropertiesFile("username");
		String PASSWORD=fil.getDatafromPropertiesFile("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Email']")).click();
		driver.findElement(By.xpath("//a[text()='Compose']")).click();
		
       wlib.switchToBrowserTab(driver, "module=Emails&action");
       WebElement dd= driver.findElement(By.xpath("//select[@name='parent_type']"));

      wlib.waitForElementPrsent(driver,  dd);
     
      wlib.select(dd,"Organizations");
     
     
     driver.findElement(By.xpath("//img[@alt='Select']")).click();
     wlib.switchToBrowserTab(driver, "module=Accounts&action");
     WebElement search=driver.findElement(By.name("search_text"));
     wlib.waitForElementPrsent(driver, search);
     search.sendKeys("deepa-");
     driver.findElement(By.name("search")).click();
     driver.findElement(By.xpath("//a[text()='deepa-']")).click();
     
     wlib.switchToBrowserTab(driver,"module=Emails&action");
  
  // wlib.waitForElementPrsent(driver, serachbtn);
  
   WebElement iframe=driver.findElement(By.xpath("//table[@class='cke_editor']//iframe"));
   
   driver.switchTo().frame(iframe);
   WebElement write=  driver.findElement(By.xpath("//html[@dir='ltr']"));
   write.sendKeys(("abcd"));
   driver.switchTo().defaultContent();
   WebElement serachbtn  = driver.findElement(By.xpath("//input[@value='  Save ']"));
   serachbtn.click();
     
   Alert ale=   driver.switchTo().alert();
      ale.accept();
	}
	

}
