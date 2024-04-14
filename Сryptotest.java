package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Сryptotest {
    public static void Test(){

        ChromeDriver driver2=new ChromeDriver();

        driver2.get("https://ols.am-soft.ua/account/authjs");

//          close cooky popup
        WebElement element=driver2.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
        element.click();

//          rundom click
        for (int i=0; i<20; i++){
            element=driver2.findElement(By.xpath("//*[@id=\"MainFormId\"]/div[2]/div[1]"));
            element.click();
        }
//          find redirect on cryptotest
        element=driver2.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div[3]"));
        element.click();

//          !!!!!!choose another TAB!!!!!!!
        ArrayList<String> tabs = new ArrayList<>(driver2.getWindowHandles());
        driver2.switchTo().window(tabs.get(tabs.size() - 1));

//          find and choose Dps KNDP
        element= driver2.findElement(By.xpath("//*[@id=\"acskType\"]/option[1]"));
        element.click();


//          find and click button "Choose Key file"
        element=driver2.findElement(By.id("KeyFileName"));
        element.sendKeys("C:\\Users\\oleks\\OneDrive\\Документи\\not for all\\Key\\ДПС_после_08_03\\Key-6.dat");

//          rundom click
//        for (int i=0; i<20; i++){
//            element=driver2.findElement(By.xpath("/html/body/header/h1"));
//            element.click();
//        }

        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//          find and set pass
        element= driver2.findElement(By.xpath("//*[@id=\"passKeyFile\"]"));
        element.click();
        element.sendKeys("11223377");
        element= driver2.findElement(By.xpath("//*[@id=\"btnReadKeyFile\"]"));
        element.click();

//          find and set sign
        element= driver2.findElement(By.xpath("//*[@id=\"btnSign\"]"));
        element.click();






//      find and set fild "PIB"
        element=driver2.findElement(By.xpath("//*[@id=\"fullname\"]"));
        element.sendKeys("Клоченко Олександр Петрович");

//      find and set Email
        element=driver2.findElement(By.xpath("//*[@id=\"email\"]"));
        element.sendKeys("test@test.ua");

//      find & set Phone num
        element=driver2.findElement(By.id("phone"));
        element.click();
        element.sendKeys("0997779977");

//      find & set Comment
        element= driver2.findElement(By.xpath("//*[@id=\"comment\"]"));
        element.sendKeys("automation pass crypto test");

//        find & set capcha
        element= driver2.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные для элемента captcha: ");
        String captchaValue = scanner.nextLine();

        element.sendKeys(captchaValue);

//        find & set acsses
        element= driver2.findElement(By.xpath("//*[@id=\"agreement\"]"));
        element.click();


        element= driver2.findElement(By.xpath("//*[@id=\"sendToBotBtn\"]"));
        element.click();

        WebElement finalResalt=driver2.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/form/div[3]"));
        element=driver2.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/form/div[3]"));

        if (element.equals(finalResalt)){
            System.out.println("Сryptotest with Dps Key is OK");
            WebElement jiraNum=driver2.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/form/div[4]"));
            System.out.println(jiraNum.getText());
        }
        else{
            System.out.println("AuthOLS with Dps Key is faild");
        }

//      close bouwser
        driver2.quit();

    }
}
