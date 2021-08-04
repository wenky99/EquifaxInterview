package com.equifax.interview;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.equifax.driver.BrowserDriver;
import com.equifax.interview.pages.AmazonCartPage;
import com.equifax.interview.pages.AmazonHomePage;
import com.equifax.interview.pages.AmazonSearchResultsPage;
import com.equifax.interview.pages.AmazonSelectedProductPage;

public class AmazonPriceCheckTest {

	private String url = "https://amazon.com";
	private String browser = "chrome";
	private String productNameToSearch = "qa testing for beginners";
	private int selectItemNoInTheList = 1;
	private String priceOfTheItem;

	@Test
	public void checkoutAmazonItem() {
		WebDriver driver = BrowserDriver.getDriver(browser);
		driver.navigate().to(url);  
		System.out.println(driver.getTitle());
		
		AmazonHomePage homePage = new AmazonHomePage();
		homePage.searchForGivenItem(driver, productNameToSearch);
		
		AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage();
		priceOfTheItem = searchResultsPage.getSelectedItemsPrice(driver, selectItemNoInTheList);
		searchResultsPage.clickSelectedItem(driver, selectItemNoInTheList);
		
		AmazonSelectedProductPage productPage = new AmazonSelectedProductPage();
		productPage.priceMatch(driver, priceOfTheItem);
		productPage.addToCart(driver);
		
		
		AmazonCartPage cartPage = new AmazonCartPage();
		cartPage.subTotalPriceCheck(driver, priceOfTheItem);
		cartPage.proceedToCheckout(driver);
	}

}
