package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Frames.html");

		driver.findElement(By.xpath("(//a[contains(@class,'analystic')])[1]")).click(); 

		driver.switchTo().frame("SingleFrame");
		Thread.sleep(2000);
		WebElement singleframe = driver.findElement(By.xpath("//input[@type='text']"));
		singleframe.sendKeys("Hello");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
		
		WebElement outer =driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outer);
		
	WebElement inner=	driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(inner);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("How are you");
		
		//driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//a[contains(@class,'analystic')])[1]")).click();
		}

}
