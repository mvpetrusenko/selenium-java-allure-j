package tests.UI.pages;

import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class SearchProduct extends BaseUITest {

    @Test
    public static void main(String[] args) {
        BaseUITest.main(args);
        $(byXpath("//a[@href='/search']")).click();
        $(".CCi1L2OQvgdZvxkRHeKE").shouldHave(text("Browse all"));
        $(byXpath("//input[@placeholder='What do you want to listen to?']")).setValue("love");
        $("section[aria-label='Songs']").shouldHave(text("love"));
        $("section[aria-label='Songs']").shouldNotHave(text("rrrrrrrrrr"));

    }
}




