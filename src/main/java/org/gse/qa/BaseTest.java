package org.gse.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.gse.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver;
    protected static Properties props;
    InputStream inputStream;

    public BaseTest() {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest
    public void beforeTest(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
       try {
           props = new Properties();
           String propFileName = "config.properties";

           inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
           props.load(inputStream);

           DesiredCapabilities caps = new DesiredCapabilities();
           caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
           caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
           caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
           caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
           caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
           caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
           caps.setCapability("newCommandTimeout", 300);
           caps.setCapability("noReset", true);
           URL url = new URL(props.getProperty("appiumURL"));
           driver = new AndroidDriver(url, caps);
           String sessionId = driver.getSessionId().toString();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void wairForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        wairForVisibility(element);
        element.click();
    }

    public void clickForClass(WebElement element){

    }

    public void sendKeys(WebElement element, String argument){
        wairForVisibility(element);
        element.sendKeys(argument);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
