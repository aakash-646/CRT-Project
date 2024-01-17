package dataDriven;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelExample {
	String baseUrl = "https://hcltech-lms.career-shaper.com/login/index.php";
	WebDriver driver;
	Workbook wb;
	Sheet sh;
	String uname;
	String pwd;
	int numrow;
	
	@BeforeTest
	public void setup() {

		driver=new FirefoxDriver();
		driver.get("https://www.letskodeit.com/login");
	}
	
	@Test(dataProvider="TestData")
	public void setupClass(String email, String password) {
		 
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("login-password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
	}
	
	@DataProvider(name="TestData")
	public Object[][] TestDataFeed() {
		try {
			wb = Workbook.getWorkbook(new File("C:\\Users\\aakas\\OneDrive\\Desktop\\Testng.xls"));
			sh = wb.getSheet(0);
			numrow=sh.getRows();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Object[][] lmsData=new Object[numrow][sh.getColumns()];
		
		for(int i=0;i<numrow;i++) {
			lmsData[i][0]=sh.getCell(0,i).getContents();
			lmsData[i][1]=sh.getCell(1,i).getContents();
		}
		return lmsData;
		
		
		
	}

}

