package com.practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Alert_1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement text = driver.findElement(By.id("demo"));
		System.out.println(text.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		WebElement text1 = driver.findElement(By.id("demo"));
		System.out.println(text1.getAttribute("value"));

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();

		driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).click();

		Alert a2 = driver.switchTo().alert();
		a2.sendKeys("YOGA");
		a2.accept();

		WebElement java = driver.findElement(By.cssSelector("p#demo1"));
		System.out.println(java.getText());
		
		driver.close();

	}

}
