package Demos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class capability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Dharmesh Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:\\Users\\SunithaS\\Downloads\\chromedriver_win32New\\chromedriver.exe");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
