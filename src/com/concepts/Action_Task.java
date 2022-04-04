package com.concepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Task {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");//to enter into url
		driver.manage().window().maximize();//to maximize the webpage

		Actions a = new Actions(driver);//action class for mouse actions
		Robot r = new Robot();//robot class for keyboard actions
		Thread.sleep(5000);
		WebElement deal = driver.findElement(By.xpath("//a[contains(text(),'Today')]  "));//to find the web element
		a.contextClick(deal).perform();//to right click the webElement
		
		//looping is used to enter into 2nd option
		for (int i = 0; i <= 1; i++) {
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_DOWN);//to press the down arrow
			r.keyRelease(KeyEvent.VK_DOWN);// to release to down arrow
 
		}

		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);// to press enter button
		r.keyRelease(KeyEvent.VK_ENTER);// to release enter button

		Thread.sleep(5000);
		
// for taking screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Today's_Deal.png");
		FileUtils.copyFile(source, destination);

	}

}
