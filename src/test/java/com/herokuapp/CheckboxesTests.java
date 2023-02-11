package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests {
    private WebDriver driver;

    @BeforeMethod
    private void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
    }

    @Test
    public void checkboxeTest() {

        WebElement checkbox2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if (!checkbox2.isSelected()){

        checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());


        }




    @AfterMethod
    private void tearDown() {
        driver.close();


    }
}
