package stewartpu.MagicMouse;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ResultPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PurchasePage;
import resources.Base;

public class SeleniumTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("WebDriver is successfully initialized");
		driver.manage().window().maximize();
		log.info("Browser window is maximized");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][8];
		data[0][0] = "pusu@msn.com";
		data[0][1] = "Stewart";
		data[0][2] = "Pu";
		data[0][3] = "1 King Street";
		data[0][4] = "Toronto";
		data[0][5] = "Canada";
		data[0][6] = "Ontario";
		data[0][7] = "4167207777";
		
		return data;		
	}
		
	@Test(dataProvider = "getData")
	public void e2eTransaction(String Email, String FirstName, String LastName, String Address, String City, String Country, String Province, String Phone) throws IOException
	{
		//STEP 1: Go to http://store.demoqa.com/ 
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
				
		//STEP 2: Hover to Product category and select Accessories
		HomePage shp = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(shp.pcDropdown()).build().perform();
		shp.accessories().click();
		log.info("Successfully selected Accessories from Product Category dropdown");
		
		//STEP 3: Click on “Add to Cart” for just Magic Mouse
		shp.addToCartBtn().click();
		log.info("Successfully clicked Add To Cart button");
		
		//STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page
		shp.checkoutBtn().click();
		CheckoutPage scho = new CheckoutPage(driver);
		String itemName = scho.itemName().getText();
		String quantity = scho.quantity().getAttribute("value");
		//To confirm if the purchase item is Magic Mouse and quantity is just 1, otherwise case will fail
		Assert.assertEquals(itemName, "Magic Mouse");
		Assert.assertEquals(quantity, "1");
		log.info("Confirmed the item and quantity in my cart: there is one Magic Mouse to be checked out");
		
		//STEP 5: After confirming, click on Continue
		scho.continueBtn().click();
		log.info("Successfully clicked Continue button");
		
		//STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase
		PurchasePage sp = new PurchasePage(driver);
		sp.email().sendKeys(Email);
		sp.firstName().sendKeys(FirstName);
		sp.lastName().sendKeys(LastName);
		sp.address().sendKeys(Address);
		sp.city().sendKeys(City);
		Select drpCountry = new Select(sp.country());
		drpCountry.selectByVisibleText(Country);
		sp.province().sendKeys(Province);
		sp.phone().sendKeys(Phone);
		sp.shippingAddrCheckBox().click();
		sp.purchaseBtn().click();
		log.info("Filled out all necessary info in checkout page and clicked Purchase button");
				
		//STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page
		ResultPage rp = new ResultPage(driver);
		
		//Assertion: if page title doesn't contain "Transaction Results", user is not landed at result page, case will fail
		assertTrue(driver.getTitle().contains("Transaction Results"));
						
		//To validate order-related message is displayed
		Assert.assertEquals(rp.resultHeader().getText(), "Transaction Results");
		Assert.assertTrue(rp.message1().isDisplayed());
		log.info("Successfully landed at transaction result page and order is placed");
	}

	@Test
	public void login() throws IOException
	{
		//Navigate to the home page
		driver.get(prop.getProperty("url"));
		log.info("Navitaged to homepage");
		
		LoginPage li = new LoginPage(driver);
		li.myAccount().click();
		li.userName().sendKeys(prop.getProperty("username"));
		li.passWord().sendKeys(prop.getProperty("password"));
		li.loginBtn().click();
		log.info("Input username and password and clicked Login button");
		
		Assert.assertTrue(li.logoutLink().isDisplayed());
		System.out.println("You are successfully logged in");
		log.info("Log out link is displayed, successfully logged in");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver = null;
	}
}
