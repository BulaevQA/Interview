package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement buttonLogIn;

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement modalIframe;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement nextForm;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement buttonAuth;

    public MainPage(String url) {
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    @Step("Клик на кнопку \"Войти\"")
    public MainPage clickLogin() {
        buttonLogIn.click();
        return this;
    }

    @Step("Заполнение формы логин/пароль")
    public MailPage authInToMail(String login, String password) {
        driver.switchTo().frame(modalIframe);
        fieldLogin.sendKeys(login);
        nextForm.click();
        fieldPassword.sendKeys(password);
        buttonAuth.click();
        driver.switchTo().defaultContent();
        return new MailPage();
    }
}
