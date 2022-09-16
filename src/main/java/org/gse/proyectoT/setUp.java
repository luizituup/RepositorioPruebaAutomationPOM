package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class setUp {
    public static AppiumDriver driver;
    public void Init() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        //caps.setCapability("platformVersion", "8.0");
        caps.setCapability("platformVersion", "12.0");
        //caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("deviceName", "8eaa6a43c6a9");
        caps.setCapability("session-override", "true");
        caps.setCapability("appPackage", "co.ceduladigital.sdk.demo");
        caps.setCapability("appActivity","co.ceduladigital.sdk.demo.MainActivity");
        caps.setCapability("noReset", true);

/*        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("12.0")
                .setDeviceName("8eaa6a43c6a9")
                .setAppPackage("co.ceduladigital.sdk.demo")
                .setAppActivity("co.ceduladigital.sdk.demo.MainActivity")
                .setNoReset(true)
                .eventTimings();*/

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            System.out.println("Driver session create sussesfully");
    }

    public static AppiumDriver getDriver(){
        if (driver == null) {
            System.out.println("No driver");
        } else {
            return driver;
        }
        return driver;
    }

    public static void setDriver(AppiumDriver driver) {
        setUp.driver = driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
