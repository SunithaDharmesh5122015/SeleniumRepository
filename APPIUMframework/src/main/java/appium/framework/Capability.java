package appium.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.collections.functors.IfClosure;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Capability {
	
	
	protected static String appPackage;
	protected static String appActivity;
	protected static String deviceName;
	protected static String platformName;
	protected static String chromeExecutable;
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
	boolean flag=checkIfServerIsRunning(4723);
	if(!flag)
	{
	/*
	 * public AppiumDriverLocalService startServer() {
	 * service=AppiumDriverLocalService.buildDefaultService(); service.start();
	 * return service; }
	 */
	

		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                //This is the path of my Nodesjs
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                //This is the path of  my appium 
                .withAppiumJS(new File("C:\\Users\\Administrator\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                //should start with ip adderes and port id
                .withIPAddress("127.0.0.1").usingPort(4723));
        service.start();
		
	}
	return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket Serversocket;
				try {
					
					Serversocket=new ServerSocket();
					Serversocket.close();
				} catch (Exception e) {
					isServerRunning=true;
				}
				finally {
					Serversocket=null;
				}
				return isServerRunning;
	}
	public static void startEmulator() throws IOException, Exception
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir"+"//src//main//java//emulator.bat"));
		Thread.sleep(8000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appPackage,String appActivity,String deviceName,String chromeExecutable) throws MalformedURLException, Exception {
		
		FileReader fis=new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		
		Properties pro=new Properties();
		pro.load(fis);
		
		appPackage=pro.getProperty(appPackage);
		appActivity=pro.getProperty(appActivity);
		deviceName=pro.getProperty(deviceName);
		//platformName=pro.getProperty(platformName);
		chromeExecutable=pro.getProperty(chromeExecutable);
		
		if (deviceName.contains("Sanjiv Android")) {
			startEmulator();
		}
			
		// TODO Auto-generated method stub
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,chromeExecutable);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
}