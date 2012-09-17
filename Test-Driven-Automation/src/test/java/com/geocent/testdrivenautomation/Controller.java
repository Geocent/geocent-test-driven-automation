package com.geocent.testdrivenautomation;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Scanner;
import org.junit.Assert;
import com.thoughtworks.selenium.*;


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
                   
               
                    strFileRow = fileScanner.nextLine();
                    //Splits out the line into an array
                    aryDataColumn = strFileRow.split(delims);
               
                    //Launch the application
                    driver.get(baseUrl + "/s/7SV8LSJ");
                    
                    //First Screen of the Application
                    if (aryDataColumn[0] != null || aryDataColumn[1] != null || aryDataColumn[2] != null || aryDataColumn[3] != null); 
                            {
                                //Call Method for first screen of survey
                                Screen1.fillScreenOne(driver, aryDataColumn);
                                //Question 1
                            //    driver.findElement(By.xpath("//span/input")).clear();
                            //    driver.findElement(By.xpath("//span/input")).sendKeys(aryDataColumn[0]);
                                //Question 2
                            //    driver.findElement(By.xpath("//div[" + aryDataColumn[2] + "]/input")).click();
                                //Question 3
                            //    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(aryDataColumn[3]);
                                //Next Button
                            //    driver.findElement(By.id("NextButton")).click();
                            //    if (aryDataColumn[1] != null );
                            //    {
                            //    driver.findElement(By.xpath("//div[@id='q1']/div")).getText().contains("You must answer this questionto save the survey.");
                            //    }
                                                     
                                
                            }
                   //Second Screen of the Application 
                    //Question 4 How Many
                    driver.findElement(By.xpath("//textarea")).clear();
                    driver.findElement(By.xpath("//textarea")).sendKeys(aryDataColumn[5]);
                    //Question 5 Friends
                    driver.findElement(By.xpath("//span/input")).clear();
                    driver.findElement(By.xpath("//span/input")).sendKeys(aryDataColumn[7]);
                    //Question 6 Name
                    driver.findElement(By.xpath("//div[3]/div/div[2]/span/input")).clear();
                    driver.findElement(By.xpath("//div[3]/div/div[2]/span/input")).sendKeys(aryDataColumn[9]);
                    //Next Button
                    driver.findElement(By.id("NextButton")).click();
                
                    //Third Screen of the application
                    //Question 7 Name
                    driver.findElement(By.xpath("//td[2]/input")).clear();
                    driver.findElement(By.xpath("//td[2]/input")).sendKeys(aryDataColumn[11]);
                    //Question 7 Company Name
                    driver.findElement(By.xpath("//tr[2]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[2]/td[2]/input")).sendKeys(aryDataColumn[12]);
                    //Question 7 Address 
                    driver.findElement(By.xpath("//tr[3]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[3]/td[2]/input")).sendKeys(aryDataColumn[13]);
                    //Question 7 Address 2
                    driver.findElement(By.xpath("//tr[4]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[4]/td[2]/input")).sendKeys(aryDataColumn[14]);
                    //Question 7 City
                    driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(aryDataColumn[15]);
                    //Question 7 State
                    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(aryDataColumn[16]);
                    //Question 7 Zip
                    driver.findElement(By.xpath("//tr[7]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[7]/td[2]/input")).sendKeys(aryDataColumn[17]);
                    //Question 7 Country
                    driver.findElement(By.xpath("//tr[8]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[8]/td[2]/input")).sendKeys(aryDataColumn[18]);
                    //Question 7 Email
                    driver.findElement(By.xpath("//tr[9]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[9]/td[2]/input")).sendKeys(aryDataColumn[19]);
                    //Question 7 phone
                    driver.findElement(By.xpath("//tr[10]/td[2]/input")).clear();
                    driver.findElement(By.xpath("//tr[10]/td[2]/input")).sendKeys(aryDataColumn[20]);

                    driver.findElement(By.id("NextButton")).click();
                    
                    //Start Login Functionality
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
