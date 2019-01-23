package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	/*
	 * Home Page
	 * 
	 * 1. Verify Tabs - Women, Dresses and T-shirt are displayed on Home Page.
	 * 2. Verify Corresponding page been navigated on selecting these tabs 3.
	 * 3. Verify Subscription message is displayed after entering valid e-mail in
	 * Newsletter follow up.
	 * 
	 * 

     Dresses Page

      1. Verify Size – L, M and S is displayed
      2. Verify Respective Matching result count and product count is being displayed
      3. Add first product and verify its add to cart

     Product Details Page

      1.	Verify Tweet, Share is displayed in product details page
      2.	Verify Product Description is displayed .

	 */

	public static WebDriver driver;
	public String browser = "chrome";

	public base() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ESHWARI\\Desktop\\chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.get("http://automationpractice.com/index.php");
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isElementInVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void quitDriver() {
		driver.quit();

	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public boolean verifyTitles(String tit) {
		try {
			String Titles = driver.getTitle();
			if (Titles.contains(tit)) {
				return true;
			}
		} catch (Exception e1) {
			return false;
		}
		return false;
	}
	
	public WebElement mouseHovering(WebElement element){
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		return element;

	}
	public WebElement performClick(WebElement element){
		Actions ac= new Actions (driver);
		ac.moveToElement(element).click().build().perform();
		return element;
	}
	
	public WebElement switchFrame(WebElement element){
		driver.switchTo().frame(element);
		return element;
	}
	
	public void switchToCurrentWindow(){
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(currentWindow);		
		
	}
	
	public void SwitchtoDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	}
	
 
	
	
