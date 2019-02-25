package com.primusbank.library;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.primusbank.constants.PrimusBankConstants;

public class PrimusBankHomePAge extends PrimusBankConstants {
	
	public boolean adminLogin(String uid,String pwd){
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@src='images/login.jpg']")).submit();
		String actval,expval;
		actval=driver.getCurrentUrl();
		expval="adminflow";
		if(expval.toLowerCase().contains(actval.toLowerCase())){
			return true;
			
		}
		else{
			return false;
		}
		
		
	}
	public boolean bankerLogin(String brname,String uid,String pwd)
	{
		String expurl,acturl;
		expurl="Bankers_flow";
		
		Select blist=new Select(driver.findElement(By.id("drlist")));
		blist.selectByVisibleText(brname);
		
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		/*Alert alt=driver.switchTo().alert();
		alt.accept();*/
		acturl=driver.getCurrentUrl();
		if (acturl.toLowerCase().contains(expurl.toLowerCase())) 
		{
			return true;
		} else 
		{
			return false;
		}
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
