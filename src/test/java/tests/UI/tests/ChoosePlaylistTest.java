package tests.UI.tests;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.UI.base.Variables;
import tests.UI.pages.ChoosePlaylist;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class ChoosePlaylistTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open("https://open.spotify.com/");
        $(byXpath(Variables.acceptCookies)).click();
    }


    @Test (groups = {"Regression"})
    public static void testChoosePlaylist() {

        $(byXpath(ChoosePlaylist.playlistIcon)).click();
        $(byXpath(ChoosePlaylist.heartLike)).click();

        $(".tippy-content").shouldHave(text("Log in to create and share playlists."));
        $(".tippy-content").shouldNotHave(text("aaaaaaaaa"));

        closeWindow();

    }
}