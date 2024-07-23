package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.withText;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsGitHubTest {

    private static final String REPOSITORY = "selenide/selenide";
    private static final int ISSUE = 2042;

    @Test
    public void lambdaIssueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
        $("span[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
            });
        step("Проверяем наличие Issue с номером ", () -> {
            $(withText("#" + ISSUE)).should(exist);
            });
    }

    @Test
    public void annotatedIssueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsGithubTest steps = new WebStepsGithubTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}