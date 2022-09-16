package org.gse.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.gse.qa.BaseTest;

import java.util.List;

public class NotificationPage extends BaseTest {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.view.ViewGroup") private MobileElement firtNotification;
    @AndroidFindBy(id = "action_toolbar_share") private MobileElement BtnShare;
    @AndroidFindBy(id = "btn_dialog_ok") private MobileElement BtnContinue;
    @AndroidFindBy(className = "android.widget.TextView") private List<MobileElement> listNotificactions;



   public NotificationPage notificactionForsubject(String subject) throws InterruptedException {
       Thread.sleep(4000);
       for (MobileElement element : listNotificactions) {
           if (element.getText().equalsIgnoreCase(subject)) {
               System.out.println("Notification subject is " + element.getText());
               click(element);
               break;
           }
       }
       return this;
    }


    public NotificationPage clickFirstNotification() {
        click(firtNotification);
        return this;
    }

    public NotificationPage clickBtnShare() {
        click(BtnShare);
        return this;
    }

    public NotificationPage clickBtnContinueShare() {
        click(BtnContinue);
        return this;
    }


}
