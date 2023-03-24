package tests.UI.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;
import tests.UI.base.Variables;
import tests.UI.pages.SwitchLanguage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SwitchLanguageTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open("https://open.spotify.com/");
        $(byXpath(Variables.acceptCookies)).click();
    }

    @Test (groups = {"Regression"})
    public static void testSwitchLanguage() {
        $(byXpath(SwitchLanguage.changeLanguageButton)).click();
        $(byXpath(SwitchLanguage.ukrLanguageButton)).click();

        $("a[href='/search']").shouldHave(text("Пошук"));
        $("a[href='/search']").shouldNotHave(text("Search"));


        closeWindow();

    }
}



//public class SwitchLanguageTest {
//
//    @Test (groups = {"Regression"})
//    public static void main(String[] args) {
//        BaseUITest.main(args);
//        $(byXpath(SwitchLanguage.changeLanguageButton)).click();
//        $(byXpath(SwitchLanguage.ukrLanguageButton)).click();
//
//        $("a[href='/search']").shouldHave(text("Пошук"));
//        $("a[href='/search']").shouldNotHave(text("Search"));
//
//
//        closeWindow();
//
//    }
//}
