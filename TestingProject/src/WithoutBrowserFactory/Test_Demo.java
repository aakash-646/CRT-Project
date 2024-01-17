package WithoutBrowserFactory;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_Demo {

	WebDriver driver;

	@Test
	public void setUp() {

		System.setProperty("webdriver.edge.driver","C:\\Users\\aakas\\OneDrive\\Desktop\\edgedriver_win64 (1) 1\\msedgedriver.exe");
		driver=new EdgeDriver();
		String baseUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Demo_page obj = new Demo_page(driver);

		obj.setfname("Aakash");
		obj.setlname("Verma");
		obj.email("xiwaliy974@usharer.com");
		obj.setpass("t.y.p.e@1233");
		obj.setconpass("t.y.p.e@1233");
		obj.register();
		System.out.println("Your registration completed");

		String titleTxt = driver.getTitle();
		Assert.assertTrue(titleTxt.contains("nopCommerce demo store"));

		System.out.println(titleTxt);

		obj.search("Apple MacBook Pro 13-inch");
		obj.sbutton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)", "");

		obj.image_product();
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,300)", "");
		obj.addtocart();
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,-300)", "");
		obj.shopcart();
		System.out.println("product added to your shopping cart");
          
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("window.scrollBy(0,400)", "");
		obj.agreecheckbox();
		obj.checkout();
		System.out.println("Checked out successfully");
 
		obj.Check_Guest();
		obj.firstname("Anshika");
		obj.lastname("Gupta");
		obj.Email("xiwaliy974@usharer.com");
		Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		dropdown.selectByVisibleText("India");
		dropdown.selectByIndex(100);
		obj.City("Kanpur");
		obj.address("Singapore colony");
		obj.zip_postalcode("123456");
		obj.phone_number("123456789");
		obj.conti();
		obj.contin();
		obj.continn();
		obj.continnn();
		System.out.println("Your order is confirmed");

		driver.quit();
	}

}
