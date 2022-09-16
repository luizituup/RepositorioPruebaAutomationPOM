package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.gse.proyectoT.setUp.driver;
import static org.gse.proyectoT.setUp.getDriver;
import static org.openqa.selenium.By.id;

public class PageBase {
    public WebElement textFieldCedula;
    public WebElement textObservationMot;
    public WebElement texto;
    public WebElement scrollDown;
    int xx = 412;
    public double x = xx;
    public TouchAction actionsClick;
    public WebElement contextualMenuVar;
    public WebElement contextualMenuVar1;

    public PageBase(AppiumDriver appiumDriver){
        PageFactory.initElements(new AppiumFieldDecorator(setUp.getDriver()), PageBase.class);
    }
    public void waitForVisibility(int time){
        setUp.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id, 'action_bar_title')]")));
        //wait = (WebDriverWait) new FluentWait<WebDriverW>(setUp.getDriver()).withTimeout(Duration.ofSeconds(time));
    }
    public void clickElement(WebElement element, int time){
        waitForVisibility(time);
        element.click();
    }
    public void sendText(WebElement element, String textCedula) {
        element.sendKeys(textCedula);
    }
    public void textCedula(String textCedula, int time) {
        waitForVisibility(time);
        textFieldCedula =  setUp.getDriver().findElement(By.id("tiet_document_number"));
        sendText(textFieldCedula, textCedula);
    }

    public void textObservation(String textObservation, int time) {
        waitForVisibility(time);
        textObservationMot =  setUp.getDriver().findElement(By.id("tiet_observation"));
        sendText(textObservationMot, textObservation);
    }
    public void sendData(String dato){
        texto = setUp.getDriver().findElement(By.id("actv"));
        texto.getText();
        sendText(texto, dato);
    }
    public void clickById(String id, int time){
        waitForVisibility(time);
        setUp.getDriver().findElement(By.id(id)).click();
    }

    public void tapReason(int caso) throws Exception { //motivo
        TouchAction t = new TouchAction(setUp.getDriver());
        switch(caso){
            case 1:
                t.tap(PointOption.point(137, 536)).perform();
                break;
            case 2:
                t.tap(PointOption.point(129, 669)).perform();
                break;
            case 3:
                t.tap(PointOption.point(145, 798)).perform();
                break;
            case 4:
                t.tap(PointOption.point(125, 899)).perform();
                break;
            default:
                throw new Exception("Not supported Option");
        }
    }

    public void moveToDownNotification(int page, int time) {
        waitForVisibility(time);
        Dimension size = setUp.getDriver().manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.9);
        int endY = (int)(size.height * 0.3);

        for (int i = 0; i < page; i++) {
            TouchAction t = new TouchAction(setUp.getDriver());
            t.press(PointOption.point(startX, startY))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }
    }
    public void moveToDownDetailNotification() {
        TouchAction t = new TouchAction(setUp.getDriver());
        t.press(PointOption.point(505, 2097))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000)))
                .moveTo(PointOption.point(516,741))
                .release()
                .perform();
    }

    public void clickByXpath(String xpath){
        setUp.getDriver().findElement(By.xpath(xpath)).click();
    }
    public void scrollDown(){
        scrollDown = setUp.getDriver().findElement(id("co.ceduladigital.sdk.demo:id/rv_notification_inbox"));
        int centerX = scrollDown.getRect().x + (scrollDown.getSize().width/2);
        double startY = scrollDown.getRect().y + (scrollDown.getSize().height * 0.9);
        double endY = scrollDown.getRect().y + (scrollDown.getSize().height * 0.2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger,1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),centerX, (int)endY));
        swipe.addAction(finger.createPointerUp(0));
        setUp.getDriver().perform(Arrays.asList(swipe));
    }

}

