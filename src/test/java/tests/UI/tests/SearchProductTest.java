package tests.UI.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;
import tests.UI.base.Variables;
import tests.UI.pages.SearchProduct;
import tests.UI.pages.components.Header;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SearchProductTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open("https://open.spotify.com/");
        $(byXpath(Variables.acceptCookies)).click(); //
    }

    @Test(groups = {"Regression"})
    public void testSearchProduct() {
        $(byXpath(Header.searchLink)).click();
        $(".CCi1L2OQvgdZvxkRHeKE").shouldHave(text("Browse all"));
        $(byXpath(SearchProduct.searchBar)).setValue("love");
        $("section[aria-label='Songs']").shouldHave(text("love"));
        $("section[aria-label='Songs']").shouldNotHave(text("rrrrrrrrrr"));

        closeWindow();
    }
}



//
//public class SearchProductTest {

//    @Test (groups = {"Regression"})
//    public static void main(String[] args) {
//        BaseUITest.main(args);
//        $(byXpath(Header.searchLink)).click();
//        $(".CCi1L2OQvgdZvxkRHeKE").shouldHave(text("Browse all"));
//        $(byXpath(SearchProduct.searchBar)).setValue("love");
//        $("section[aria-label='Songs']").shouldHave(text("love"));
//        $("section[aria-label='Songs']").shouldNotHave(text("rrrrrrrrrr"));
//
//        closeWindow();
//
//    }
//}
