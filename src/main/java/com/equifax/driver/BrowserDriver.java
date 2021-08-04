package com.equifax.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BrowserDriver {

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				System.out.print(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
				driver = new ChromeDriver();

			} else {
				System.out.println("Specified driver is not supported");
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			System.out.println("Getting exception when trying to intialize the driver");
			return driver;
		}
	}

	public static void closeCurrentBrowserWindow(WebDriver driver) {
		try {
			driver.close();
			Reporter.log("Current window browser is closed");
		} catch (Exception e) {
			Reporter.log("Getting exception at closeCurrentBwoserWindow");
		}
	}

}
