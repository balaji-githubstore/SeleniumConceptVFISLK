package com.vfislk.citibank;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabTest2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.online.citibank.co.in/");
		
		driver.findElement(By.xpath("//img[@class='appClose']")).click();
		
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		
		System.out.println(driver.getTitle());
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		System.out.println("--------------------------------");
		
		Set<String> windows= driver.getWindowHandles();
		
		for(String win : windows)
		{
			System.out.println(win);
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());
			System.out.println("----------");
		}
		
		driver.findElement(By.linkText("Travel")).click();
		
		driver.close();

	}

}
