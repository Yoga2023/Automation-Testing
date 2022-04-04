package com.concepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Task {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='analystic']")).click();
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'confirm')]")).click();		
		driver.switchTo().alert().dismiss();

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
		driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();

		Thread.sleep(2000);
		
		Alert a = driver.switchTo().alert();
		a.sendKeys("Yoga");
		a.accept();
		Thread.sleep(2000);
		WebElement we = driver.findElement(By.id("demo1"));
		String b = we.getText();
		System.out.println(b);

		Thread.sleep(1000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Alert.png");
		FileUtils.copyFile(source, destination);

		Thread.sleep(2000);
		driver.close();
	}

}
