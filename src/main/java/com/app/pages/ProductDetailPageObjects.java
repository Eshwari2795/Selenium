package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/*import com.app.test.ArrayList;
import com.app.test.List;*/

public class ProductDetailPageObjects extends base {

	// @FindBys(@FindBy(xpath = "//*[@class='replace-2x img-responsive']"))
	// private List<WebElement> Product;

	@FindBy(xpath = "//ul[@id='homefeatured']/li[1]")
	private WebElement getFirstProd;

	/*
	 * @FindBy(xpath =
	 * "//ul[@id='homefeatured']//*[@title='Faded Short Sleeve T-shirts']")
	 * private WebElement productClick;
	 */

	@FindBy(xpath = "//*[@class='icon-twitter']")
	private WebElement twitter;

	@FindBy(xpath = "//*[contains(@class, 'btn-facebook')]")
	private WebElement fShare;

	@FindBy(xpath = "//*[@id='short_description_content']")
	private WebElement description;

	@FindBy(xpath = "//*[@class='fancybox-iframe']")
	private WebElement switchToframe;

	@FindBy(xpath = "//a[@title='Close']")
	private WebElement closeFrame;

	@FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[2]/span")
	private WebElement MoreButton;

	@FindBy(xpath = "//*[@id='bigpic']")
	private WebElement Popupclick;

	public ProductDetailPageObjects() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public List<String> getProducts() { ArrayList<String>list = new
	 * ArrayList<String>(); for (WebElement element : Product) {
	 * list.add(element.getText()); } return list; }
	 */

	public WebElement getFirstProduct() {
		return getFirstProd;
	}

	public void clickProduct() {
		getFirstProd.click();
	}

	public WebElement getMoreButton() {
		return MoreButton;
	}

	public void clickMore() {
		MoreButton.click();
	}

	public WebElement getTwitterIcon() {
		return twitter;
	}

	public WebElement getFShareIcon() {
		return fShare;
	}

	public WebElement getSwitchToFrame() {
		return switchToframe;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement exitFrame() {
		return closeFrame;

	}

	public void clickClose() {
		closeFrame.click();
	}

	public void clickpoupup() {
		Popupclick.click();
	}
}
