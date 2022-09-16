package org.gse.Main;

import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.File;
import java.util.List;


public class Main{

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        String ruta ="C:\\Users\\luis.bermudez\\Desktop\\repositorioMovil\\testng.xml";
        suites.add(ruta);//path to xml..
        testng.setTestSuites(suites);
        testng.run();
    }
}
