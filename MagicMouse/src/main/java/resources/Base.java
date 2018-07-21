package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

//Test base for all test cases, e.g.: initiate drivers for different browsers, set up global timeouts, etc.
public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public WebDriver initializeDriver() throws IOException
	{
		//Data driven: set up config.properties file and get data from it without hard coding
		prop = new Properties();
		FileInputStream config = new FileInputStream("C:\\Users\\Stewart\\eclipse-workspace\\MagicMouse\\src\\main\\java\\resources\\config.properties");
		prop.load(config);
		String browserType = prop.getProperty("browser");
		System.out.println("I am going to run test cases with: "+browserType);
			
		//Read browser type from config.properties
		if(browserType.equals("chrome"))
		{
			//Initialize Chrome driver and execute with it
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stewart\\eclipse-workspace\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserType.equals("firefox"))
		{
			//Initialize Firefox driver and execute with it
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Stewart\\eclipse-workspace\\driver\\geckodriver.exe");
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setAcceptUntrustedCertificates(true);
			ffProfile.setAssumeUntrustedCertificateIssuer(false);
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			//Initialize IE driver and execute with it
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Stewart\\eclipse-workspace\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//Set timeouts threshold globally
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Return driver object to that test cases can use it
		return driver;
				
	}
	
	public void getScreenShot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Stewart\\eclipse-workspace\\screenshot//"+result+"screenshot.png"));
	}
	
	
}
