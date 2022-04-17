package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    SelenideElement firstNameInput = $("#firstName");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage setPhone(String number) {
        $("#userNumber").setValue(number);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText("Sports")).click();

        return this;
    }

    public RegistrationPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage checkFormOpened() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
