package com.practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
	ChromeDriver cd= new ChromeDriver();
	cd.get("https://www.myntra.com/");

	}

}
