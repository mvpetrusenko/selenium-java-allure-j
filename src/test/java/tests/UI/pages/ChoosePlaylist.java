package tests.UI.pages;


import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ChoosePlaylist extends BaseUITest {


    @Test
    public static void main(String[] args) {
        BaseUITest.main(args);
        $(byXpath("//section[@aria-label='Focus']//div[1]//div[1]//div[3]")).click();
        $(byXpath("//button[@class='Fm7C3gdh5Lsc9qSXrQwO']//*[name()='svg']")).click();

        $(".tippy-content").shouldHave(text("Log in to create and share playlists."));
        $(".tippy-content").shouldNotHave(text("aaaaaaaaa"));

    }
}

