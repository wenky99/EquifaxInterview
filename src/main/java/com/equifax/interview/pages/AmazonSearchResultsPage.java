package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchResultsPage {

	private String searchResults = "//*[@class='s-main-slot s-result-list s-search-results sg-row']";
	private String searchedItemPaperBackPriceWhole = "//*[@class='a-price-whole'])[1]";
	private String searchedItemPaperBankPriceDecimal = "//*[@class='a-price-whole'])[1]/following-sibling::span";
	private int sponseredAdsAtTop = 3;
	
	//By priceOfFirstSearchItem = By.xpath("("+searchResults + "/div[4]" + searchedItemPaperBackPrice);
	By wholePriceOfSelectedItem;
	By decimalPriceOfSelectedItem;
	By clickSelectedItem;

	

	private void buildRunTimeXpathForSelectedItemPrice(int itemNo) {
		int itemNoIndex = itemNo + sponseredAdsAtTop;
		wholePriceOfSelectedItem = By.xpath("("+searchResults + "/div[" + itemNoIndex + "]" + searchedItemPaperBackPriceWhole);
		decimalPriceOfSelectedItem = By.xpath("("+searchResults+ "/div[" + itemNoIndex + "]" + searchedItemPaperBankPriceDecimal);
	}
	
	private void buildRunTimeXpathForSelectedItem(int itemNo) {
		int itemNoIndex = itemNo + sponseredAdsAtTop;
		clickSelectedItem = By.xpath(searchResults + "/div[" + itemNoIndex + "]//*[@class='s-image']");
	}

	public String getSelectedItemsPrice(WebDriver driver, int itemNo) {
		try {
			buildRunTimeXpathForSelectedItemPrice(itemNo);
			String selectedItemPrice = "$"+driver.findElement(wholePriceOfSelectedItem).getText()+"."+driver.findElement(decimalPriceOfSelectedItem).getText();
			return selectedItemPrice;

		} catch (Exception e) {
			System.out.println("Getting exception at getFirstItemsPrice");
			return "fail";
		}
	}
	
	public boolean clickSelectedItem(WebDriver driver, int itemNo) {
		try {
			buildRunTimeXpathForSelectedItem(itemNo);
			driver.findElement(clickSelectedItem).click();
			driver.getTitle();
			return true;
		}catch(Exception e) {
			System.out.println("Getting exception at clickSelectedItem");
			return false;
		}
	}
	
	

}
