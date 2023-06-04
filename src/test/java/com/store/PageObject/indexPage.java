package com.store.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.store.TestCases.BaseClass;

public class indexPage extends BaseClass{
	
	
	  public indexPage(WebDriver rdriver) 
	  { 
		  driver = rdriver; 
		  }
	 
	
	//identify Elements id='nav-link-accountList-nav-line-1'
	//@FindBy()
	String id ="[id ='twotabsearchtextbox']";
	String link ="[id = 'nav-link-accountList-nav-line-1']";
	String uid = "[id = 'ap_email']";
	String conti = "[id ='continue']";
	String Pwd = "[type = 'password']";
	String Sign ="[id = 'signInSubmit']";
	String Usernane ="[id='nav-link-accountList-nav-line-1']";
	//class='navFooterBackToTopText'
	String BtTop = "[class='navFooterBackToTopText']";
	
	public String  SignIn(String usid, String pswd) {
		driver.findElement(By.cssSelector(link)).click();
		driver.findElement(By.cssSelector(uid)).sendKeys(usid);;
		driver.findElement(By.cssSelector(conti)).click();
		driver.findElement(By.cssSelector(Pwd)).sendKeys(pswd);;
		driver.findElement(By.cssSelector(Sign)).click();
		WebElement e = driver.findElement(By.cssSelector(Usernane));
		String el = e.getText();
		return el;
		
	}
	public void Search() {
		WebElement searchItem = driver.findElement(By.cssSelector(id));
		searchItem.sendKeys("iphone 11");
		searchItem.sendKeys(Keys.ENTER);
	}
	public void Scroll() {
		WebElement BTtop = driver.findElement(By.cssSelector(BtTop));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", BtTop);
		

	}

}
