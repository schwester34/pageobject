package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import java.io.File;

public class RegistrationFormWithPageObjects {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1250";
    }

    @Test
    void fillFormTest() {

        File file = new File("src/test/resources/hdr009.jpg");

        registrationPage.openPage()
                .setFirstName("Marina")
                .setLastName("Romanova")
                .setEmail("mari@rom.eu")
                .setGender("Female")
                .setPhone("1232020327")
                .setDateOfBirth("February", "1999", "28")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadFile(file)
                .setCurrentAddress("Lenina 55")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit();

        registrationPage.checkFormOpened()
                .checkResult("Student Name", "Marina Romanova")
                .checkResult("Student Email", "mari@rom.eu")
                .checkResult("Gender", "Female");

    }
}
