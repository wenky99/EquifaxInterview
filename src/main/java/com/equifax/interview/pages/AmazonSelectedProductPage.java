package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSelectedProductPage {

	By selectedProductPrice = By.id("newBuyBoxPrice");
	By addToCart = By.id("add-to-cart-button");
	//By cartIcon = By.id("nav-cart-count-container"); nav-cart
	//By cartIcon = By.xpath("//*[@id='nav-cart-count-container']/span[1]");
	By cartIcon = By.xpath("//*[@id='nav-cart']");

	public boolean priceMatch(WebDriver driver, String expectedPrice) {
		try {
			String actualPrice = driver.findElement(selectedProductPrice).getText();
			if (!actualPrice.equals(expectedPrice)) {
				System.out.println("Actual Price= " + actualPrice + " is not same as Expected price =" + expectedPrice);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addToCart(WebDriver driver) {
		try {
			driver.findElement(addToCart).click();
			System.out.println("Item added to cart succesfully");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
