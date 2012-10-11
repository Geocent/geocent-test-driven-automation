/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocent.testdrivenautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author robby
 */
public class Screen3 {
    
    public static void fillScreenThree(WebDriver driver, String[] aryDataColumn)
    {
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
                                
                                if (!aryDataColumn[21].equals(""))
                                {
                                driver.findElement(By.xpath("//div[@id='q1']/div")).getText().contains("This question requires an answer");
                                Globals.blnExitScenario = true;
                                }
                                
}
}