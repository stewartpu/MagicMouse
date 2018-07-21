package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

	public WebDriver driver;
	
	//Constructor
		public ResultPage(WebDriver driver) {
			this.driver = driver;
		}
	
	By resultHeader	= By.className("entry-title");
	By message1	= By.xpath("//*[@id='post-30']/div/div[2]/p[1]");
		
	public WebElement resultHeader()
	{
		return driver.findElement(resultHeader);
	}
	
	public WebElement message1()
	{
		return driver.findElement(message1);
	}
	
}
