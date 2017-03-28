package com.jase.test5;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	ChromeOptions options;
	private String baseUrl;
	
	@Parameters({"browser","nodeUrl"})
	@BeforeTest
	public void setUp(String browser, String nodeUrl) throws MalformedURLException{
		System.out.println(browser);
		System.out.println(nodeUrl);
		if(browser.equals("chrome")){
			//由于Chrome不支持强制加插件，需要这样实现，这个插件是用于截图的
			options=new ChromeOptions();
			options.setExperimentalOption("forceDevToolsScreenshot", true);
			browserDriver.setCapability(ChromeOptions.CAPABILITY, options);
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
	public void testGrid4(String browser) throws InterruptedException, IOException{
		driver.get(baseUrl);
		driver.findElement(By.id("kw")).sendKeys("this is "+browser);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		System.out.println("title "+driver.getTitle());
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("d:\\screenshot"+browser+".png"));

	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}

}
