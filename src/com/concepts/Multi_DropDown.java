package com.concepts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Multi_DropDown {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu/");

		WebElement we = driver.findElement(By.id("cars"));

		Select a = new Select(we);

		a.selectByValue("volvo");
		a.selectByVisibleText("Saab");
		a.selectByIndex(3);

		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\ScreenShot\\Multidropdown.png");
		FileUtils.copyFile(source, destination);

		System.out.println("*****Selecting one Option*****");
		WebElement b = a.getFirstSelectedOption();
		System.out.println(b.getText());

		Thread.sleep(2000);

		System.out.println("*****Selecting Multiple Option*****");
		List<WebElement> allSelectedOptions = a.getAllSelectedOptions();
		for (WebElement multi : allSelectedOptions) {
			Thread.sleep(300);
			System.out.println(multi.getText());
		}

		Thread.sleep(2000);

		System.out.println("*****To Get All Options*****");

		List<WebElement> options = a.getOptions();

		int c = options.size();
		System.out.println("Size of the WebElement: " + c);

		for (int i = 0; i < c; i++) {
			if (options.get(i).getText().equalsIgnoreCase("Opel")) {
				System.out.println(options.get(i).getText());
			}
		}

		Thread.sleep(2000);
		a.deselectAll();

		Thread.sleep(2000);
		driver.close();

	}
}
