package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class BankDeliveryTest {


    private String generateDate(int i) {
        return LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @BeforeEach
    void setUpTest() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }


    @Test
    void test() {


        $("[class='input__control']").setValue("Магас");
        String planningDate = generateDate(4);
        //$("[value='dd.MM.yyyy']").setValue("dd.MM.yyyy");
        $("[name='name']").setValue("Ирова-Иркина Ирина");
        $("[name='phone']").setValue("+79888888888");
        $x("//span[@class = 'checkbox__text']").click();
        $$x("//span[@class = 'button__text']").last().click();
        $("//*[contains(text(),'Встреча успешно забронирована на')]");
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


    }
}
