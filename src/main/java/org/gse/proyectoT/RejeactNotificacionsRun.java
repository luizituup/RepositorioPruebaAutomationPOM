package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class RejeactNotificacionsRun extends setUp {
    private AppiumDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        Init();
    }

    @Test
    public void rejeactNotifications() throws Exception {
        PageBase app = new PageBase(this.driver);
        //app.clickById("btn_dialog_cancel", 10);
        app.textCedula("11441862",10);
        app.clickById("btn_update_document_number", 10);
        app.clickById("btn_dialog_cancel", 20);
        app.clickById("notificationInboxFragment", 10);
        app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup");
        app.clickById("btn_reject", 15);
        app.clickById("actv",5);
        app.tapReason(4);
        app.textObservation("La notificacion no es para mi por que no es mi cedula", 10);
        app.clickById("btn_send_reject", 5);
        app.clickById("btn_dialog_ok", 10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //app.ContextualMenu();
    }

    @AfterClass
    public void finalize(){
        tearDown();
    }
}
