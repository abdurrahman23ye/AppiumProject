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

public class Appium06Chrome {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Api_29");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\asus\\IdeaProjects\\AppiumTurkish\\src\\Drivers\\chromedriver.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

        Set contextName=driver.getContextHandles();

        for (Object contextname:contextName
             ) {

            Thread.sleep(4000);

            if(contextname.toString().contains("CHOROMIUM")){

                driver.context((String)contextname);
            }
            
        }

        System.out.println(driver.getSessionId());

        //inspect icin chrome://inspect/#devices

        driver.get("https://www.amazon.com");

        driver.findElementByXPath("//input[@type='text']").sendKeys("nutella"+ Keys.ENTER);

    }
}
