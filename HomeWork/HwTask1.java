package com.company.class09.HomeWork;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HwTask1 {
    public static void main(String[] args) {
        /*
goto https://chercher.tech/practice/explicit-wait
1.click on open an alert after 5 sec and then using explicit wait manage that alert
2.click on display button after 10 sec and once the button is displayed  print the status of isDisplayed() (edited)
         */
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/explicit-wait");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        WebElement alert = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        alert.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        driver.findElement(By.xpath("//button[@id='display-other-button']")).click();

        WebDriverWait click1 = new WebDriverWait(driver, 20);
        WebElement element = click1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='hidden']")));
        WebElement btn = driver.findElement(By.xpath("//button[@id='hidden']"));

        boolean enabled = btn.isDisplayed();

        System.out.println("The Btn is displayed " + enabled);

    }
}

