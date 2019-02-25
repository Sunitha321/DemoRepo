package com.primusbank.constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class PrimusBankConstants {
	
	public static WebDriver driver;
	public static String url="http://primusbank.qedgetech.com";
	public static String key="webdriver.chrome.driver";
	public static String value="D:\\qedge\\selenium_Suresh_sir_qedge\\chromedriver.exe";
	@BeforeMethod
	public static void launchApp(){
		System.setProperty(key, value);
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	@AfterMethod
	public static void closeApp(){
		driver.close();
	}
	
	

}
