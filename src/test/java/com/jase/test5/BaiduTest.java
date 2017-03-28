package com.jase.test5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class BaiduTest {
	private WebDriver driver;
	private String baseUrl;
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver_win32\\chromedriver.exe");			
		
	driver = new ChromeDriver();
	baseUrl = "https://www.baidu.com/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void testBaidu() throws Exception {
	driver.get(baseUrl + "/");
	driver.findElement(By.id("kw")).sendKeys("testNG");
	driver.findElement(By.id("su")).click();
	Thread.sleep(2000);
	String title = driver.getTitle();
	assertEquals(title, "testNG_百度搜索");
	}
	@AfterClass
	public void tearDown() throws Exception {
	driver.quit();
	}

}
