package org.gse.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.gse.qa.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {

    @FindBy(id = "tiet_document_number") private WebElement textCedula;
    @FindBy(id = "btn_update_document_number") private WebElement btnUpdateDocumentNumber;
    @FindBy(id = "btn_dialog_cancel") private WebElement btnDialogCancel;
    @FindBy(id = "notificationInboxFragment") private WebElement btnNotificationInboxFragment;
    @FindBy(id = "notificationDocumentFragment") private WebElement btnNotificationDocumentFragment;

    public LoginPage sendCedula(String cedula){
        sendKeys(textCedula, cedula);
        return this;
    }

    public LoginPage pressBtnUpdate() {
        click(btnUpdateDocumentNumber);
        return this;
    }

    public LoginPage pressBtnCancel() {
        click(btnDialogCancel);
        return this;
    }
    public NotificationPage pressBtnNotification() {
        click(btnNotificationInboxFragment);
        return new NotificationPage();
    }

    public LoginPage pressBtnDocuments() {
        click(btnNotificationDocumentFragment);
        return this;
    }



}
