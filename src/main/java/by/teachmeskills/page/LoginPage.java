package by.teachmeskills.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.id;

public class LoginPage {
    public LoginPage open() {
        Selenide.open("/login");
        getWebDriver().manage().window().maximize();
        return this;
    }
    public ProjectPage  login(){
        $(id("inputEmail")).shouldBe(visible, enabled)
                           .sendKeys("andrei311296@mail.ru");
        $(id("inputPassword")).shouldBe(visible, enabled)
                              .sendKeys("andreianufrik1");
        $(id("btnLogin")).shouldBe(enabled).click();
        return new ProjectPage();
    }

}
