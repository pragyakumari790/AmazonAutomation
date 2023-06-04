package com.store.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.store.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//private static final TimeUnit SECONDS = null;
	ReadConfig rf = new ReadConfig();
	String url=rf.getBaseURl();
	String browser =rf.getBrowser();
	String usr=rf.getuid();
	String passwd =rf.getPwd();
	public static WebDriver driver;
	public static Logger logg;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() {
		//log files
				logg = LogManager.getLogger("Amazon");
		switch(browser.toLowerCase()) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			logg.info("url Open");
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			logg.info("url Open");
			break;
		case "msedge" :
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver();
			driver.get(url);
			logg.info("url Open");
			break;
		default :
			driver =null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@AfterClass
	
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
	
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
}
