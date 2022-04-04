package com.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Day2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		
		Thread.sleep(1000);
		WebElement we = driver.findElement(By.name("username"));
		we.sendKeys("Yoga1234@gmail.com");
		boolean a=we.isDisplayed();
		System.out.println(a);
		String c=we.getAttribute("value");
		System.out.println(c);
		Thread.sleep(500);
		we.clear(); 
		
		Thread.sleep(1000);
		WebElement we1 = driver.findElement(By.name("password"));
		we1.sendKeys("12345ypQ");
		boolean b= we1.isEnabled();
		System.out.println(b);
		String d=we.getAttribute("class");
		System.out.println(d);
		
		
		WebElement we2 = driver.findElement(By.className("DhRcB"));
		we2.click();
		
		driver.close();
		

	}

}
