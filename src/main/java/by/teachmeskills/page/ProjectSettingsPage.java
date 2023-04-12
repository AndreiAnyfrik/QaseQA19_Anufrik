package by.teachmeskills.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSettingsPage {
    public By projectNameLocator =By.id("project-name");
    public By projectCodeLocator =By.id("project-code");
    public String getProjectName(){
        $(By.xpath("//span[text()='Archive project']")).shouldBe(Condition.visible);
        return $(projectNameLocator).shouldBe(Condition.visible).getText();
    }
    public boolean isNotEmptyProjectCode(){
       return $(projectCodeLocator).shouldBe(Condition.visible).isDisplayed();
    }
    public boolean isPublicProject(){
       return Selenide.$x("//input[@value='public']").isSelected();
    }
}
