package Demos;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CaseStudy extends capability {

	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		driver=capability();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
	@Test
	public void testCase1() throws Exception
	{
		driver.get("https://m.cricbuzz.com/");
		//Menu element
		WebElement menu=driver.findElement(By.xpath("//a[@href='#menu']"));
		//I want to click on Menu
		menu.click();
		//Home Element
		WebElement home=driver.findElement(By.xpath("//a[.='Home']"));
		//I want to click on Home 
		home.click();
		//Top Stories Element
		WebElement topStories=driver.findElement(By.xpath("//h4[.='Top Stories']"));
		//i want to scroll to an element 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",topStories);
		String expectedText="";
		String actualText=topStories.getText();
		Assert.assertEquals(actualText, expectedText);
	}
}
