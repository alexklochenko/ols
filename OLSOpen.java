package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class OLSOpen {

    public static void OLStest() throws AWTException {
        ChromeDriver driver1 = new ChromeDriver();
        driver1.get("https://ols.am-soft.ua/");

//убрать попап куки
        WebElement WB1 = driver1.findElement(By.className("popup__btn"));
        WB1.click();

//найти и нажать кнопку Войти
        WebElement WB2 = driver1.findElement(By.xpath("/html/body/header/div[3]"));
        WB2.click();

//найти и нажать Файловий ключ
        WB2 = driver1.findElement(By.xpath("/html/body/header/div[3]/ul/li[1]"));
        WB2.click();

//найти и нажать кнопку Криптотест
        WB2 = driver1.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div[3]/a"));
        WB2.click();

//переключемся на новій таб

        ArrayList<String> tabs = new ArrayList<>(driver1.getWindowHandles());
        driver1.switchTo().window(tabs.get(tabs.size() - 1));

//находим елемент Дробдаун список КНЕДП
        WebElement WB3 = driver1.findElement(By.xpath("//*[@id=\"acskType\"]"));
        WB3.click();

// вібераем КНЕДП
        WebElement WB4 = driver1.findElement(By.xpath("//*[@id=\"acskType\"]/option[5]"));
        WB4.click();

//    рандомний клік для того щоб закрити випадаючий список для КНЕП
        WB4=driver1.findElement(By.xpath("//*[@id=\"libVersion\"]"));
        WB4.click();


//    WebElement WB5=driver1.findElement(By.xpath("//*[@id=\"KeyFileName\"]"));
//    WebElement WB5=driver1.findElement(By.id("KeyFileName"));
//    WB5.click();


//    set pass
    WB4= driver1.findElement(By.xpath("//*[@id=\"passKeyFile\"]"));
    WB4.sendKeys("11223377");

////    click check pass
        WB4= driver1.findElement(By.xpath("//*[@id=\"btnReadKeyFile\"]"));
        WB4.click();



//        Robot robot = new Robot();
//        robot.delay(2000);
//        StringSelection stringSelection = new StringSelection("C:\\Users\\oleks\\OneDrive\\Документи\\not for all\\MasterKey_FOP\\Key-6 (7).dat");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//        // Нажимаем комбинацию клавиш для вставки пути к файлу в окно
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        // Нажимаем клавишу Enter для выбора файла
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


//
//
////Заполняєм данными поле ПИБ
//    WebElement WB10=driver1.findElement(By.xpath("//*[@id=\"fullname\"]"));
//    WB10.sendKeys("Клоченко Олександр Петрович");
//
////    set email
//     WB10=driver1.findElement(By.xpath("//*[@id=\"email\"]"));
//     WB10.sendKeys("test@test.ua");
//
////     set tel number
//        WB10=driver1.findElement(By.xpath("//input[@placeholder='+38(000)000-00-00']"));
//        WB10.sendKeys("+38(099)999-99-99");
//
////        set coment
//        WB10=driver1.findElement(By.xpath("//*[@id=\"comment\"]"));
//        WB10.sendKeys("this is my first selenium test");
//
//


    }
}
