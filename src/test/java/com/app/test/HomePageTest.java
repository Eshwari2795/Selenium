package com.app.test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.HomePageObjects;
import com.app.pages.base;

public class HomePageTest {

	
	HomePageObjects homePage;
	base bp;

	public HomePageTest() {
		homePage = new HomePageObjects();
		bp = new base();
	}

	@Test(priority=1)
	public void verifyTabs() {
		Assert.assertTrue(homePage.elementFound(homePage.getWomenTitle()));

		Assert.assertTrue(homePage.elementFound(homePage.getDressesTitle()));

		Assert.assertTrue(homePage.elementFound(homePage.getTshirtsTitle()));

	}

	@Test(priority=2)
	public void verifySubscription() {
		int value = new Random().nextInt(7000);
		String email = "eshwari" + value + "@gmail.com";
		bp.setText(homePage.getSubscriptionMessage(), email);
		homePage.clickSubmit();
		Assert.assertEquals(bp.getTxtAttribute(homePage.getSubscriptionMessage()),
				"You have successfully subscribed to this newsletter."/*"Newsletter : This email address is already registered."*/);

	}
	


	@Test(priority=3)
	public void verifyDisplay() {
		homePage.clickWomen();
		Assert.assertTrue(homePage.verifyTitles("Women"));
		homePage.navigateBack();

		homePage.clickDresses();
		Assert.assertTrue(homePage.verifyTitles("Dresses"));
		homePage.navigateBack();

		homePage.clickTshirts();
		Assert.assertTrue(homePage.verifyTitles("T-shirts"));
		homePage.navigateBack();

	}
	
	@Test(priority=4)
	public void VerifyAddToCartButton(){
		List<WebElement>products= homePage.getProduct();
		for(WebElement prod: products){
			homePage.mouseHovering(prod);
			Assert.assertTrue(homePage.VerifyAddToCart(prod), "Failed: Add to cart button is not present for the product" + homePage.getProductName(prod));
		}
	}
	

}
