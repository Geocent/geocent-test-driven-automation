package com.geocent.testdrivenautomation;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Scanner;
//import com.geocent.testdrivenautomation.Globals;
//import org.junit.Assert;
//import com.thoughtworks.selenium.*;


public class Controller {
	private WebDriver driver;
	private String baseUrl;
        private String delims = "[,]";
        public String strFileRow;
        public String strFileLocation;
        public String[] aryDataColumn;
        public Scanner fileScanner;
        public File flInputFile;
        private String strTemp;
        //private Screen1 strScreen1;
        
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.surveymonkey.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                File file = new File("");
                strTemp = file.getAbsolutePath();
                strFileLocation = strTemp + "\\src\\test\\java\\com\\geocent\\testdrivenautomation\\scenario.csv";
                flInputFile= new File(strFileLocation);
                fileScanner = new Scanner(flInputFile);
               // strScreen1 = new Screen1();
	}

	@Test
	public void testSurvey() throws Exception {
               //Pull off first line that has headings on it
               fileScanner.nextLine();
               
               //Loop through the data source until it has no more lines
               while (fileScanner.hasNextLine() ){ 
                   System.out.println("+1");
                   //Set Bln to false for exit scenario
                    Globals.blnExitScenario = false;
                    strFileRow = fileScanner.nextLine();
                    //Splits out the line into an array
                    aryDataColumn = strFileRow.split(delims);
               
                    //Launch the application
                    driver.get(baseUrl + "/s/7SV8LSJ");
                    
                    //First Screen of the Application
                    if (!aryDataColumn[0].equals("") || !aryDataColumn[1].equals("") || !aryDataColumn[2].equals("") || !aryDataColumn[3].equals(""))
                            {
                                //Call Method for first screen of survey
                                Screen1.fillScreenOne(driver, aryDataColumn);
                            }
                    else
                            {
                                //set the global to exit if there is no data for the screen
                                Globals.blnExitScenario = true;
                            }
                   //If test has tested negativly then exit scenario
                   if (!Globals.blnExitScenario)
                           {
                            //Second Screen of the Application 
                        if (!aryDataColumn[5].equals("") || !aryDataColumn[6].equals("") || !aryDataColumn[7].equals("") || !aryDataColumn[8].equals("")|| !aryDataColumn[9].equals("")) 
                            {
                                //Call Method for Second screen of survey
                                Screen2.fillScreenTwo(driver, aryDataColumn);
                            }
                        else
                            {
                                //set the global to exit if there is no data for the screen
                                Globals.blnExitScenario = true;
                            }
                        //Check to see if there has already been a negative test if so exit scenario
                            if (!Globals.blnExitScenario)
                            {
                                //Third Screen of the application
                                
                                    if (!aryDataColumn[5].equals("") || !aryDataColumn[6].equals("") || !aryDataColumn[7].equals("") || !aryDataColumn[8].equals("")|| !aryDataColumn[9].equals("")) 
                                    {
                                       //Call Method for Third screen of survey
                                       Screen3.fillScreenThree(driver, aryDataColumn);
                                    }
                                    else
                                    {
                                      //set the global to exit if there is no data for the screen
                                      Globals.blnExitScenario = true;
                                    }
                    //Start Login Functionality
                            }
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
