package org.gse.pages.test;

import org.gse.pages.LoginPage;
import org.gse.pages.NotificationPage;
import org.gse.qa.BaseTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ListNotifications extends BaseTest {

    LoginPage loginPage;
    NotificationPage notificationPage;


    @BeforeClass
    public void beforeClass(){
    }

    @AfterClass
    public void afterClass(){
    }

    @BeforeMethod
    public void beforeMethod(Method m){
        loginPage = new LoginPage();
        notificationPage = new NotificationPage();
        System.out.println("\n"+ "******** Starting Test Method " + m.getName() + "********");

    }

    @AfterMethod
    public void afterMethod(Method m){
    }
    @Test
    public void viewListNotificacions() throws InterruptedException {
        loginPage.sendCedula("11441869");
        loginPage.pressBtnUpdate();
        loginPage.pressBtnCancel();
        loginPage.pressBtnNotification();
        System.out.println("******** Test End ********");
    }


}
