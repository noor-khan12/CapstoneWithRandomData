package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger; // create an object of Logger class from apache
	private String propertyPath = ".\\src\\test\\resources\\input\\property.properties";
	private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";
	// we need a constructor for this class to be invoked to read data from the two
	// property files . it should be invoked before every method and variable /*

	public Base() {
		// we use BufferReader to read from property files
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyPath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add an object of the FileReader class
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger = logger.getLogger("logger_File"); 
		PropertyConfigurator.configure(log4jPath);
		
	
		
	}

	// we need to get the values now ... getters methods
	// this method should return Url value from properties file
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}

	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}

	public static void openBrowswer() {
		driver.get(getUrl());
		// this method will open browser and send url from property file
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	public static void browserType() {
		// will determine which browser we will use
		// we will use switch keyword
		String browserName = getBrowser();
		switch (browserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies(); // delete all stored cookies of browswer
	}

}
