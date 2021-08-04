package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonCartPage {

	// Page behavior upon clicking on add to cart changed so commenting below
	// locator but just keeping it here for now for record keeping purposes
	// By subTotalPrice = By.xpath("//*[@id='sc-subtotal-amount-buybox']/span");

	By subTotalPrice = By.xpath("(//*[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]");
	By proceedToCheckout = By.xpath("(//*[contains(text(),'Proceed ')])[1]");
	private String actualPrice = null;

	public void subTotalPriceCheck(WebDriver driver, String expectedPrice) {
		try {
			actualPrice = driver.findElement(subTotalPrice).getText();
			Assert.assertEquals(actualPrice, expectedPrice, " Price in Amazon cart t page=" + actualPrice
					+ " and price in Amazon search results page=" + expectedPrice + " is not same");
			Reporter.log("Price in Amazon cart page and search results page is matched");
		} catch (Exception e) {
			Reporter.log("Exception at subTotalPriceCheck");
		}
	}

	public void proceedToCheckout(WebDriver driver) {
		try {
			driver.findElement(proceedToCheckout).click();
			Reporter.log("Proceed to checkout clicked");
		} catch (Exception e) {
			Reporter.log("Exception at subTotalPriceCheck");
		}
	}

}
