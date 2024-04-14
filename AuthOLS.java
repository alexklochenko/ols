package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthOLS {
    public static void MkKey () throws AWTException{
        ChromeDriver driver3=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver3, Duration.ofSeconds(1000));

        driver3.get("https://ols.am-soft.ua/account/authjs");

//        find and close cooky pop-up
        WebElement element=driver3.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
        element.click();

//        10 sec waiting

        try {
            Thread.sleep(5000); // 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//        find and choose KNDP
        element=driver3.findElement(By.xpath("//*[@id=\"CAsServersSelect\"]/option[3]"));
        element.click();

//        find and set Pass
        element=driver3.findElement(By.xpath("//*[@id=\"PKeyPassword\"]"));
        element.sendKeys("11223377");

//        find and click choose Key
        element=driver3.findElement(By.xpath("//*[@id=\"fgPKeyFileName\"]/div/div/span[2]"));
        element.click();


//       work with Window
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\oleks\\OneDrive\\Документи\\not for all\\MasterKey_FOP\\Key-6 (7).dat");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
////
////        // Нажимаем комбинацию клавиш для вставки пути к файлу в окно
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
////
////        // Нажимаем клавишу Enter для выбора файла
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



//        find and enter checkBox Save Pass
        element=driver3.findElement(By.xpath("//*[@id=\"MainFormId\"]/div[2]/div[2]/div[18]/div/div/label"));
        element.click();


//        find and enter VHID
        element=driver3.findElement(By.xpath("//*[@id=\"btnLogon\"]"));
        element.click();


//      10 sec waiting
        try {
            Thread.sleep(10000); // 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//        check resalt of the TestCase
        element=driver3.findElement(By.xpath("//*[@id=\"ols-brand\"]"));

        if ( element !=null){
            System.out.println("AuthOLS with MK Key is OK");
        }
        else {
            System.out.println("AuthOLS with MK Key is faild");
        }

//       close browser
     driver3.quit();


    }

    public static void DpsKey () throws AWTException{
        ChromeDriver driver3=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver3, Duration.ofSeconds(1000));

        driver3.get("https://ols.am-soft.ua/account/authjs");

//        find and close cooky pop-up
        WebElement element=driver3.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
        element.click();



        try {
            Thread.sleep(5000); // 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//        find and choose KNDP
        element=driver3.findElement(By.xpath("//*[@id=\"CAsServersSelect\"]/option[2]"));
        element.click();

//        find and set Pass
        element=driver3.findElement(By.xpath("//*[@id=\"PKeyPassword\"]"));
        element.sendKeys("11223377");

//        find and click choose Key
        element=driver3.findElement(By.xpath("//*[@id=\"fgPKeyFileName\"]/div/div/span[2]"));
        element.click();


//       work with Window
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\oleks\\OneDrive\\Документи\\not for all\\Key\\ДПС_после_08_03\\Key-6.dat");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

////        // Нажимаем комбинацию клавиш для вставки пути к файлу в окно
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

////        // Нажимаем клавишу Enter для выбора файла
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



//        find and enter checkBox Save Pass
        element=driver3.findElement(By.xpath("//*[@id=\"MainFormId\"]/div[2]/div[2]/div[18]/div/div/label"));
        element.click();


//        find and enter VHID
        element=driver3.findElement(By.xpath("//*[@id=\"btnLogon\"]"));
        element.click();

//      10 sec waiting
        try {
            Thread.sleep(10000); // 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        check resalt of the TestCase
        element=driver3.findElement(By.xpath("//*[@id=\"ols-brand\"]"));

        if ( element !=null){
            System.out.println("AuthOLS with Dps Key is OK");
        }
        else {
            System.out.println("AuthOLS with Dps Key is faild");
        }

//       close browser
        driver3.quit();


    }
}
