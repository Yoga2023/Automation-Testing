package com.concepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Handling {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		Thread.sleep(3000);
	WebElement	dresses=driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
	a.contextClick(dresses).perform();
	Robot r=new Robot();
	
	for(int i=0;i<=1;i++) {
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	Thread.sleep(2000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(10000);
	WebElement tShirts=driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
	Thread.sleep(2000);
	a.contextClick(tShirts).perform();
	
	for(int i=0;i<=1;i++) {
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	Thread.sleep(2000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(5000);
	Set<String> title=driver.getWindowHandles();
	for (String id : title) {
		System.out.println(driver.switchTo().window(id).getTitle());
		
	}
	Thread.sleep(2000);
	String tshirts = "T-shirts - My Store";
	//Thread.sleep(2000);
	
	for (String id1 : title) {
		if(driver.switchTo().window(id1).getTitle().equals(tshirts)) {
			break;
		}
		
	}
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@class='checkbox'])[1]")).click();
	Thread.sleep(2000);
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Windows_Handling.png");
	FileUtils.copyFile(source, destination);
	Thread.sleep(3000);
	driver.quit();
	}
	
	

}
