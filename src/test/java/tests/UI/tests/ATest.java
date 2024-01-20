package tests.UI.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ATest {

    //@BeforeMethod(alwaysRun = true)

    @Test(groups = {"Regression"})
    public void setUp() {

        //ChromeOptions options = new ChromeOptions();

        //options.addArguments("--remote-allow-origins=*");

        //options.addArguments("C:\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver(options);



        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/news");



        //driver.get("https://www.google.com");
        //driver.manage().window().maximize();


        //C:\Users\Маша\AppData\Roaming\JetBrains\IdeaIC2023.2\chrome-user-data

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //System.setProperty("webdriver.chrome.logfile", "C:\\chromedriver-win64\\chromedriver.exe.log");
        //System.setProperty("webdriver.chrome.verboseLogging", "true");

        // Создайте объект ChromeOptions
        //ChromeOptions options = new ChromeOptions ();

// Добавьте строку, чтобы отключить расширение автоматизации
        //options.setExperimentalOption("useAutomationExtension", false);

// Добавьте строку, чтобы отключить графический процессор
        //options.addArguments("--disable-gpu");

// Передайте объект options в конструктор ChromeDriver
        //ChromeDriver driver = new ChromeDriver(options);






        //WebDriverRunner.setWebDriver(driver);
        //WebDriverRunner.getWebDriver().manage().window().maximize();
        //open("https://open.spotify.com/");
        //$(byXpath(Variables.acceptCookies)).click(); //
    }
}