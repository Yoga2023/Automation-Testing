package com.web.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Main_Project {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		Robot r = new Robot();

		driver.get("http://automationpractice.com/index.php");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("Sele12345@gmail.com");

		driver.findElement(By.id("passwd")).sendKeys("123asd@Q");

		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

		driver.findElement(By.xpath("//a[@title='Women']")).click();

		WebElement cart = driver.findElement(By.xpath("(//a[contains(text(),'Blouse')])[3]"));

		a.contextClick(cart).perform();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Set<String> women = driver.getWindowHandles();
		for (String data : women) {
			System.out.println(driver.switchTo().window(data).getTitle());
		}

		String newTab = "Blouse - My Store";
		Thread.sleep(2000);
		for (String data1 : women) {

			if (driver.switchTo().window(data1).getTitle().equals(newTab)) {
				break;
			}

		}

		WebElement add = driver.findElement(By.xpath("//i[@class='icon-plus']"));

		for (int i = 0; i < 3; i++) {
			add.click();

		}
		WebElement size = driver.findElement(By.xpath("//select[@name='group_1']"));
		Select s = new Select(size);
		s.selectByValue("2");

		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

		driver.findElement(By.xpath("(//a[contains(@class,'default')])[2]")).click();

		driver.findElement(By.xpath("(//a[contains(@class,'default')])[5]")).click();

		driver.findElement(By.xpath("//button[@name='processAddress']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='checker']")).click();

		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();

		driver.findElement(By.xpath("//a[@class='bankwire']")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Main_Project.png");
		FileUtils.copyFile(source, destination);

	}

}
