package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesObjects extends base {

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement productHeader;

	@FindBys(@FindBy(xpath = "//ul[@class='product_list grid row']/li"))
	private List<WebElement> lstProducts;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]")
	private WebElement firstProduct;

	@FindBy(xpath = "//div[@class='right-block']//*[@data-id-product='3']")
	private WebElement AddToCart;

	@FindBy(xpath = "//*[@id='layer_cart']//div[1]/h2")
	private WebElement SuccessfullyAdded;

	@FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//*[@class='nomargin hiddable col-lg-6']")
	private WebElement sizeS;

	@FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//*[@class='nomargin hiddable col-lg-6']")
	private WebElement sizeM;

	@FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//*[@class='nomargin hiddable col-lg-6']")
	private WebElement sizeL;

	@FindBy(xpath = "//*[@id='selectProductSort']")
	private WebElement dropDownSort;

	@FindBys(@FindBy(xpath = "//*[@class='right-block']//span[@class='price product-price']"))
	private List<WebElement> lstProductPrices;
	
	@FindBys(@FindBy(xpath = "//*[@class='right-block']//*[@itemprop='name']"))
	private List<WebElement> lstProductNames;
	
	@FindBy(xpath = "//*[@id='Layered_ajax_loader']/p/img")
	private WebElement iconLoad;

	public DressesObjects() {
		PageFactory.initElements(driver, this);
	}

	public int getProductCountFromHeaderText() {

		/*
		 * One method -> not efficient bcoz storing more variables String txt=
		 * productHeader.getText(); //number of products showing in
		 * header(i.e.,There are 5 products) String arr[] = txt.split(" ");
		 * //splitting the header text with space (to get the required number)
		 * String number = arr[2]; //splitted number stored in 2nd arrayindex
		 * int value = Integer.parseInt(number); //converting the string to
		 * array return value; }
		 */

		return Integer.parseInt(productHeader.getText().split(" ")[2]);
	}

	public int getProductCount() {
		return lstProducts.size();
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	public void clickFirstProduct() {
		firstProduct.click();
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public void clickAddToCart() {
		AddToCart.click();
	}

	public WebElement getMessageAfterAddedToCart() {
		isElementVisible(SuccessfullyAdded);
		return SuccessfullyAdded;
	}

	public String SuccessfullyAddedMsg() {
		return SuccessfullyAdded.getText();
	}

	public WebElement getSmallSize() {
		return sizeS;
	}

	public WebElement getMediumSize() {
		return sizeM;
	}

	public WebElement getLargeSize() {
		return sizeL;
	}

	public String selectSortOption(String input) {
		return selectFromDropDown(dropDownSort, input);
	}

	public List<Double> getProductPrices() {
		List<Double> lst = new ArrayList<Double>();
		isElementVisible(iconLoad);
		isElementInVisible(iconLoad);

		for (WebElement e : lstProductPrices) {
			String txt = e.getText();
			txt = txt.replace("$", " ").trim();
			Double b = Double.parseDouble(txt);
			lst.add(b);

			// lst.add(Double.parseDouble(e.getText().replace("$", " ")));
		}
		return lst;
	}

	public List<String> getProductNames() {
		ArrayList<String> productNames = new ArrayList<String>();
		isElementVisible(iconLoad);
		isElementInVisible(iconLoad);
		for (WebElement e : lstProductNames) {
			String txt = e.getText();
			productNames.add(txt.trim());

		}
		return productNames;
	}

}
