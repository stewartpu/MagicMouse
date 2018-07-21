package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchasePage {

	public WebDriver driver;
	
	//Constructor
		public PurchasePage(WebDriver driver) {
			this.driver = driver;
		}
	
	By email	 			= By.id("wpsc_checkout_form_9");
	By firstName			= By.id("wpsc_checkout_form_2");
	By lastName				= By.id("wpsc_checkout_form_3");	
	By address				= By.id("wpsc_checkout_form_4");
	By city		 			= By.id("wpsc_checkout_form_5");
	By country				= By.id("wpsc_checkout_form_7");
	By province				= By.name("collected_data[6]");	
	By phone				= By.id("wpsc_checkout_form_18");
	By shippingAddrCheckBox	= By.id("shippingSameBilling");
	By purchaseBtn			= By.xpath("//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input");
		
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement firstName()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement lastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement address()
	{
		return driver.findElement(address);
	}
	
	public WebElement city()
	{
		return driver.findElement(city);
	}
	
	public WebElement country()
	{
		return driver.findElement(country);
	}
	
	public WebElement province()
	{
		return driver.findElement(province);
	}
	
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement shippingAddrCheckBox()
	{
		return driver.findElement(shippingAddrCheckBox);
	}
	
	public WebElement purchaseBtn()
	{
		return driver.findElement(purchaseBtn);
	}
	
	
	
	
}
