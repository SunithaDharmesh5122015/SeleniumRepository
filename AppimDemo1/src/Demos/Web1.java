package Demos;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Web1 extends capability {

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
		driver.get("http:www.google.com");
		WebElement text=driver.findElement(By.name("q"));
		text.sendKeys("IBM");
		text.sendKeys(Keys.ENTER);
		List<AndroidElement> link=driver.findElements(By.tagName("a"));
		System.out.println("No of links --->"+link.size());	
		for (AndroidElement linkSize : link) {
			String text1=linkSize.getText();
			System.out.println(text1);
		}
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'IBM - Wikipedia')]"));
		js.executeScript("arguments[0].scrollIntoView()",ele);
		ele.click();
		
		
	}
}
