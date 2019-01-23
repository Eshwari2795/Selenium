package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends base {

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement Women;

	@FindBy(xpath = "//*[contains(@class, 'menu-content')]/li[2]/a[@title='Dresses']")
	private WebElement Dresses;

	@FindBy(xpath = "//*[contains(@class, 'menu-content')]/li[3]/a[@title='T-shirts']")
	private WebElement tShirts;
	
	@FindBy(id = "newsletter-input")
	private WebElement Subscription;
	
	@FindBy(name="submitNewsletter")
	private WebElement Submit;
	
	@FindBys(@FindBy(xpath ="//ul[@id='homefeatured']/li"))
    private List<WebElement> listProducts;
 	
	//@FindBy(xpath=".//*[text()='Dresses'])[2]")
	//private WebElement tabDresses;
    

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getWomenTitle() {
		return Women;
	}

	public void clickWomen() {
		Women.click();
	}

	public WebElement getDressesTitle() {
		return Dresses;
	}

	public void clickDresses(){
		Dresses.click();
	}
	public WebElement getTshirtsTitle() {
		return tShirts;
	}
	
	public void clickTshirts(){
		tShirts.click();
	}

	public WebElement getSubscriptionMessage() {
		return Subscription;
	}
	
	public void clickSubmit(){
		Submit.click();
	}
	public List<WebElement> getProduct(){
		return listProducts;
	}
	
	public boolean VerifyAddToCart(WebElement parent){
		return elementFound(parent.findElement(By.xpath(".//*[text()='Add to cart']")));
	}

	public String getProductName(WebElement parent){
		return parent.findElement(By.xpath (".//*[@class='product-name']")).getText();
		
	}
}
