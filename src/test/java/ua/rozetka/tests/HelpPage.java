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

        driver.findElement(By.name("drop_link")).click();
        driver.findElement(By.linkText("популярные")).click();
    }

}



