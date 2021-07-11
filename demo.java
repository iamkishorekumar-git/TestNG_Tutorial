package com.demo;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {

	String path = "\\src\\resource\\driver\\chromedriver.exe";

	WebDriver driver;

	@BeforeSuite( groups = {"Regression"})
	public void openDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + path);
		driver = new ChromeDriver();

	}

	@Test(priority = 1, groups = {"Regression"})
	public void openURL() {
		driver.get("https://amazon.in");
	}

	@Test(priority = 2, groups = {"Regression"})
	public void maxURL() {
		driver.manage().window().maximize();
	}

	@Test(priority = 3, groups = {"Regression"})
	public void titleURL() {
		String title = driver.getTitle();
		Reporter.log(title);
	}

	@Test(priority = 4, groups ={"Regression"})
	public void search() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbo, x")).sendKeys("Mobile");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

//	@Test(priority = 5,groups = {"Regression"})
//	public void getMobile() {
//		driver.findElement(By.xpath(
//				"//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span"))
//				.click();
//	}
//
//	@Test(priority = 6, groups = {"Regression"})
//
//	public void addTocard() {
//		Set<String> allWin = driver.getWindowHandles();
//
//		// System.out.println(allWin.size());
//		for (String curWin : allWin) {
//			driver.switchTo().window(curWin);
//		}
//		driver.findElement(By.id("add-to-cart-button")).click();
//	}

	@Test(priority = 7,enabled = false)
	public void checkPrice() throws InterruptedException {
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//*[@id=\"attach-accessory-cart-subtotal\"]")).getText();
		
		try
		{		
			assertEquals(price, "₹ 31,998.00");
			System.out.println("Result matched");
		}
		catch(AssertionError  e)
		{
			System.out.println("Error is "+e);
			System.out.println("Result not matched ");
			
		}
	}

}

// JVM 

// class can be accessed only through the object 
