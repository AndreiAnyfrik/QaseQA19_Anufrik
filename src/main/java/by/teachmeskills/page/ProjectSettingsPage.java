package by.teachmeskills.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSettingsPage {
    public final String projectNameLocator ="project-name";
    public final String projectCodeLocator ="project-code";
    public String getProjectName(){
        return $(By.id(projectNameLocator)).getText();
    }
    public boolean isNotEmptyProjectCode(){
       return $(By.id(projectCodeLocator)).isDisplayed();
    }
    public void isPublicProject(){

    }
}
