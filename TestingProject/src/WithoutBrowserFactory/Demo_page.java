package WithoutBrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Demo_page {
	WebDriver driver;

	By fname = By.name("FirstName");
	By lname = By.name("LastName");
	By email = By.name("Email");
	By pass = By.name("Password");
	By conpass = By.name("ConfirmPassword");
	By Register = By.name("register-button");
	By search_p = By.name("q");
	By searchbtn = By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/button");
	By image = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a");
	By AddToCart = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[8]/div[2]/button");
	By ShopCart = By.id("topcartlink");
	By agreebox = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/label");
	By CheckBox = By.id("checkout");
	By CheckGuest = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]");
	By Fname = By.id("BillingNewAddress_FirstName");
	By Lname = By.id("BillingNewAddress_LastName");
	By email1 = By.id("BillingNewAddress_Email");
	By cityname = By.name("BillingNewAddress.City");
	By Address = By.name("BillingNewAddress.Address1");
	By zip = By.name("BillingNewAddress.ZipPostalCode");
	By Phonenumber = By.name("BillingNewAddress.PhoneNumber");
	By cont = By.name("save");
	By contt = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button");
	By conttt = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button");
	By contttt = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button");
	
	public void setfname(String Firstname) {
		driver.findElement(fname).sendKeys(Firstname); }
	
	public void setlname(String Lastname) {
		driver.findElement(lname).sendKeys(Lastname); }
	
	public void email(String Email) {
		driver.findElement(email).sendKeys(Email); }
	
	public void setpass(String password) {
		driver.findElement(pass).sendKeys(password);	}
	
	public void setconpass(String confirmpass) {
		driver.findElement(conpass).sendKeys(confirmpass);	}
	
	public void register() {
		driver.findElement(Register).click();	}
	
	public void search(String products) {
		driver.findElement(search_p).sendKeys(products);	}
	
	public void sbutton() {
		driver.findElement(searchbtn).click();	}
	
	public void image_product() {
		driver.findElement(image).click();	}
	
	public void addtocart() {
		driver.findElement(AddToCart).click();	}
	
	public void shopcart() {
		driver.findElement(ShopCart).click();	}
	
	public void agreecheckbox() {
		driver.findElement(agreebox).click();	}
	
	public void checkout() {
		driver.findElement(CheckBox).click();	}
	
	public void Check_Guest() {
		driver.findElement(CheckGuest).click();	}
	
	public void firstname(String firstname) {
		driver.findElement(Fname).sendKeys(firstname);	}
	
	public void lastname(String lastname) {
		driver.findElement(Lname).sendKeys(lastname);	}
	
	public void Email(String Email) {
		driver.findElement(email1).sendKeys(Email);	}
	
	public void City(String city) {
		driver.findElement(cityname).sendKeys(city);	}
	
	public void address(String address) {
		driver.findElement(Address).sendKeys(address);	}
	
	public void zip_postalcode(String zip_postalcode) {
		driver.findElement(zip).sendKeys(zip_postalcode);	}
	
	public void phone_number(String phone_number) {
		driver.findElement(Phonenumber).sendKeys(phone_number);	}
	
	public void conti() {
		driver.findElement(cont).click();	}
	
	public void contin() {
		driver.findElement(contt).click();	}
	
	public void continn() {
		driver.findElement(conttt).click();	}
	
	public void continnn() {
		driver.findElement(contttt).click();	}
	
	public Demo_page(WebDriver driver) {
		this.driver = driver;	}
}
