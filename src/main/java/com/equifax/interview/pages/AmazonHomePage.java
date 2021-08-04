package com.equifax.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {

	By amazonSearchBox = By.id("twotabsearchtextbox");
	By amazoSearchIcon = By.xpath("//*[@id=\'nav-search-submit-button\']");
	private String PageTitle = "Amazon.com. Spend less. Smile more.";
	
	public boolean searchForGivenItem(WebDriver driver, String ItemName) {
		try {
			
			driver.switchTo().defaultContent();
			if(!driver.getTitle().equals(PageTitle)){
				System.out.println("Expected title ="+PageTitle+ " and actual title ="+driver.getTitle()+" are not matching");
				return false;
			}
			driver.findElement(amazonSearchBox).sendKeys(ItemName);
			driver.findElement(amazoSearchIcon).click();
			return true;
		}catch(Exception e) {
			System.out.println("Getting exception at searchForGivenItem");
			return false;
		}
	}
	

}
