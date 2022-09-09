package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06ChromeNative {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Api_29");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
    //    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome"); native de kaldiriliyor
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
    //    desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\asus\\IdeaProjects\\AppiumTurkish\\src\\Drivers\\chromedriver.exe");
        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        //app pakage ve app activity icin cmd de 1 adb devices
        //2 adb shell
        //dumpsys window | grep -E "mCurrentFocus"

        // oradaki iki veriyi al

        //!! bu testi çaliştirdiktan sonra aldım

        //5e36aac u0 com.android.chrome/com.google.android.apps.chrome.Main}
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

    /*    Set contextName=driver.getContextHandles();

        System.out.println("contextName = " + contextName);

        for (Object contextname:contextName
             ) {

            Thread.sleep(4000);

            if(contextname.toString().contains("WEBVIEW")){

                driver.context((String)contextname);
            }
            
        }
        */

        System.out.println(driver.getSessionId());

        //inspect icin chrome://inspect/#devices

        driver.get("https://www.amazon.com");

        driver.findElementByAndroidUIAutomator("UiSelector().resourceID("buraya resourceID ya da her ne ile bulunacaksa")");
        driver.findElementByAndroidUIAutomator("UiSelector().resourceID("buraya resourceID ya da her ne ile bulunacaksa").text("buraya text yazılabilir")");

        //resourceId ile
        // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
//indexle
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/AppiumTechpro/src/Apps/gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset","true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//add button tikladik
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();

        Thread.sleep(5000);

        String isFalse = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled");

        Assert.assertEquals(isFalse,"false");

        MobileElement textBox = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")");
        textBox.sendKeys("text");
        Thread.sleep(5000);
        MobileElement blackScreen = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gestures_overlay\")");
        blackScreen.click();
        String isTrue = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)").getAttribute("enabled");

        Assert.assertEquals(isTrue,"true");

        System.out.println("done button enabled");

        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\")").click();

        Thread.sleep(5000);
        //session kapat


    }
}
