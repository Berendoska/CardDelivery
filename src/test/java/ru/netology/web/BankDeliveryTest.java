package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
//import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BankDeliveryTest {


    @Test
    void test() {
        open("http://localhost:9999");
        $("[class='input__control']").setValue("Магас");
        $("[value='04.11.2022']").setValue("04.11.2022");
       // $("[.//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span/span/span/span[1]/input']");
        //while (By.xpath())
        $("[name='name']").setValue("Ирова-Иркина Ирина");
        $("[name='phone']").setValue("+79888888888");
        $x("//span[@class = 'checkbox__text']").click();
        $$x("//span[@class = 'button__text']").last().click();
        $("//*[contains(text(),'Встреча успешно забронирована на')]");




    }
}
