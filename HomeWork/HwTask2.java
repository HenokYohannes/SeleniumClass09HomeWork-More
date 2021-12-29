package com.company.class09.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HwTask2 {

    public static void main(String[] args) {

    /*goto http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx
and delete all the eneteries which have product mymoney and lives in us state (edited)
     */

  System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

    driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();

     List<WebElement> rows=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));



for(int i=1;i<rows.size();i++){

    String text=rows.get(i).getText();
    if(text.contains("MyMoney")&& text.contains("US")){
        List<WebElement> checkbox= driver.findElements(By.xpath("//input[@type='checkbox']"));

    checkbox.get(i-1).click();
    }
}
driver.findElement(By.xpath("//input[@type='submit']")).click();



    }

}
