package com.geocent.testdrivenautomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import com.geocent.testdrivenautomation.Globals;
//import org.junit.Assert;
//import com.thoughtworks.selenium.*;

@RunWith(value = Parameterized.class)
//@PrepareForTest({Controller.class})
public class Controller {

    private WebDriver driver;
    private String baseUrl;
    private static List<Object[]> params;
    private String[] rowData;
    private StringBuffer verificationErrors = new StringBuffer();
    
    
    @Parameters
    public static List<Object[]> data() {

        if (params == null) {
            params = new LinkedList<Object[]>();

            File file = new File("");
            String strTemp = file.getAbsolutePath();
            String strFileLocation = strTemp + "\\src\\test\\java\\com\\geocent\\testdrivenautomation\\scenario.csv";
            File flInputFile = new File(strFileLocation);

            try {
                Scanner fileScanner = new Scanner(flInputFile);

                //Pull off first line that has headings on it
                fileScanner.nextLine();
                 
                //Loop through the data source until it has no more lines
                while (fileScanner.hasNextLine()) {
                    String [] [] strArray = new String [1] [];
                    strArray [0] =(fileScanner.nextLine().split("[,]"));
                    params.add (strArray);
                   // params.add(fileScanner.nextLine().split("[,]"));
                   
                }
                
            } catch (Exception ex) {
            }
        }

        return params;
    }
//constructor
    public Controller(Object rowData) {
        
        this.rowData = (String[])rowData;
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.surveymonkey.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // strScreen1 = new Screen1();
    }

    @Test
    public void testSurvey() throws Exception {
        System.out.println("");
        //Set Bln to false for exit scenario
        Globals.blnExitScenario = false;

        //Launch the application
        driver.get(baseUrl + "/s/7SV8LSJ");

        //First Screen of the Application
        if (!rowData[0].equals("") || !rowData[1].equals("") || !rowData[2].equals("") || !rowData[3].equals("")) {
            //Call Method for first screen of survey
            Screen1.fillScreenOne(driver, rowData);
        } else {
            //set the global to exit if there is no data for the screen
            Globals.blnExitScenario = true;
        }
        //If test has tested negativly then exit scenario
        if (!Globals.blnExitScenario) {
            //Second Screen of the Application 
            if (!rowData[5].equals("") || !rowData[6].equals("") || !rowData[7].equals("") || !rowData[8].equals("") || !rowData[9].equals("")) {
                //Call Method for Second screen of survey
                Screen2.fillScreenTwo(driver, rowData);
            } else {
                //set the global to exit if there is no data for the screen
                Globals.blnExitScenario = true;
            }
            //Check to see if there has already been a negative test if so exit scenario
            if (!Globals.blnExitScenario) {
                //Third Screen of the application

                if (!rowData[5].equals("") || !rowData[6].equals("") || !rowData[7].equals("") || !rowData[8].equals("") || !rowData[9].equals("")) {
                    //Call Method for Third screen of survey
                    Screen3.fillScreenThree(driver, rowData);
                } else {
                    //set the global to exit if there is no data for the screen
                    Globals.blnExitScenario = true;
                }
                //Start Login Functionality
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
