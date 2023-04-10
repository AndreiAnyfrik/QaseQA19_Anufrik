package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.ProjectPage;
import by.teachmeskills.page.ProjectSettingsPage;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    @Test
    public void loginAsValidUser() {
        ProjectPage projectPage = new LoginPage().open()
                .login();
        Assertions.assertThat(projectPage.isCreateButtonDisplayed())
                .as("ProjectPage is not displayed")
                .isTrue();
        String expProjectName = "tyk";
        // String expProjecttYPE = "pUBLIC";
        projectPage.open().createNewProject(expProjectName);
        projectPage.open();
 //       List<SelenideElement> allProjectElements = projectPage.getAllProjects();
        List<String> allProjectNames =projectPage.getAllNewProjects();
     //  List<String> allProjectNames = allProjectElements.stream()
      //         .map(SelenideElement::getText)
        assertThat(allProjectNames).as("List does not contains name of new project").contains(expProjectName);
        projectPage.openProject(expProjectName);
        projectPage.openedProjectSettings();
        String actProjectName = new ProjectSettingsPage().getProjectName();
        assertThat(actProjectName).isEqualTo(expProjectName).as("Project Name is not equal");
        // String actProjectType = new ProjectSettingsPage().getProjectType()
        //   assertThat(actProjectType).isEqual(expProjecttYPE).as("");
    }
}
