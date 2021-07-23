package com.vfislk.seleniumadvance;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest2 {

	public static void main(String[] args) {
		
//		System.out.println(LocalDateTime.now().toLocalDate());
		
		WebDriver driver=new ChromeDriver();	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://datatables.net/examples/basic_init/scroll_y.html");

		int rowCount=driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		System.out.println(rowCount);
		
		while(driver.findElements(By.xpath("Live DOM ordering")).size()==0)
		{
			js.executeScript("window.scrollBy(0,100)");
			
		}
		
		while(driver.findElements(By.xpath("//h1[text()='Live DOM ordering']")).size()==0)
		{
			driver.findElement(By.linkText("Live DOM ordering")).click();
		}
		
		while(driver.findElements(By.xpath("//h1[text()='Live DOM ordering']")).size()==0)
		{
			try
			{
				driver.findElement(By.linkText("Live DOM ordering")).click();
			}
			catch(Exception e)
			{
				
			}
		}
		
		
		
		
		
		
		
		for(int i=1;i<=rowCount;i++)
		{
			WebElement ele=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]"));
			
			js.executeScript("arguments[0].scrollIntoView()",ele);
			
			String name=ele.getText();
			System.out.println(name);	
		}
		
		
		
		
	}
}




