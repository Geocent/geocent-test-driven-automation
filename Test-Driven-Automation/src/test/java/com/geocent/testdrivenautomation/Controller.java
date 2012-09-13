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

public class Controller {
	private WebDriver driver;
	private String baseUrl;
        private String delims = "[,]";
        public String strFileRow;
        public String strFileLocation;
        public String[] aryDataColumn;
        public Scanner fileScanner;
        public File flInputFile;
        private String strQ22;
        
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.surveymonkey.com/s/7SV8LSJ";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                strFileLocation = "C:\\Users\\robby\\Documents\\GitHub\\geocent-test-driven-automation\\Test-Driven-Automation\\src\\test\\java\\com\\geocent\\testdrivenautomation\\scenario.csv";
                flInputFile= new File(strFileLocation);
                fileScanner = new Scanner(flInputFile);
	}

	@Test
	public void testSurvey() throws Exception {
               //Pull off first line that has headings on it
               fileScanner.nextLine();
               
               //Loop through the data source until it has no more lines
               while (fileScanner.hasNextLine() ){ 
                   
               
                    strFileRow = fileScanner.nextLine();
                    aryDataColumn = strFileRow.split(delims);
               
               
                    //First Screen of the Application
                    driver.get(baseUrl + "/s/7SV8LSJ");
                    //Question 1
                    driver.findElement(By.xpath("//span/input")).clear();
                    driver.findElement(By.xpath("//span/input")).sendKeys(aryDataColumn[0]);
                    //Question 2
                    driver.findElement(By.xpath("//div[" + aryDataColumn[2] + "]/input")).click();
                    //Question 3
                    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(aryDataColumn[3]);
                    //Next Button
                    driver.findElement(By.id("NextButton")).click();
		
                   //Second Sc+reen of the Application 
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
