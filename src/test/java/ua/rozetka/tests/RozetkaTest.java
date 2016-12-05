package ua.rozetka.tests;

/**
 * Created by AntonKa on 12/3/2016.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RozetkaTest {

    private WebDriver driver;
    private String baseUrl;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testSendNameAndPriceToDB() throws Exception {

        HelpPage helpPage =new HelpPage(driver);
        helpPage.loginToRozetka("fejoz@rootfest.net", "Test1234");
        helpPage.navigateToSmartphones();
        helpPage.selectFromDropDown();

        WebElement namePhone1 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(0);
        String nameToPrint1 = namePhone1.getText();
        WebElement pricePhone1 = driver.findElements(By.cssSelector(".g-price-uah")).get(0);
        String pricePhoneToPrint1 = pricePhone1.getText();
        System.out.println(nameToPrint1);
        System.out.println(pricePhoneToPrint1);
        sendToDb(nameToPrint1, pricePhoneToPrint1);

        WebElement namePhone2 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(1);
        String nameToPrint2 = namePhone2.getText();
        WebElement pricePhone2 = driver.findElements(By.cssSelector(".g-price-uah")).get(1);
        String pricePhoneToPrint2 = pricePhone2.getText();
        System.out.println(nameToPrint2);
        System.out.println(pricePhoneToPrint2);

        sendToDb(nameToPrint2, pricePhoneToPrint2);

        WebElement namePhone3 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(2);
        String nameToPrint3 = namePhone3.getText();
        WebElement pricePhone3 = driver.findElements(By.cssSelector(".g-price-uah")).get(2);
        String pricePhoneToPrint3 = pricePhone3.getText();
        System.out.println(nameToPrint3);
        System.out.println(pricePhoneToPrint3);

        sendToDb(nameToPrint3, pricePhoneToPrint3);

        WebElement namePhone4 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(3);
        String nameToPrint4 = namePhone4.getText();
        WebElement pricePhone4 = driver.findElements(By.cssSelector(".g-price-uah")).get(3);
        String pricePhoneToPrint4 = pricePhone4.getText();
        System.out.println(nameToPrint4);
        System.out.println(pricePhoneToPrint4);

        sendToDb(nameToPrint4, pricePhoneToPrint4);
    }




//    private void login(String username, String password) {
//        driver.findElement(By.linkText("войдите в личный кабинет")).click();
//        driver.findElement(By.name("login")).click();
//        driver.findElement(By.name("login")).clear();
//        driver.findElement(By.name("login")).sendKeys(username);
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).clear();
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.name("auth_submit")).click();
//    }

    public void sendToDb(String namePhone, String phonePrice) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/rozetka?user=root&password=");
            String query = "INSERT INTO smartphones (name, price)"
                    + " values (?, ? )";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            //preparedStmt1.setInt(1, 01);
            preparedStmt.setString(1, namePhone);
            preparedStmt.setString(2, phonePrice);


            // execute the preparedstatement
            preparedStmt.execute();


            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();


        }
    }

