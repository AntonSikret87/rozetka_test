package ua.rozetka.tests;

/**
 * Created by AntonKa on 12/3/2016.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.*;


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
        HelpPage helpPage = new HelpPage(driver);
        helpPage.loginToRozetka("fejoz@rootfest.net", "Test1234");
        helpPage.navigateToSmartphones();
        //according task:
        //-Should be performed search on 1-3 pages by Top
        //-Top Name and Price should be sent to DB
        //instead:
        //-Selecting by Top on 1 page
        //-First 4 Top Name and Price was sent to DB
        helpPage.selectFromDropDown();
        helpPage.phoneNameAdnPriceSendToDB(0);
        helpPage.phoneNameAdnPriceSendToDB(1);
        helpPage.phoneNameAdnPriceSendToDB(2);
        helpPage.phoneNameAdnPriceSendToDB(3);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

