package by.teachmeskills.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProjectPage {
    public ProjectPage open() {
        Selenide.open("/projects");
        getWebDriver().manage().window().maximize();
        return this;
    }

    public ProjectDetailsPage createNewProject(String projectName) {
        $(By.xpath("//span[text()='Create new project']")).click();
        $(By.id("project-name")).shouldBe(visible, enabled).sendKeys(projectName);
        $(By.xpath("//input[@value='public']")).shouldBe(enabled).click();
        $(By.xpath("//span[text()='Create project']")).shouldBe(enabled).click();
        return new ProjectDetailsPage();
    }

    public ProjectDetailsPage openProject(String projectName) {
        $(By.xpath(String.format("//a[text()='%s']", projectName))).click();
        return new ProjectDetailsPage();
    }

    public ProjectPage deleteProject(String projectName) {
        String projectRow = "//a[text()='%s']//ancestor::tr[@class='project-row']//div[@class='dropdown']";
        $(By.xpath(String.format(projectRow, projectName)))
                .shouldBe(enabled)
                .click();
        String deleteButton = "//a[text()='%s']//ancestor::tr[@class='project-row']//button[text()='Delete']";
        $(By.xpath(String.format(deleteButton, projectName)))
                .shouldBe(enabled)
                .click();
        $(By.xpath("//span[text()='Delete project']")).shouldBe(enabled).click();
        return this;
    }
    public ProjectSettingsPage openedProjectSettings() {
        $(By.xpath("//a[@title='Settings']")).shouldBe(enabled).click();
        return new ProjectSettingsPage();
    }

    public boolean isCreateButtonDisplayed() {
        return $(By.id("createButton")).shouldBe(visible).isDisplayed();
    }

    public List<SelenideElement> getAllProjects() {
        return $$(By.xpath("//a[@class='defect-title']"));
    }
    public List<String> getAllNewProjects() {
        return $$(By.xpath("//a[@class='defect-title']")).texts();
    }
}
