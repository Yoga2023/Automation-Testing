package com.web.task;

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

public class MiniProject_1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Sele12345@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#SubmitCreate")).click();

		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='radio'])[1]")).click();

		Thread.sleep(5000);

		driver.findElement(By.cssSelector("input#customer_firstname")).sendKeys("Yoganandhababu");

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#customer_lastname")).sendKeys("Kumaravel");

		Thread.sleep(2000);
		driver.findElement(By.id("passwd")).sendKeys("123asd@Q");

		Thread.sleep(2000);
		WebElement day = driver.findElement(By.id("days"));
		Select s = new Select(day);
		s.selectByValue("23");

		Thread.sleep(2000);
		WebElement month = driver.findElement(By.id("months"));
		Select s1 = new Select(month);
		s1.selectByValue("8");

		Thread.sleep(2000);
		WebElement year = driver.findElement(By.id("years"));
		Select s2 = new Select(year);
		s2.selectByValue("1996");
		Thread.sleep(2000);
		driver.findElement(By.id("address1")).sendKeys("Avadi");

		driver.findElement(By.name("city")).sendKeys("chennai");
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.id("id_state"));

		Select s3 = new Select(state);
		s3.selectByVisibleText("California");
		Thread.sleep(2000);
		driver.findElement(By.id("postcode")).sendKeys("00000");
		driver.findElement(By.cssSelector("input#phone_mobile")).sendKeys("7358333000");

		driver.findElement(By.cssSelector("input#alias")).sendKeys("Porur");
		Thread.sleep(2000);
		TakesScreenshot before= (TakesScreenshot)driver;
		File source=before.getScreenshotAs(OutputType.FILE);
		File destination= new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Before_Register.png");
		FileUtils.copyFile(source, destination);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		Thread.sleep(2000);
		TakesScreenshot after= (TakesScreenshot)driver;
		File source1=after.getScreenshotAs(OutputType.FILE);
		File destination1= new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\After_Register.png");
		FileUtils.copyFile(source1, destination1);
		
		Thread.sleep(2000);
		driver.close();
	}

}
