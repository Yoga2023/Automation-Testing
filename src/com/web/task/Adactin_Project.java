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

public class Adactin_Project {
	

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Yoga1996");
		driver.findElement(By.id("password")).sendKeys("Yog@1996");
		driver.findElement(By.id("login")).click();

		WebElement location = driver.findElement(By.id("location"));
		Select a = new Select(location);
		a.selectByVisibleText("Paris");

		WebElement hotels = driver.findElement(By.id("hotels"));
		Select b = new Select(hotels);
		b.selectByValue("Hotel Hervey");

		WebElement room = driver.findElement(By.id("room_type"));
		Select c = new Select(room);
		c.selectByIndex(4);

		WebElement roomCount = driver.findElement(By.id("room_nos"));
		Select d = new Select(roomCount);
		d.selectByValue("2");
		Thread.sleep(2000);
		driver.findElement(By.id("datepick_in")).sendKeys("05/03/2022");
		driver.findElement(By.id("datepick_out")).sendKeys("08/03/2022");

		WebElement adult = driver.findElement(By.id("adult_room"));
		Select e = new Select(adult);
		e.selectByIndex(2);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.id("radiobutton_0")).click();

		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys("YOGANANDHABABU");
		driver.findElement(By.id("last_name")).sendKeys("KUMARAVEL");
		driver.findElement(By.id("address")).sendKeys("KURUKKU SANTHU");
		driver.findElement(By.id("cc_num")).sendKeys("7358333066212365");

		WebElement ccType = driver.findElement(By.id("cc_type"));
		Select f = new Select(ccType);
		f.selectByValue("AMEX");

		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select g = new Select(month);
		g.selectByValue("8");

		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select h = new Select(year);
		h.selectByValue("2022");

		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		driver.findElement(By.id("book_now")).click();

		
		

		Thread.sleep(10000);		
				TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\ADACTIN.png");
		FileUtils.copyFile(source, destination);

		driver.close();

	}
}
