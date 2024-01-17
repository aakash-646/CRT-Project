package WithBrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Factory {

	static WebDriver driver;
	public static WebDriver startBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\aakas\\OneDrive\\Desktop\\edgedriver_win64 (1) 1\\msedgedriver.exe");
			driver= new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
