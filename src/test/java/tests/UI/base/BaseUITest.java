package tests.UI.base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;



public class BaseUITest {

    public BaseUITest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open("https://open.spotify.com/");
        $(byXpath(Variables.acceptCookies)).click();
    }

}

// //

//public class BaseUITest {
//
//
//    @BeforeMethod(alwaysRun = true)
//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//
//        WebDriverRunner.setWebDriver(driver);
//        WebDriverRunner.getWebDriver().manage().window().maximize();
//        open("https://open.spotify.com/");
//        $(byXpath(Variables.acceptCookies)).click();
//
//
//    }
//
//}
//
