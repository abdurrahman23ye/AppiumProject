package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gulsl\\IdeaProjects\\AppiumTurkish\\Apps\\gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);
        //id ile bulduk
       // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        //xpath index ile bulduk
       // driver.findElementByXPath("(//android.widget.Button)[2]").click();
        //xpath text
       // driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
        driver.findElementByXPath("//android.widget.Button[@text='Test']").click();
        Thread.sleep(3000);
        String expectedTitle = "Test a gesture";
        String actualTitle = driver.findElementById("android:id/title").getText();

        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(3000);
        driver.quit();




    }


}
