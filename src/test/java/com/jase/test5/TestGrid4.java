package com.jase.test5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGrid4 {
	private WebDriver driver;
	DesiredCapabilities browserDriver;
	private String baseUrl;
	
	@Parameters({"browser","nodeUrl"})
	@BeforeTest
	public void setUp(String browser, String nodeUrl) throws MalformedURLException{
		System.out.println(browser);
		System.out.println(nodeUrl);
		if(browser.equals("chrome")){
			browserDriver=DesiredCapabilities.chrome();
		}else if(browser.equals("ff")){
			browserDriver=DesiredCapabilities.firefox();
		}else{
			Assert.fail("browser chrome");
		}
		String url=nodeUrl+"/wd/hub";
		driver=new RemoteWebDriver(new URL(url),browserDriver);
		baseUrl="https://www.baidu.com";
		
	}
	
	@Parameters({"browser"})
	@Test
	public void testGrid4(String browser) throws InterruptedException{
		driver.get(baseUrl);
		driver.findElement(By.id("kw")).sendKeys("this is "+browser);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		System.out.println("title "+driver.getTitle());
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}

}
