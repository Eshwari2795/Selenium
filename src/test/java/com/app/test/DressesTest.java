package com.app.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pages.DressesObjects;
import com.app.pages.HomePageObjects;
import com.app.pages.ProductDetailPageObjects;
import com.app.pages.base;

public class DressesTest {

	HomePageObjects homePage;
	DressesObjects dp;
	base bp;
	ProductDetailPageObjects pdp;

	public DressesTest() {
		dp = new DressesObjects();
		bp = new base();
		homePage = new HomePageObjects();
	}

	@BeforeMethod
	public void beforeTest() {
		homePage.clickDresses();
	}

	@Test(priority = 3)
	public void VerifyProductCount() {
		// homePage.clickDresses();

		Assert.assertEquals(dp.getProductCountFromHeaderText(), dp.getProductCount(), "Count Mismatched");
	}

	@Test(priority = 5)
	public void VerifyAddToCart() {
		bp.mouseHovering(dp.getFirstProduct());
		dp.clickAddToCart();

		Assert.assertTrue(homePage.elementFound(dp.getMessageAfterAddedToCart()));
	}

	@Test(priority = 4)
	public void verifySize() {
		// homePage.clickDresses();
		/*
		 * dp.getFirstProduct().click();
		 * bp.isElementVisible(pdp.getSwitchToFrame());
		 */

		Assert.assertTrue(dp.elementFound(dp.getSmallSize()));
		Assert.assertTrue(dp.elementFound(dp.getMediumSize()));
		Assert.assertTrue(dp.elementFound(dp.getLargeSize()));

	}

	@Test(priority = 2)
	public void verifyPriceInAscendingOrder() {
		// homePage.clickDresses();
		dp.selectSortOption("price:asc");
		List<Double> prices = dp.getProductPrices();

		for (int index = 0; index < prices.size() - 1; index++) {
			System.out.println("Price " + prices.get(index));
			Assert.assertTrue(prices.get(index) < prices.get(index + 1),
					"Failed price not in ascending order at index" + index);
		}

	}

	@Test(priority = 1)
	public void VerifyProductInAscendingOrder() {
		// homePage.clickDresses();
		dp.selectSortOption("name:asc");
		List<String> names = dp.getProductNames();
		for (int i = 0; i < names.size() - 1; i++) {
			System.out.println(names.get(i).compareTo(names.get(i + 1)));
			Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) <= 0,
					"Not in ascending order and the product name is" + names.get(i));
		}
	}

	@AfterMethod
	public void afterMethod() {
		bp.navigateBack();

	}

}
