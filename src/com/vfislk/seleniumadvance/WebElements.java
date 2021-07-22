package com.vfislk.seleniumadvance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
		driver.get("https://www.google.com/");
		
		List<WebElement> elements= driver.findElements(By.xpath("//a[text()='Gmail']"));
		int linkCount=elements.size();
		
		 WebElement ele0= elements.get(0);
		 ele0.click();
		
		
		System.out.println(linkCount);
	}
}
