package test;

import core.BaseTest;
import helpers.TestValues;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MailTest extends BaseTest {

    @Test
    public void sendMessageTest() {
        new MainPage(TestValues.url)
                .clickLogin()
                .authInToMail(TestValues.email, TestValues.password)
                .clickNewMessage()
                .sendMessage(TestValues.recipient, TestValues.theme, TestValues.body);
    }
}
