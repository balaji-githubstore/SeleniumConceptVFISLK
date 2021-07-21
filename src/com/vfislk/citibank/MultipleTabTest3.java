package com.vfislk.citibank;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleTabTest3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.online.citibank.co.in/");
		
		driver.findElement(By.xpath("//img[@class='appClose']")).click();
		
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();

		//convert set<String> to ArrayList<String> and then switchto index 1
		ArrayList<String> windows =new ArrayList<String>(driver.getWindowHandles());	
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.linkText("Travel")).click();
		
		driver.findElement(By.id("Email_Id")).sendKeys("john@gmail.com");
		
		driver.findElement(By.id("mobile_number")).sendKeys("9898898898");
		
		Select select=new Select(driver.findElement(By.id("Title")));
		select.selectByVisibleText("Mx.");
		
		driver.findElement(By.id("FirstName")).sendKeys("john d");
		
		driver.findElement(By.xpath("//input[@id='existcust' and @value='Yes']")).click();
		driver.close();

		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		
	}

}
