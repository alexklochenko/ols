package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CheckHeadersLinks {

    public static void Test(){

        ChromeDriver driver=new ChromeDriver();

//      Устанавливаем размер окна браузера
        Dimension size = new Dimension(1250, 800);
        driver.manage().window().setSize(size);

        driver.get("https://ols.am-soft.ua/");

//      close captcha pop-up
        WebElement element= driver.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
        element.click();

//      find and click Головна button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[1]"));
        element.click();

        WebElement elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/a"));
        element= driver.findElement(By.xpath("/html/body/header/div[1]/a"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Головна\" button ");
        }
        else {
            System.out.println("Page \"Головна\" - ok");
        }

//      find and click Акції button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[2]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Акції\" button ");
        }
        else {
            System.out.println("Page \"Акції\" - ok");
        }

//      find and click Про нас button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[3]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Про нас\" button ");
        }
        else {
            System.out.println("Page \"Про нас\" - ok");
        }


//      find and click Контакти button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[4]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Контакти\" button ");
        }
        else {
            System.out.println("Page \"Контакти\" - ok");
        }

//      find and click Партнерам button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[5]"));
        element.click();


        ArrayList <String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));
        element= driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Партнерам\" button ");
        }
        else {
            System.out.println("Page \"Партнерам\" - ok");
//            driver.close();
        }

//      find and click API button
        driver.switchTo().window(list.get(0));

        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[6]"));
        element.click();


        ArrayList<String> list2=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list2.get(2));


//      on API page: select & set PIB fild
        element= driver.findElement(By.xpath("//*[@id=\"FullName\"]"));
        element.click();
        element.sendKeys("Тест Тест Тест");

//      on API page: select & set ORG_code fild
        element=driver.findElement(By.xpath("//*[@id=\"OrgCode\"]"));
        element.sendKeys("АА112233");

//      on API page: select & set phone number fild
        element=driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
        element.click();
        element.sendKeys("0991234578");

//      on API page: select & set Email fild
        element=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        element.sendKeys("test@test.ua");


//      on API page: select & set MK Deal Number fild
        element=driver.findElement(By.xpath("//*[@id=\"DogovorNumber\"]"));
        element.sendKeys("testDeal");


//      on API page: select & set checkbox AgreeWith
        element=driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
        element.click();

//      on API page: select & set captcha Value
        element= driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
        element.click();

        Scanner scanner2=new Scanner(System.in);
        System.out.println("Set captcha value on API page!");
        String temp2=scanner2.nextLine();
        element.sendKeys(temp2);

//      on APS page: click Next button
        element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
        element.click();

//      If wrong capture as wrought_3
        boolean elementWasFound=true;

        while(elementWasFound=true){
            try {
                WebElement  elementMisstakeCaptcha = driver.findElement(By.xpath("//*[@id=\"captcha_TB_EC\"]"));

//      on API page: select & set checkbox AgreeWith
                element = driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
                element.click();

//      on API page: select & set captcha Value
                element = driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
                element.click();

                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Set captcha value on API page!");
                String temp3 = scanner3.nextLine();

                element.sendKeys(temp3);

//      on APS page: click Next button
                element = driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
                element.click();


            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Captcha-ok");
                elementWasFound  = false;
                break;

            }
        }

//      API page check resalt of the test
        String ApiTestResaltChec="Дані успішно надіслані. Найближчим часом наш спеціаліст зв'яжеться з Вами для уточнення деталей запиту. Дякуємо!";
        WebElement elementForCheckElement=driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div/span"));
        String elementForCheckString=elementForCheckElement.getText();


        if(elementForCheckString.equals(ApiTestResaltChec)){
            System.out.println("Page \"API\" - ok");
            System.out.println(elementForCheckString);
            element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/a"));
            element.click();
        }
        else{
            System.out.println("CheckHeadersLinks is faild:\"API\" button");
        }

//      find and click Клиентам button
        element=driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[7]"));
        element.click();

//      find and click Генерація ключа в файл button
        element=driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[7]/ul/li[2]/a"));
        element.click();

        try {
            Thread.sleep(5000); // 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      find & wait until element wil be clickable & set Pass
        element=driver.findElement(By.xpath("//*[@id=\"PGenKeyPassword\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.sendKeys("111");

//      find & set confirm of the pas
        element=driver.findElement(By.xpath("//*[@id=\"PKeyPasswordConfirm\"]"));
        element.click();
        element.sendKeys("111");

//      find & set Generat button
        element=driver.findElement(By.xpath("//*[@id=\"btnKeyGenBtn\"]/span"));
        element.click();

//      2 seconds wating
        try {
            Thread.sleep(5000); // 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

////      ckick "Agree" in browser modal window_1
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }


////      ckick "Agree" in browser modal window_
//        Alert alert = driver.switchTo().alert();
//
//        // Нажатие на кнопку "ОК" в модальном окне
//        alert.accept();
//
//        // Переход обратно на основное окно
//        driver.switchTo().defaultContent();




//      2 seconds wating

        try {
            Thread.sleep(2000); // 2 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      find & set Continuer button
        element=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button"));
        element.click();

         elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]"));
        if (elementForCheck !=null){
        System.out.println("Page \"Клиентам\" - ok");}
        else{
            System.out.println("CheckHeadersLinks is faild:\"Клиентам\" button ");
        }
    }

}
