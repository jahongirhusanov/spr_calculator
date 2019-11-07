package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/jahongirhusanov/Documents/Selenium_Project/seleniumProjects/SPR/resources/data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/jahongirhusanov/Documents/Selenium_Project/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("fireFox")) {
			// code for fireFox, will add later
			// System.setProperty
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// code for IE, will add later
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("/Users/jahongirhusanov/Documents/Selenium_Project/seleniumProjects/screenShots/"+result+"screenShot.png"));
		
	}
}
