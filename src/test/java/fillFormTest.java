import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class fillFormTest {

    @Test
     void fillForm() {
        // Открыть браузер на заданной странице
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");  // Открытие браузера на нужной странице
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()");  // Скрытие футера
        //Configuration.holdBrowserOpen = true; // Чтобы браузер не закрывался после выполенения теста

        // Поиск полей и заполнение полей формы значениями
        $("[id=firstName]").setValue("TestFirstName");  //Указываем значение поля FirstName
        $("[id=lastName]").setValue("TestLastName");  //Указываем значение поля LastName
        $("[id=userEmail]").setValue("TestUserEmail@email.ru");  //Указываем значение поля userEmail
        $(".custom-control-label").click();  //Указываем значение радио-кнопки указание пола: Male
        $("[id=userNumber]").setValue("9990001122");  //Указываем значение поля userNumber
        $("[id=dateOfBirthInput]").click();  //Указываем дату рождения: нажатие на поле ввода даты
        $(".react-datepicker__month-select").selectOption("June");  //Указываем дату рождения: выбор месяца рождения
        $(".react-datepicker__year-select").selectOption("1978");   //Указываем дату рождения: выбор года рождения
        $(".react-datepicker__day--025").click(); //Указываем дату рождения: выбор дня месяца рождения
        $("[id=subjectsInput]").setValue("a").sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);  //Указываем значение поля Subjects: в поле укзаываем "a" и выбираем третье значение по списку^ Arts
        $("label[for='hobbies-checkbox-1']").click(); // Выбираем значение чек-бокса Sports
        $("label[for='hobbies-checkbox-2']").click(); // Выбираем значение чек-бокса Reading
        $("label[for='hobbies-checkbox-3']").click(); // Выбираем значение чек-бокса Music
        $("[id=uploadPicture]").uploadFromClasspath("01.jpg"); // Выбираем файл для загрузки
        $("[id=currentAddress]").setValue("112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1");  //Указываем значение поля Current Address
        $("[id=react-select-3-input]").setValue("NCR").sendKeys(Keys.ENTER); //Указываем название штата: NCR
        $("[id=react-select-4-input]").setValue("Delhi").sendKeys(Keys.ENTER); //Указываем название города: Delhi
        $("[id=submit").click(); // Нажатие на кнопку Submit


        //Проверка правильности сохранения заполненных полей
        $(".modal-open").shouldBe(visible);  // проверка открытия модального окна
        $(".table").shouldHave(text("TestFirstName TestLastName"));  // Проверка Имени и Фамилии
        $(".table").shouldHave(text("TestUserEmail@email.ru"));  // Проверка электронного адреса
        $(".table").shouldHave(text("9990001122"));  // Проверка номера телефона
        $(".table").shouldHave(text("25 June,1978"));  // Проверка даты рождения
        $(".table").shouldHave(text("Arts"));  // Проверка предмета
        $(".table").shouldHave(text("Sports, Reading, Music"));  // Проверка хобби
        $(".table").shouldHave(text("01.jpg"));  // Проверка загруженного файла
        $(".table").shouldHave(text("112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1"));  // Проверка введенного адреса
        $(".table").shouldHave(text("NCR Delhi"));  // Проверка штата и города
    }
}

