package com.concepts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Frames.html");

		Thread.sleep(2000);

		List<WebElement> layers = driver.findElements(By.tagName("iframe"));
		System.out.println("Total Frames: " + layers.size());

		Thread.sleep(2000);

		driver.switchTo().frame("singleframe");

		Thread.sleep(2000);

		WebElement single = driver.findElement(By.xpath("//input[@type='text']"));
		single.sendKeys("Hi Welcome to Demo Frame Page");
		System.out.println(single.getAttribute("value"));

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\singleframe.png");
		FileUtils.copyFile(source, destination);

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();

		WebElement outer = driver.findElement(By.cssSelector("iframe[src*='MultipleFrames.html']"));
		driver.switchTo().frame(outer);

		WebElement inner = driver.findElement(By.cssSelector("iframe[src*='SingleFrame.html']"));
		driver.switchTo().frame(inner);
		Thread.sleep(2000);
		WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
		text.sendKeys("Thank You for Visit");
		System.out.println(text.getAttribute("value"));

		Thread.sleep(2000);
		TakesScreenshot tsss = (TakesScreenshot) driver;
		File sourcefile = tsss.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Multiframe.png");
		FileUtils.copyFile(sourcefile, destinationfile);

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[1]")).click();

		driver.close();
	}

}
