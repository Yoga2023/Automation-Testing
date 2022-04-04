package com.practice;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

		Thread.sleep(2000);

		driver.manage().window().maximize();

		Thread.sleep(2000);
		// All Data

		List<WebElement> allData = driver.findElements(By.xpath("//table/tbody/tr/td"));

		Iterator<WebElement> data = allData.iterator();

		while (data.hasNext()) {
			System.out.println(data.next().getText());
		}

//Column Data's:

		List<WebElement> colData = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

		ListIterator<WebElement> data1 = colData.listIterator();

		while (data1.hasNext()) {
			System.out.println(data1.next().getText());
		}

//Row Data's:

		List<WebElement> rowData = driver.findElements(By.xpath("//table/tbody/tr[2]/td"));

		for (WebElement data2 : rowData) {

			System.out.println(data2.getText());

		}

//Specified Data:

		List<WebElement> spdata = driver.findElements(By.xpath("//table/tbody/tr[2]/td[3]"));

		for (WebElement data4 : spdata) {
			System.out.println(data4.getText());
		}

//Specified data, if only one table present in web page:
		WebElement spData1 = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
		System.out.println(spData1.getText());

	}
}
