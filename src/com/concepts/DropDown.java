package com.concepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		WebElement button = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		button.click();
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.id("day"));
		Select s = new Select(day);
		s.selectByIndex(22);

		Thread.sleep(2000);

		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select b = new Select(month);
		b.selectByValue("8");

		Thread.sleep(3000);

		WebElement year = driver.findElement(By.id("year"));
		Select c = new Select(year);
		c.selectByVisibleText("1996");

		//Thread.sleep(2000);

		boolean d = day.isSelected();
		System.out.println(d);

		Thread.sleep(2000);

		
		  TakesScreenshot ts = (TakesScreenshot) driver; 
		  File source = ts.getScreenshotAs(OutputType.FILE); File destination = new File(
		  "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\dropdown.png"
		  ); FileUtils.copyFile(source, destination);
		 

		driver.close();

	}
}
