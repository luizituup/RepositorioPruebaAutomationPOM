package org.gse.proyectoT;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Signature_Several_Documents_From_Three_Points_Document_module extends setUp{
    private AppiumDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        Init();
    }

    //View and signature the  only document - sin firma
    @Test
    public void signatureDocument(){
        PageBase app = new PageBase(this.driver);
        app.textCedula("11441869",10);
        app.clickById("btn_update_document_number", 10);
        app.clickById("btn_dialog_cancel", 20);
        app.clickById("notificationDocumentFragment", 10);
        app.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        app.clickByXpath("(//android.widget.ImageView[@content-desc=\"Boton mas opciones\"])[1]");
        app.clickByXpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]");
        app.clickById("btn_show_document", 10);
        app.clickById("btn_sign", 10);
        app.clickById("btn_sign", 10);
        //app.clickById("btn_dialog_error", 10); //finalize
        app.clickById("btn_dialog_ok",15);  //view document
        app.clickById("action_toolbar_exit", 10);  // close document after the view document

    }

    @AfterClass
    public void finalize(){
        tearDown();
    }
}
