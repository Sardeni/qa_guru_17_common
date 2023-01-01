package com.sardeni;


import org.junit.jupiter.api.Test;

public class StudentRegistrationFormPageObjects extends TestBase {
    @Test
    void studentRegistrationFormTest() {
        String name = "Pavel";
        String lastName = "Emelianov";
        String email = "pavel@gmail.com";
        String phoneNumber = "1234567891";
        String currentAddress = "Tbilsi, 16 Metekhi Street";
        String gender = "Male";
        String dateOfBirth = "5 May,1987";
        String subject = "Computer Science";
        String hobbies = "Sports, Reading";
        String pictureFIleName = "brad_pitt.png";
        String pictureSource = "images/brad_pitt.png";
        String stateAndCity = "NCR Noida";

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserPhoneNumber(phoneNumber)
                .setBirthDate("05", "May", "1987")
                .setSubject(subject)
                .setHobbie("Sports")
                .setHobbie("Reading")
                .uploadPhoto(pictureSource)
                .setAddress(currentAddress)
                .selectState("NCR")
                .selectCity("Noida")
                .clickSubmitButton();

        registrationPage.verifyResultsModalAppears();
        registrationPage
                .verifyResult("Student Name", name + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Address", currentAddress)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", pictureFIleName)
                .verifyResult("State and City", stateAndCity);
    }
}
