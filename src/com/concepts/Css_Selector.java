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

public class Css_Selector {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");

//Locate by Attribute;
		Thread.sleep(5000);
		WebElement first = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		first.sendKeys("yoga");
		String a = first.getAttribute("ng-model");
		System.out.println("Attribute name: " + a);

		// Locate by Prefix:
		Thread.sleep(2000);
		WebElement last = driver.findElement(By.cssSelector("input[ng-model^='LastName']"));
		last.sendKeys("babu");
		String b = last.getAttribute("value");
		System.out.println("Attribute name: " + b);

		// Locate by Suffix: 
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.cssSelector("input[type$='ail']"));
		email.sendKeys("Chennai@123.com");

		// Locate by substring/contains:
		Thread.sleep(2000);
		WebElement phone = driver.findElement(By.cssSelector("input[type*='tel']"));
		phone.sendKeys("985674583");

		// Locate by ID: 
		Thread.sleep(2000);
		WebElement language = driver.findElement(By.cssSelector("input#checkbox1"));
		language.click();

		// ScreenShot: 
		Thread.sleep(2000); 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Css-Selector.png");
		FileUtils.copyFile(source, destination);

		// Locate by LinkText: 
		Thread.sleep(2000);
		WebElement we =driver.findElement(By.linkText("WebTable"));
		we.click();
		driver.navigate().back();


	}

}
