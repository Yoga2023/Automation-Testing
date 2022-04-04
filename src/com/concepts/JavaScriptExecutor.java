package com.concepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,5000)", "");// to scroll down through y axis

		/*
		 * TakesScreenshot pixels = (TakesScreenshot) driver; File source
		 * =pixels.getScreenshotAs(OutputType.FILE); File destination = new File(
		 * "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Pixels.png"
		 * ); FileUtils.copyFile(source, destination);
		 */

		// Thread.sleep(5000);

		WebElement mobile = driver.findElement(By.xpath("//img[@alt='Mobiles']"));

		js.executeScript("arguments[0].scrollIntoView();", mobile);// to scroll to particular webElement

		/*
		 * TakesScreenshot atmobile = (TakesScreenshot) driver; File source1 =
		 * atmobile.getScreenshotAs(OutputType.FILE); File destination1 = new File(
		 * "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\mobile.png"
		 * ); FileUtils.copyFile(source1, destination1);
		 */

		// Thread.sleep(2000);
		// js.executeScript("window.scrollBy(0,-2000)", "");// to scroll up through
		// y-axis

		Thread.sleep(2000);
		// js.executeScript("window.scrollBy(0,0)", "");//to scroll to start of the page
		js.executeScript("Window.scrollBy(0,0),", "");// to scroll to start of the page
		// syntax as per the Notepad.

		/*
		 * TakesScreenshot atStart = (TakesScreenshot) driver; File source2
		 * =atStart.getScreenshotAs(OutputType.FILE); File destination2 = new File(
		 * "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\start.png"
		 * ); FileUtils.copyFile(source2, destination2);
		 */

		Thread.sleep(2000);
		driver.close();

	}

}
