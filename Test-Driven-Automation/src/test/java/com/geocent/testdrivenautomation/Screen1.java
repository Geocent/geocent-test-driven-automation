/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author robby
 */
public class Screen1 {
    
    public static void fillScreenOne(WebDriver driver, String[] aryDataColumn){
                    //Question 1
                                driver.findElement(By.xpath("//span/input")).clear();
                                driver.findElement(By.xpath("//span/input")).sendKeys(aryDataColumn[0]);
                                //Question 2
                                driver.findElement(By.xpath("//div[" + aryDataColumn[2] + "]/input")).click();
                                //Question 3
                                new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(aryDataColumn[3]);
                                //Next Button
                                driver.findElement(By.id("NextButton")).click();
                                if (aryDataColumn[1] != null );
                                {
                                driver.findElement(By.xpath("//div[@id='q1']/div")).getText().contains("You must answer this questionto save the survey.");
                                }
    }
}
