package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage {

	// Page behavior upon clicking on add to cart changed so commenting below locator but just keeping it here for now for record keeping purposes
	// By subTotalPrice = By.xpath("//*[@id='sc-subtotal-amount-buybox']/span");
	
	By subTotalPrice = By.xpath("(//*[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]");
	By proceedToCheckout = By.xpath("(//*[contains(text(),'Proceed ')])[1]");
	private String actualPrice = null;

	public boolean subTotalPriceCheck(WebDriver driver, String expectedPrice) {
		try {
			actualPrice = driver.findElement(subTotalPrice).getText();
			if (!actualPrice.equals(expectedPrice)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean proceedToCheckout(WebDriver driver) {
		try {
			driver.findElement(proceedToCheckout).click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
