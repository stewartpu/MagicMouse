package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	//Constructor
		public HomePage(WebDriver driver) {
			this.driver = driver;
		}
	
	By pcDropdown 	= By.linkText("Product Category");
	By accessories	= By.xpath("//*[@id='menu-item-34']/a");
	By addToCartBtn = By.xpath("//*[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div[1]/span/input");	
	By checkoutBtn	= By.xpath("//*[@id='header_cart']/a");
	
	public WebElement pcDropdown()
	{
		return driver.findElement(pcDropdown);
	}
	
	public WebElement accessories()
	{
		return driver.findElement(accessories);
	}
	
	public WebElement addToCartBtn()
	{
		return driver.findElement(addToCartBtn);
	}
	
	public WebElement checkoutBtn()
	{
		return driver.findElement(checkoutBtn);
	}
	
}
