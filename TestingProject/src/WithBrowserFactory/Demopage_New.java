package WithBrowserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Demopage_New {
	WebDriver driver;

	public Demopage_New(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(name = "FirstName")
	WebElement f1name;

	@FindBy(how = How.NAME, using = "LastName")
	WebElement l1name;

	@FindBy(how = How.NAME, using = "Email")
	WebElement email_;

	@FindBy(how = How.NAME, using = "Password")
	WebElement paswd;

	@FindBy(how = How.NAME, using = "ConfirmPassword")
	WebElement conpaswd;

	@FindBy(how = How.NAME, using = "register-button")
	WebElement register;

	@FindBy(how = How.NAME, using = "q")
	WebElement search_product;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[1]/div[2]/div[2]/form/button")
	WebElement searchbutton;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
	WebElement image_1;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[8]/div[2]/button")
	WebElement AddToCart_;            
	
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]")
	WebElement Shop_Cart;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/label")
	WebElement agree_box;

	@FindBy(how = How.ID, using = "checkout")
	WebElement Check_Box;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement Check_Guest;

	@FindBy(how = How.NAME, using = "BillingNewAddress.FirstName")
	WebElement F_name;

	@FindBy(how = How.ID, using = "BillingNewAddress_LastName")
	WebElement L_name;

	@FindBy(how = How.ID, using = "BillingNewAddress_Email")
	WebElement email_1;
	@FindBy(how = How.NAME, using = "BillingNewAddress.City")
	WebElement city_name;
	@FindBy(how = How.NAME, using = "BillingNewAddress.Address1")
	WebElement Address_;
	@FindBy(how = How.NAME, using = "BillingNewAddress.ZipPostalCode")
	WebElement zip_c;
	@FindBy(how = How.NAME, using = "BillingNewAddress.PhoneNumber")
	WebElement phone_number_;
	@FindBy(how = How.NAME, using = "save")
	WebElement cont1;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")
	WebElement contt1;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")
	WebElement conttt1;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")
	WebElement contttt1;

	public void Demo_page(String fname, String lname, String email, String pass, String conpass, String search_p,
			String firstname, String lastname, String Email, String city, String address, String Zip_postalcode,
			String phone_number) {
		f1name.sendKeys(fname);
		l1name.sendKeys(lname);
		email_.sendKeys(email);
		paswd.sendKeys(pass);
		conpaswd.sendKeys(conpass);
		register.click();
		search_product.sendKeys(search_p);
		searchbutton.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)", "");
		image_1.click();
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,300)", "");
		AddToCart_.click();
		
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,-300)", "");
		Shop_Cart.click();
		System.out.println("product added to your shopping cart");
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("window.scrollBy(0,400)", "");
		agree_box.click();
		Check_Box.click();
		System.out.println("Checked out successfully");
		Check_Guest.click();
		F_name.sendKeys(firstname);
		L_name.sendKeys(lastname);
		email_1.sendKeys(Email);
		Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		dropdown.selectByVisibleText("India");
		dropdown.selectByIndex(100);
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,100)", "");
		city_name.sendKeys(city);
		Address_.sendKeys(address);
		zip_c.sendKeys(Zip_postalcode);
		phone_number_.sendKeys(phone_number);
		cont1.click();
		contt1.click();
		conttt1.click();
		contttt1.click();

		System.out.println("Your order is confirmed");  
	}

}