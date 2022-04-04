package com.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Handling {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
	WebElement	mobiles=driver.findElement(By.xpath("//a[text()='Mobiles']"));
	
	Actions a=new Actions(driver);
	Thread.sleep(2000);
	a.contextClick(mobiles).perform();
	
	Robot r=new Robot();
	Thread.sleep(2000);
	
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(3000);
WebElement	deals=driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
	a.contextClick(deals).perform();
	
Thread.sleep(2000);
	
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Set<String> windowHandles= driver.getWindowHandles();
	
	for (String id: windowHandles) {
		System.out.println(driver.switchTo().window(id).getTitle());
	}
	
	String mobile="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
	
	for (String id1 : windowHandles) {
		
		if(driver.switchTo().window(id1).getTitle().equals(mobile)){
			break;
		}

	}
	Thread.sleep(5000);
WebElement	laptop=driver.findElement(By.xpath("//span[contains(text(),'Laptops')]"));
	
	a.contextClick(laptop).perform();
	
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	
	
	}

}
