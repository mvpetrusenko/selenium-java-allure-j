package tests.UI.pages;

import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreatePlaylist extends BaseUITest {

    @Test
    public static void main(String[] args) {
        BaseUITest.main(args);
        $(byXpath("//button[@class='IPVjkkhh06nan7aZK7Bx']")).click();
        $(".tippy-content").shouldHave(text("Log in to create and share playlists."));
        $(".tippy-content").shouldNotHave(text("aaaaaaaaa"));

        $(byXpath("//button[normalize-space()='Not now']")).click();


    }
}
