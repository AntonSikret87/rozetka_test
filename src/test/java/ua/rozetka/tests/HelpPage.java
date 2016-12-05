package ua.rozetka.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by AntonKa on 12/5/2016.
 */
public class HelpPage {
    WebDriver driver;

    By username = By.name("login");
    By password = By.name("password");
    By loginButton = By.name("auth_submit");
    By enter = By.linkText("войдите в личный кабинет");
    By phoneTVandElectr = By.linkText("Телефоны, ТВ и электроника");
    By phones = By.linkText("Телефоны");
    By smartphones = By.linkText("Смартфоны");
    By dropDownLink = By.name("drop_link");
    By dropDownItemTop = By.linkText("популярные");
    By titledPhoneNames = By.cssSelector(".g-i-tile-i-title.clearfix>a");
    By titledPhonePrices = By.cssSelector(".g-price-uah");
    private String query = "INSERT INTO smartphones (name, price)" + " values (?, ? )";


    public HelpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToRozetka(String userid, String pass) {
        driver.findElement(enter).click();
        driver.findElement(username).sendKeys(userid);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public void navigateToSmartphones() {
        driver.findElement(phoneTVandElectr).click();
        driver.findElement(phones).click();
        driver.findElement(smartphones).click();
    }

    public void selectFromDropDown() {
        driver.findElement(dropDownLink).click();
        driver.findElement(dropDownItemTop).click();
    }

    public void phoneNameAdnPriceSendToDB(int index) {
        WebElement namePhone1 = driver.findElements(titledPhoneNames).get(index);
        String nameToPrint1 = namePhone1.getText();
        WebElement pricePhone1 = driver.findElements(titledPhonePrices).get(index);
        String pricePhoneToPrint1 = pricePhone1.getText();
//        System.out.println(nameToPrint1);
//        System.out.println(pricePhoneToPrint1);
        sendToDb(nameToPrint1, pricePhoneToPrint1);
    }

    public void sendToDb(String namePhone, String phonePrice) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/rozetka?user=root&password=");
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
}



