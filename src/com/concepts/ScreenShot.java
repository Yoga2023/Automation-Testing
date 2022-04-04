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

public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		Thread.sleep(2000);

		WebElement click = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		click.click();

		Thread.sleep(2000);

		WebElement frst = driver.findElement(By.xpath("//input[@name='firstname']"));
		frst.sendKeys("yoga");

		Thread.sleep(2000);

		WebElement last = driver.findElement(By.xpath("//input[contains(@name,'lastname')]"));
		last.sendKeys("babu");

		Thread.sleep(2000);

		WebElement mob = driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]"));
		mob.sendKeys("yoga1234@gmail.com");

		WebElement radio = driver.findElement(By.xpath("//label[text()='Male']"));
		radio.click();

		boolean a = radio.isEnabled();
		System.out.println(a);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\X-path.png");
		FileUtils.copyFile(source, destination);
		
		driver.close();

	}

}
