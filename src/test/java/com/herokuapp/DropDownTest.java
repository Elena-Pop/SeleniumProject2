package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {
    private WebDriver driver;

    @BeforeMethod
    private void setUp(){
        //1. deschidem pagina
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }
    @Test
    public void dropdownTest(){
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select= new Select(dropdown);
       // select.selectByValue("1");
        select.selectByVisibleText("Option 1");

        WebElement firstOption= driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
        Assert.assertTrue(firstOption.isSelected());
    }




    @AfterMethod
    private void tearDown(){

        //5. Inchidem pagina
        driver.close();

    }
}
