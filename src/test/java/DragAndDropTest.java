import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void dragAndDropActions(){

        open("https://the-internet.herokuapp.com/drag_and_drop");

        // проверка наличия блоков А и В на своих местах
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));

        //Перемещение блоков блока А и проверка что блоки А и В действительно поменялись местами
        actions().dragAndDrop($("#column-a"),$("#column-b")).perform();
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));

    }
    @Test
    void checkDragAndDropSelenideCommand() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        // проверка наличия блоков А и В на своих местах
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));

        //Перемещение блоков блока А и проверка что блоки А и В действительно поменялись местами
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
    }
}
