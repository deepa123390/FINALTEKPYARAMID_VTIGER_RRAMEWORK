package practice_abhaySir_question;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public void getData() throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		FileInputStream fis = new FileInputStream("C:\\Users\\preet\\OneDrive\\Desktop\\AMAZON.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//button[@alt='Continue shopping']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
		List<WebElement> l1 = driver.findElements(By.xpath(
				"//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']//span"));

		for (WebElement elements : l1) {
			String name = (elements.getText());

			Row row = wb.getSheet("amazon").createRow(1);
			row.createCell(0).setCellValue(name);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\preet\\OneDrive\\Desktop\\AMAZON.xlsx");
			wb.write(fos);
			wb.close();

		}

		/*
		 * List<WebElement> l2=
		 * driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		 * for(WebElement elements:l2) { System.out.println(elements.getText()); }
		 */
	}
}
