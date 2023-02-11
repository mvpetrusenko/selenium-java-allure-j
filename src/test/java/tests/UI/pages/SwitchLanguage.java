package tests.UI.pages;

import org.testng.annotations.Test;
import tests.UI.base.BaseUITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SwitchLanguage extends BaseUITest {


    @Test
    public static void main(String[] args) {
        BaseUITest.main(args);
        $(byXpath("//button[@class='Button-sc-y0gtbx-0 eeRweB']")).click();
        $(byXpath("//button[@id='uk']")).click();

        $("a[href='/search']").shouldHave(text("Пошук"));
        $("a[href='/search']").shouldNotHave(text("Search"));

    }
}
