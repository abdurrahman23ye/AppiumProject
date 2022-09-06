package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//     setCapability() metodunu farkli sekillerde yazabillirsiniz
//        desiredCapabilities.setCapability("automationName", "UiAutomator2");
//        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Api_29");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\asus\\IdeaProjects\\AppiumTurkish\\Apps\\apiDemos.apk");
       // desiredCapabilities.setCapability("appPackage","com.android.launcher3" );
       // desiredCapabilities.setCapability("appActivity", "com.android.launcher3.uioverrides.QuickstepLauncher");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http:localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(7000);

       driver.unlockDevice();

    }
}
