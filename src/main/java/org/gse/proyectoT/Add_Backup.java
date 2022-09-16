package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Add_Backup  extends setUp{
    private AppiumDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        Init();
    }

    @Test
    public void ShareNotification(){
        PageBase app = new PageBase(this.driver);
        app.textCedula("11441862",10);
        app.clickById("btn_update_document_number", 10);
        app.clickById("btn_dialog_cancel", 20);
        app.clickById("notificationInboxFragment", 10);
        app.clickById("moreFragment", 10);
        app.clickByXpath("\t\n" + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[6]/android.view.View");
        app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
        app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]");
        //app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup");
        app.clickById("action_toolbar_share", 10);
        app.clickById("btn_dialog_ok", 10);
        app.clickById("button2", 10);
    }

    @AfterClass
    public void finalize(){
        tearDown();
    }

}
