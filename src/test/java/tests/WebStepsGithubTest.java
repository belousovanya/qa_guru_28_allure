package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsGithubTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("span[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();

    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();

    }

    @Step("Проверяем наличие Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(int issueNumber) {
        $(withText("#" + issueNumber)).should(exist);
    }
}
