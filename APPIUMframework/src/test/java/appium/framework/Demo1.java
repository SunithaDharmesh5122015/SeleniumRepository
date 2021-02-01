package appium.framework;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;



public class Demo1 extends Capability {

	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws Exception
	{
		//driver=capabilities(appPackage, appActivity, deviceName, chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
	
	@Test(enabled=false)
	public void testCase1() throws Exception
	{
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Dhaniskha");
	String nameValue=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
	System.out.println(nameValue);
	driver.findElementByAccessibilityId("android:id/text1").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
	driver.findElementByAccessibilityId("com.androidsample.generalstore:id/btnLetsShop").click();
	String expected="Dhaniskha";
 Assert.assertEquals(nameValue, expected);
	}
	@Test(enabled=false)
	public void testCase2() throws Exception
	{
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElementByAccessibilityId("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElementByAccessibilityId("com.androidsample.generalstore:id/btnLetsShop").click();
		String errorValue=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		String expected="Please enter your name";
		 Assert.assertEquals(errorValue, expected);	
	}
	@Test(enabled=false)
	public void testCase3() throws Exception
	{
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Dhaniskha");
	String nameValue=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
	System.out.println(nameValue);
	driver.findElementByAccessibilityId("android:id/text1").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
	driver.findElementByAccessibilityId("com.androidsample.generalstore:id/btnLetsShop").click();
	String expected="Dhaniskha";
 Assert.assertEquals(nameValue, expected);
 //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
 
 //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");

 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
	int l1=driver.findElements(By.id("")).size();
	for (int i = 0; i < l1; i++) {
	String productName=	driver.findElements(By.id("")).get(i).getText();
		if (productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
			driver.findElements(By.id("")).get(i).click();
			break;
		}
	}
	driver.findElement(By.id("")).click();
	String productname=driver.findElement(By.id("")).getText();
	String expectedName="Air Jordan 9 Retro";
	Assert.assertEquals(expectedName, productname);
	}
	
	@Test
	public void testCase4() throws Exception
	{
		service=startServer();
		driver=capabilities(appPackage, appActivity, deviceName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Dhaniskha");
	String nameValue=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
	System.out.println(nameValue);
	driver.findElementByAccessibilityId("android:id/text1").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
	driver.findElementByAccessibilityId("com.androidsample.generalstore:id/btnLetsShop").click();
	String expected="Dhaniskha";
 Assert.assertEquals(nameValue, expected);
 
 int l1=driver.findElements(By.id("")).size();
	for (int i = 0; i < l1; i++) {
		
		//click on Add to cart
	driver.findElements(By.id("")).get(i).click();
	driver.findElement(By.id("com.andriodsample.generalstore:id/appbar_btn_cart")).click();
	
//Add two Product amount id and compare with the final amount
	String amount1=driver.findElements(By.id("com.andriodsample.generalstore:id/productPrice")).get(0).getText();
	
	amount1=amount1.substring(1);
	
	Double amount1value=Double.parseDouble(amount1);
	
	
	String amount2=driver.findElements(By.id("com.andriodsample.generalstore:id/productPrices")).get(0).getText();
	
	amount2=amount2.substring(1);
	
	Double amount2value=Double.parseDouble(amount2);
	
	Double totalValue=amount1value+amount2value;
	
	String FinalAmount=driver.findElement(By.id("com.andriodsample.generalstore:id/productPrices")).getText();
	
	FinalAmount=FinalAmount.substring(1);
	
	Double finalAmountValue=Double.parseDouble(FinalAmount);
	
	Assert.assertEquals(finalAmountValue, totalValue);
	
	 WebElement tap = driver.findElementByClassName("andriod.widget.CheckBox");
	 TouchAction t = new TouchAction(driver);
	 t.tap(tapOptions().withElement(element(tap))).perform(); 
	 
	 WebElement LP=driver.findElement(By.id("com.andriodsample.generalstore:id/term"));
	 
	 t.longPress(longPressOptions().withElement(element(LP)).withDuration(ofSeconds(3))).release().perform();
	 
	 driver.findElement(By.id("andriod:id/button1")).click();
	 driver.findElement(By.id("com.andriod.sample.generalstore:id/btnProcess")).click();
	 
	 Set<String> contextNames = driver.getContextHandles();
	 for (String contextName : contextNames) {
	     System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	 }
	 //This is basically to switch between native apps and web in hybrid app(assesment question)
	 driver.context("WEBVIEW_com.andriodsample.generalStore");
	 Thread.sleep(5000);
	 driver.findElement(By.name("q")).sendKeys("IBM");
	 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	 Thread.sleep(3000);
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	 driver.context("NATIVE_APP");
	 service.stop();
		}
	}
	}

	
