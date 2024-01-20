package tests.UI.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class BTest {

    WebDriver driver;

    @BeforeTest(groups = {"Regression"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = {"Regression"})
    public void testBBCNews() {
        driver.get("https://www.bbc.com/news");
        // add your assertions here
    }

    //@AfterTest(groups = {"Regression"})
    //public void tearDown() {
        //driver.quit();
   // }
}

