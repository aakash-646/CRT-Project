package CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB {
	WebDriver driver;
	@Test 
	@Parameters("Browser")
	public void test1(String browser) {
		if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\aakas\\OneDrive\\Desktop\\edgedriver_win64 (1) 1\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get("https://www.saucedemo.com");
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();
		} else if (browser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
			driver.get("https://www.saucedemo.com");
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();
		} else if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions CP = new ChromeOptions();
			CP.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver =new ChromeDriver(CP);
			driver.get("https://www.saucedemo.com");
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();   
		}   
	}

}
