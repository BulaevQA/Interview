package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage {

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement buttonNewMessage;

    @FindBy(xpath = "//div[@class='head_container--3W05z']//input")
    private WebElement recipientTopic;

    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement messageThemeTopic;

    @FindBy(xpath = "//div[@role ='textbox']")
    private WebElement messageBodyTopic;

    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement buttonSendMessage;

    public MailPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Клик \"Написать письмо\"")
    public MailPage clickNewMessage() {
        buttonNewMessage.click();
        return this;
    }

    @Step("Заполняем и отправляем письмо")
    public MailPage sendMessage(String recipient, String theme, String body) {
        recipientTopic.sendKeys(recipient);
        messageThemeTopic.sendKeys(theme);
        messageBodyTopic.sendKeys(body);
        buttonSendMessage.click();
        return this;
    }
}
