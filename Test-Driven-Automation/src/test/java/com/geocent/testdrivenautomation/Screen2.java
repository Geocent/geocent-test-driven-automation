/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocent.testdrivenautomation;


import org.openqa.selenium.*;

/**
 *
 * @author robby
 */
public class Screen2 {
                    
    public static void fillScreenTwo(WebDriver driver, String[] aryDataColumn){
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
                     if (!aryDataColumn[6].equals(""))
                        {
                             driver.findElement(By.xpath("//div[@id='q1']/div")).getText().contains("You should fill this box out with more then 1 word");
                             Globals.blnExitScenario = true;
                        }
                     if (!aryDataColumn[8].equals("") )
                        {
                             driver.findElement(By.xpath("//div[@id='q3']/div")).getText().contains("This question requires an answer");
                             Globals.blnExitScenario = true;
                        }
    }
}
