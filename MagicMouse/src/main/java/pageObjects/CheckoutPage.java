package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

	public WebDriver driver;
	
	//Constructor
		public CheckoutPage(WebDriver driver) {
			this.driver = driver;
		}
	
	By itemName 	= By.linkText("Magic Mouse");
	By quantity		= By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[1]");
	By continueBtn	= By.className("step2");

	public WebElement itemName()
	{
		return driver.findElement(itemName);
	}
	
	public WebElement quantity()
	{
		return driver.findElement(quantity);
	}
	
	public WebElement continueBtn()
	{
		return driver.findElement(continueBtn);
	}
	
}
