package by.teachmeskills.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {
    public void signOut() {
      $(By.xpath("//span[@class='Eb2vGG']")).shouldBe(enabled).click();
      $(By.xpath("//span[text()='Sign out']")).shouldBe(enabled).click();
    }
    // id("Logo")


}
