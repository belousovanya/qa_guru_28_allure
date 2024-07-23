package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideGitHubTest {

    @Test
    void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("span[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys("selenide/selenide");
        $("#query-builder-test").pressEnter();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("#2042")).should(exist);
    }
}
