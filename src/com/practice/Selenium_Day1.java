package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Day1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yogak\\eclipse-workspace\\Selenium_learning\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/ap/signin?clientContext=261-1311548-1212531&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.primevideo.com%2Fauth%2Freturn%2Fref%3Dav_auth_ap%3Flocation%3D%2F%3Fref_%253Ddv_auth_ret%2526mrntrk%253Dpcrid_386629063574_slid__pgrid_82649959407_pgeo_9299636_x__ptid_kwd-457550287913&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&accountStatusPolicy=P1&openid.assoc_handle=amzn_prime_video_desktop_us&openid.mode=checkid_setup&language=en_US&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		WebElement abc = driver.findElement(By.id("ap_email"));
		abc.sendKeys("yogababu1996@gmail.com");
		
		boolean q=abc.isEnabled();
		System.out.println(q);
		
		//boolean w=abc.isSelected();
		//System.out.println(w);
		WebElement awq = driver.findElement(By.id("ap_password"));
		awq.sendKeys("12345678iuy");
		String b= awq.getAttribute("value");
		System.out.println(b);
		String a=awq.getAttribute("tabindex");
		System.out.println(a);
		
		boolean c=awq.isDisplayed();
		System.out.println(c);
		
		WebElement qwe = driver.findElement(By.id("signInSubmit"));
		qwe.click();

	}

}
