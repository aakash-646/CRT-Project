package WithBrowserFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Test_Demo_new {
	WebDriver driver;

	@Test
	public void Order_product() {

		driver = Browser_Factory.startBrowser("Firefox","https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		Demopage_New dn = PageFactory.initElements(driver, Demopage_New.class);
		dn.Demo_page("Anil", "Rajput", "xiwaliy974@usharer.com", "t.y.p.e@1233", "t.y.p.e@1233",
				"Apple MacBook Pro 13-inch", "Honey", "Singh", "xiwaliy974@usharer.com", "Vishakhapatanam",
				"singapore colony", "123456", "1234567890");
		driver.close();

	}
}