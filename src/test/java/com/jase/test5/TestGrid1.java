package com.jase.test5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGrid1 {
	
	@BeforeClass
	public void setUp(){
		
	}
    
	@Test
	public void testGrid1() throws MalformedURLException{
		WebDriver driver = new RemoteWebDriver(new URL(
				"http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());

		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		driver.quit();


	}
	
	@AfterClass
	public void tearDown(){
		
	}

}
