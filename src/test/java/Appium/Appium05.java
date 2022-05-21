package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gulsl\\IdeaProjects\\AppiumTurkish\\Apps\\Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

        /*
        install app
        do any mathematical operation
        and verify pre result and final result
         */

        AndroidElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        AndroidElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        AndroidElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        AndroidElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        AndroidElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        AndroidElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        AndroidElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        AndroidElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        AndroidElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        AndroidElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        AndroidElement multi = driver.findElementByAccessibilityId("multiply");
        AndroidElement equals = driver.findElementByAccessibilityId("equals");
        AndroidElement divide = driver.findElementByAccessibilityId("divide");
        AndroidElement minus = driver.findElementByAccessibilityId("minus");
        AndroidElement plus = driver.findElementByAccessibilityId("plus");

        num1.click();
        num5.click();
        multi.click();
        num3.click();
        Thread.sleep(2000);

        String expectedResult = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(expectedResult,"45");
        Thread.sleep(2000);
        equals.click();

        String actualResult = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("Ex "+expectedResult);
        System.out.println("Ac "+actualResult);




    }

}
