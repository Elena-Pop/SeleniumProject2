package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    private WebDriver driver;

    @BeforeMethod
    private void setUp() {
        //1. deschidem pagina
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();


    }
    @Test
    private void uploadTest(){

        WebElement choosefile= driver.findElement(By.id("file-upload"));
        choosefile.sendKeys("C:\\Users\\Asus\\IdeaProjects\\SeleniumProject2\\src\\test\\resources\\04d312aa-57e3-432a-8cdf-7e473e5132f6.jpg");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement mesaj= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String expectedTextMesaj= "File Uploaded!";
        Assert.assertEquals(mesaj.getText(), expectedTextMesaj);


    }

    @AfterMethod
    private void tearDown() {

        //5. Inchidem pagina
        driver.close();


    }
}