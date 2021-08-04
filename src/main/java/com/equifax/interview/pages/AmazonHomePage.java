package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonHomePage {

	By amazonSearchBox = By.id("twotabsearchtextbox");
	By amazoSearchIcon = By.xpath("//*[@id=\'nav-search-submit-button\']");
	private String PageTitle = "Amazon.com. Spend less. Smile more.";
	
	public void searchForGivenItem(WebDriver driver, String ItemName) {
		try {
			
			driver.switchTo().defaultContent();
			driver.getTitle();
			driver.findElement(amazonSearchBox).sendKeys(ItemName);
			Reporter.log("Entered item name");
			driver.findElement(amazoSearchIcon).click();
			Reporter.log("Clicked amazon search box");
		}catch(Exception e) {
			Reporter.log("Getting exception at searchForGivenItem");
		}
	}
	

}
