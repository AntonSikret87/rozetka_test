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
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://rozetka.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @Test
    public void testRozetka() throws Exception {

        login("fejoz@rootfest.net", "Test1234");
        navigateToSmartphones();
        TimeUnit.SECONDS.sleep(2);
        selectFromDropDown();


       /* String[] allLinks = new String[]{
                ".//*[@id='block_with_goods']/div[1]/div[3]",
                ".//*[@id='block_with_goods']/div[1]/div[4]",
                ".//*[@id='block_with_goods']/div[1]/div[5]",
                ".//*[@id='block_with_goods']/div[1]/div[6]",
                ".//*[@id='block_with_goods']/div[1]/div[7]",
                ".//*[@id='block_with_goods']/div[1]/div[8]",
                ".//*[@id='block_with_goods']/div[1]/div[9]",
                ".//*[@id='block_with_goods']/div[1]/div[10]",
                ".//*[@id='block_with_goods']/div[1]/div[11]",
                ".//*[@id='block_with_goods']/div[1]/div[12]",
                ".//*[@id='block_with_goods']/div[1]/div[13]",
                ".//*[@id='block_with_goods']/div[1]/div[14]",
                ".//*[@id='block_with_goods']/div[1]/div[15]",
                ".//*[@id='block_with_goods']/div[1]/div[16]",
                ".//*[@id='block_with_goods']/div[1]/div[17]",
                ".//*[@id='block_with_goods']/div[1]/div[18]",
                ".//*[@id='block_with_goods']/div[1]/div[19]",
                ".//*[@id='block_with_goods']/div[1]/div[20]",
                ".//*[@id='block_with_goods']/div[1]/div[21]",
                ".//*[@id='block_with_goods']/div[1]/div[22]",
                ".//*[@id='block_with_goods']/div[1]/div[23]",
                ".//*[@id='block_with_goods']/div[1]/div[24]",
                ".//*[@id='block_with_goods']/div[1]/div[25]",
                ".//*[@id='block_with_goods']/div[1]/div[26]",
                ".//*[@id='block_with_goods']/div[1]/div[27]",
                ".//*[@id='block_with_goods']/div[1]/div[28]",
                ".//*[@id='block_with_goods']/div[1]/div[29]",
                ".//*[@id='block_with_goods']/div[1]/div[30]",
                ".//*[@id='block_with_goods']/div[1]/div[31]",
                ".//*[@id='block_with_goods']/div[1]/div[32]",
                ".//*[@id='block_with_goods']/div[1]/div[33]",
                ".//*[@id='block_with_goods']/div[1]/div[34]",
                ".//*[@id='block_with_goods']/div[1]/div[35]"};
        List<String> lList = Arrays.asList(allLinks);
        // iterator loop
        System.out.println("#1 iterator");
        Iterator<String> iterator = lList.iterator();*/

//        while (iterator.hasNext()) {
//
//
//            String s = iterator.next();
//            String textXpath = driver.findElement(By.xpath(s)).getText();
//            System.out.println(textXpath);
//            String namePhone = driver.findElement(By.cssSelector(".g-i-tile-i-title.clearfix")).getText();
//            System.out.println(namePhone);
//            String phonePrice = driver.findElement(By.cssSelector(".g-price")).getText();
//            System.out.println(phonePrice);
//            Boolean top = driver.findElements(By.cssSelector(".g-tag.g-tag-icon-middle-popularity.sprite")).size() > 0;
        //String akcija = driver.findElement(By.cssSelector(".g-tag.g-tag-icon-middle-action.sprite")).getText();


//        int i =0;
//        while(i<=31){
//        WebElement namePhone1 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(0);
//        String nameToPrint1 = namePhone1.getText();
//        WebElement pricePhone1 = driver.findElements(By.cssSelector(".g-price-uah")).get(0);
//        String pricePhoneToPrint1 = pricePhone1.getText();
//        System.out.println(nameToPrint1);
//        System.out.println(pricePhoneToPrint1);}

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
    private void selectDropDown(){
        driver.findElement(By.name("drop_link")).click();

    }

    private void selectFromDropDown() {
        driver.findElement(By.name("drop_link")).click();
        driver.findElement(By.linkText("популярные")).click();

    }

    private void navigateToSmartphones() {
        driver.findElement(By.linkText("Телефоны, ТВ и электроника")).click();
        driver.findElement(By.linkText("Телефоны")).click();
        driver.findElement(By.linkText("Смартфоны")).click();
    }

    private void login(String username, String password) {
        driver.findElement(By.linkText("войдите в личный кабинет")).click();
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("auth_submit")).click();
    }
//   public String phoneNameAndPrice1(String name, String price ) {
//       WebElement namePhone1 = driver.findElements(By.cssSelector(".g-i-tile-i-title.clearfix>a")).get(0);
//       String nameToPrint1 = namePhone1.getText();
//       WebElement pricePhone1 = driver.findElements(By.cssSelector(".g-price-uah")).get(0);
//       String pricePhoneToPrint1 = pricePhone1.getText();
//       return namePhone1, pricePhone1;
//
//   }
    //if(driver.findElement(By.cssSelector(".g-tag.g-tag-icon-middle-popularity.sprite"))!=null){
    //driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/div[1]/div[6]/div[1]/div/div/div[2]/div[1]/div/i"))!=null


//            if(){
//                System.out.println("Super");
//            }else{
//                System.out.println("fignja");
//            }
//            System.out.println("--------");
//        }
//
//            i++;// incrementing i value.
//
//
//
//        }
//        for(int i=0; i<=value; i++){
//
//            String s = value.getText();
//            System.out.println(s);
//
//            System.out.println("Value Of Variable i is " +i);
//        }

//            if (top == true) {
//
//                sendToDb(namePhone, phonePrice);
//            }
//            System.out.println(s);
//
//
//        }


    //стринг с первыми 4 вариками
        /*String name1 = driver.findElement(By.linkText("Doogee X5 Max Pro Black")).getText();
        System.out.println(name1);
        String price1 = driver.findElement(By.id("goods_price_block_10489462")).getText();
        System.out.println(price1);

        String name2 = driver.findElement(By.linkText("Meizu M3s 16GB Grey")).getText();
        System.out.println(name2);
        String price2 = driver.findElement(By.id("goods_price_block_10658309")).getText();
        System.out.println(price2);

        String name3 = driver.findElement(By.linkText("Meizu M3 Note 16GB Grey (Международная версия)")).getText();
        System.out.println(name3);
        String price3 = driver.findElement(By.id("goods_price_block_9859672")).getText();
        System.out.println(price3);

        String name4 = driver.findElement(By.linkText("Xiaomi Redmi Note 3 3/32GB Grey")).getText();
        System.out.println(name4);
        String price4 = driver.findElement(By.id("goods_price_block_12384101")).getText();
        System.out.println(price4);*/


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


    //раскоменти!!
//        String st = driver.findElement(By.xpath(".//*[@id='block_with_goods']/div[1]/div[6]/div[1]/div/div/div[2]")).getText();
//        System.out.print(st);
//        st = st.substring(0, 30); // st.length() - 13
////        String[] newSt = st.split(" ");
//        String delims = "[ ]+";
//        String[] items = st.split(delims);
//        //System.out.print(newSt[0]);
//        System.out.println("Name" + " " + items[0]);
//        System.out.println("Model" + " " + items[1]);
//        System.out.println("Memory" + " " + items[2]);
//        System.out.println("Color" + " " + items[3]);
//        System.out.println("Price" + " " + items[4]);
//        //System.out.print(st);


//        List<WebElement> aTagsList = driver.findElements(By.cssSelector(".g-i-tile-l.clearfix"));
//        WebElement requiredElement = aTagsList.get(1);
//        requiredElement.click();
//        wait(5000);


//        List<WebElement> myElements = driver.findElements(By.cssSelector(""));
//        System.out.println("Size of List: "+myElements.size());
//        for(WebElement e : myElements)
//        {
//            String str = e.getAttribute(String.valueOf(By.name("prices_active_element_original")));
//            System.out.print(str);
//            System.out.print("Text within the Anchor tab"+e.getText()+"\t");
//            System.out.println("Anchor: "+e.getAttribute("prices_active_element_original"));
//        }


//        List<WebElement> allElements=driver.findElements(By.cssSelector(".g-i-tile-l.clearfix"));
//
//        for(WebElement ele :allElements) {
//            WebElement top = ele.findElement(By.name("prices_active_element_original"));
//            System.out.println();
//        }

//        List<WebElement> allElements = driver.findElements(By.xpath(".//*[@id='block_with_goods']/div[1]"));
//        int s=allElements.size();
//        for(int i=1;i<=s;i++){
//            allElements = driver.findElements(By.name("prices_active_element_original"));
//            WebElement str = allElements.get(i);
//            System.out.print(str);
//            //allElements.get(i).click();
//        }
//
//        By mySelector = By.xpath(".//*[@id='block_with_goods']/div[1]");
//        List<WebElement> myElements = driver.findElements(mySelector);
//        for(WebElement e : myElements) {
//            System.out.println(e.getText().contains());
//        }

//        List<WebElement> allElements = driver.findElements(By.name("prices_active_element_original"));
//
//        for (WebElement element: allElements) {
//            System.out.println(element.getText());
//        }

//        if (name="prices_active_element_original")
//        {
//            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(timeoutInSeconds));
//            return wait.Until(drv => drv.FindElement(by));
//        }
//        System.out.print(st);
//
//        List<WebElement> list = new List<WebElement> ();
//        String list = driver.findElements(By.xpath(".//*[@id='block_with_goods']/div[1]"));
//        for(WebElement element : list) {
//            System.out.println(element.getText());
//        }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
