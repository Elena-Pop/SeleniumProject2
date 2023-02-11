package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    private void setUp(){
        //1. deschidem pagina
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

    }

    @Parameters({ "user", "password" })

    @Test(priority = 1,groups = {"smoke", "regression"})

    public void login(String user, String password) {


        //2.Introducere username si parola
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);

//        try {
//        Thread.sleep(3000);
//        } catch (InterruptedException e) ;
//        throw new RuntimeException(e);
//        }


        WebElement passwordElement= driver.findElement(By.name("password"));
       passwordElement.sendKeys(password);

        //3.Logare
        WebElement loginButton= driver.findElement(By.className("radius"));
        //WebElement loginButton=driver.findElement{By.xpath("//*[@id="login"]/button/i")

       // WebElement loginButton= driver.findElement(By.cssSelector("#login > button > i"));
       //implicit waiy
        //o folosim cand astepatam incarcarea de date
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //asteapta pana elementul este clickable
        /*WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("fa fa-2x fa-sign-in")));*/
       loginButton.click();


        //4.Verification
        String landingURL="https://the-internet.herokuapp.com/login";
        Assert.assertEquals(landingURL,"https://the-internet.herokuapp.com/login");


        WebElement logoutButton= driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement alert= driver.findElement(By.id("flash"));
        String alertText= "You logged into a secure area!";
        Assert.assertTrue(alert.isDisplayed());
        Assert.assertTrue(alert.getText().contains(alertText));



    }
    @AfterMethod
    private void tearDown(){

        //5. Inchidem pagina
        driver.close();

    }
}
