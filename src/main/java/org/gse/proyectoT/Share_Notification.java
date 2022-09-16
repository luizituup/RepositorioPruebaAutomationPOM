package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Share_Notification extends setUp{
    private AppiumDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        Init();
    }

    @Test
    public void ShareNotification(){
        PageBase app = new PageBase(this.driver);
        app.textCedula("11441869",20);
        app.clickById("btn_update_document_number", 10);
        app.clickById("btn_dialog_cancel", 20);
        app.clickById("notificationInboxFragment", 10);
        app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup");
        app.clickById("action_toolbar_share", 10);
        app.clickById("btn_dialog_ok.", 10);
        //app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.GridView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.ImageView");
        //app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        // app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.Button/android.widget.FrameLayout/android.widget.ImageView");
        //app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[9]");
        //app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
        //app.clickById("button2", 10);
    }

    @AfterClass
    public void finalize(){
        tearDown();
    }
}
