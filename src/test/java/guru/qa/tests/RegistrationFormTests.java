package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1250";
    }

    @Test
    void fillFormTest() {
        String name = "Marina";
        String last_name = "Romanova";
        String email = "mari@rom.eu";
        String mobileNumber = "1232020327";
        String subject = "English";
        String currentAddress = "Lenina 55";
        File file = new File("src/test/resources/hdr009.jpg");

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue(name);
        $("#lastName").setValue(last_name);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Marina"), text("Romanova"), text("mari@rom.eu"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Marina Romanova"));

    }
}
