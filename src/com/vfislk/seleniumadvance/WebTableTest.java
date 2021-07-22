package com.vfislk.seleniumadvance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		String name=driver.findElement(By.xpath("//table[@id='example']/tbody/tr[i]/td[2]")).getText();
		System.out.println(name);
		
		for(int i=1;i<=10;i++)
		{
			System.out.println("i value "+i+" is printed");
			System.out.println("//table[@id='example']/tbody/tr["+i+"]/td[2]");
		}
	}

}




