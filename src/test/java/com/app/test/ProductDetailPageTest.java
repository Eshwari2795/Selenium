package com.app.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pages.DressesObjects;
import com.app.pages.HomePageObjects;
import com.app.pages.ProductDetailPageObjects;
import com.app.pages.base;

public class ProductDetailPageTest {

	ProductDetailPageObjects pdp;
	base bp;
	DressesObjects dp;

	public ProductDetailPageTest() {
		pdp = new ProductDetailPageObjects();
		bp = new base();
		dp = new DressesObjects();
	}

	@BeforeMethod
	public void BeforeValidation() {
		pdp.mouseHovering(pdp.getFirstProduct()).click();
		pdp.clickMore();

	}

	@Test(priority = 2)
	public void verifyTwitterFshareIcons() {

		/*
		 * pdp.mouseHovering(pdp.getFirstProduct()).click(); pdp.clickMore();
		 */

		Assert.assertTrue(bp.elementFound(pdp.getTwitterIcon()));
		Assert.assertTrue(bp.elementFound(pdp.getFShareIcon()));

		// bp.navigateBack();

		/*
		 * bp.SwitchtoDefaultFrame(); pdp.exitFrame().click();
		 * //dp.mouseHovering(pdp.exitFrame()); //pdp.clickClose();
		 */

	}

	@Test
	public void validateDescription() {

		/*
		 * pdp.mouseHovering(pdp.getFirstProduct()).click(); pdp.clickMore();
		 */

		Assert.assertTrue(bp.elementFound(pdp.getDescription()));

	}

	@AfterMethod
	public void AfterValidation() {
		bp.navigateBack();
	}

	@AfterClass
	public void quit() {
		bp.quitDriver();
	}
}
