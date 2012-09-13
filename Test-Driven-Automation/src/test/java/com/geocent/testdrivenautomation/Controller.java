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
               //FileInputStream (strFileLocation);
               fileScanner.nextLine();
               strFileRow = fileScanner.nextLine();
               aryDataColumn = strFileRow.split(delims);
               System.out.println(aryDataColumn[1]);
            
		driver.get(baseUrl + "/s/7SV8LSJ");
		driver.findElement(By.xpath("//span/input")).clear();
		driver.findElement(By.xpath("//span/input")).sendKeys("7");
		driver.findElement(By.xpath("//div[3]/input")).click();
		//driver.findElement(By.xpath("//div[3]/label/img")).click();
		new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("No");
		driver.findElement(By.id("NextButton")).click();
		driver.findElement(By.xpath("//textarea")).clear();
		driver.findElement(By.xpath("//textarea")).sendKeys("Fifty");
		driver.findElement(By.xpath("//span/input")).clear();
		driver.findElement(By.xpath("//span/input")).sendKeys("5");
		driver.findElement(By.xpath("//div[3]/div/div[2]/span/input")).clear();
		driver.findElement(By.xpath("//div[3]/div/div[2]/span/input")).sendKeys("Jimmy");
		driver.findElement(By.id("NextButton")).click();
		driver.findElement(By.xpath("//td[2]/input")).clear();
		driver.findElement(By.xpath("//td[2]/input")).sendKeys("Ken");
		driver.findElement(By.xpath("//tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[2]/td[2]/input")).sendKeys("Economi");
		driver.findElement(By.xpath("//tr[3]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[3]/td[2]/input")).sendKeys("220 cherokee Ln");
		driver.findElement(By.xpath("//tr[4]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[4]/td[2]/input")).sendKeys("Suite Y");
		driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys("Slidell");
		new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("LA Louisiana");
		driver.findElement(By.xpath("//tr[7]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[7]/td[2]/input")).sendKeys("85956");
		driver.findElement(By.xpath("//tr[8]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[8]/td[2]/input")).sendKeys("USA");
		driver.findElement(By.xpath("//tr[9]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[9]/td[2]/input")).sendKeys("robby@robby.com");
		driver.findElement(By.xpath("//tr[10]/td[2]/input")).clear();
		driver.findElement(By.xpath("//tr[10]/td[2]/input")).sendKeys("2258959866");
		driver.findElement(By.xpath("//div[2]/input")).click();
		//driver.findElement(By.xpath("//div[2]/label/img")).click();
		driver.findElement(By.id("NextButton")).click();
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
