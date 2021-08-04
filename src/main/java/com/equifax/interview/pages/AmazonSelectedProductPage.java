package com.equifax.interview.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonSelectedProductPage {

	By selectedProductPrice = By.id("newBuyBoxPrice");
	By addToCart = By.id("add-to-cart-button");
	//By cartIcon = By.id("nav-cart-count-container"); nav-cart
	//By cartIcon = By.xpath("//*[@id='nav-cart-count-container']/span[1]");
	By cartIcon = By.xpath("//*[@id='nav-cart']");

	public void priceMatch(WebDriver driver, String expectedPrice) {
		try {
			String actualPrice = driver.findElement(selectedProductPrice).getText();
			Assert.assertEquals(actualPrice, expectedPrice," Price in Amazon product page="+actualPrice+" and price in Amazon search results page="+expectedPrice+" is not same");
			
		} catch (Exception e) {
			Reporter.log("Exception at priceMatch");
		}
	}

	public void addToCart(WebDriver driver) {
		try {
			driver.findElement(addToCart).click();
			Reporter.log("Element add to cart is clicked");
		} catch (Exception e) {
			Reporter.log("Exception at addToCart");
		}
	}
}
