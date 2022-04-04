package com.concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_concepts {

	public static void main(String[] args) {//key- driver name,value-path of the  webbrowser 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");
		WebDriver wb = new ChromeDriver();//upcasting or dynamic binding
		
		wb.get("https://www.facebook.com/");// to open fb browser
		wb.navigate().to("https://www.instagram.com/accounts/login/");// to open instagram browser
		wb.navigate().back();// going back to fb browser
		wb.navigate().to("https://www.youtube.com/");// from fb to youtube
		wb.navigate().back();//back to fb
		wb.navigate().to("https://twitter.com/");//fb to twitter
		wb.navigate().back();//back to fb browser
		String b = wb.getTitle();//getting the title of fb browser
		System.out.println(b);
		wb.navigate().forward();//fb to twitter
		wb.navigate().refresh();// refreshing the twitter page
		String a = wb.getTitle();//getting twitter title
		System.out.println(a);
		String c = wb.getCurrentUrl();//getting the twitter url
		System.out.println(c);
		wb.close();//to close the web browser

	}

}
