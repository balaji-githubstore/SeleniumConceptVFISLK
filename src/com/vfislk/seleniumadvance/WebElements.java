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
		
		
//		WebElement ele= driver.findElement(By.linkText("Gmail"));
//		String href = ele.getAttribute("href");
//		String text=ele.getText();
		
//		System.out.println(href);
//		System.out.println(text);
		
		List<WebElement> elements= driver.findElements(By.xpath("//a"));
		int linkCount=elements.size();
		System.out.println(linkCount);
		
		
		
		WebElement ele0 = elements.get(24);
		
		String href = ele0.getAttribute("href");
		String text=ele0.getText();	
		System.out.println(href);
		System.out.println(text);
		
		
	}
}
