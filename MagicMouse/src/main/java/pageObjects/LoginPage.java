package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	//Constructor to give the driver a Selenium life
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
	
	By myAccount 	= By.xpath("//*[@id='account']/a");
	By userName		= By.id("log");
	By passWord		= By.id("pwd");
	By loginBtn		= By.id("login");
	By logoutLink	= By.linkText("Log out");

	public WebElement myAccount()
	{
		return driver.findElement(myAccount);
	}
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement passWord()
	{
		return driver.findElement(passWord);
	}
	
	public WebElement loginBtn()
	{
		return driver.findElement(loginBtn);
	}
	
	public WebElement logoutLink()
	{
		return driver.findElement(logoutLink);
	}
	
}
