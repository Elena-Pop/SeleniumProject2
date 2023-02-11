package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //1. deschidem pagina
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Parameters ({"negativeuser", "password"})


    @Test(priority = 2, groups = {"regression"})

    public void negativelogin(String negativeuser, String password) {

        //2.Introducere username si parola
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys(negativeuser);
        WebElement passwordElement= driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        //3.Logare
        WebElement loginButton= driver.findElement(By.className("radius"));
        loginButton.click();

        //4.Verification
        String landingURL="https://the-internet.herokuapp.com/login";
        Assert.assertEquals(landingURL,"https://the-internet.herokuapp.com/login");
        WebElement alert= driver.findElement(By.id("flash"));
        String alertText= "Your username is invalid!";
        Assert.assertTrue(alert.isDisplayed());
        Assert.assertTrue(alert.getText().contains(alertText));


    }
    @AfterMethod
            private void tearDown(){
        driver.close();
    }

}
