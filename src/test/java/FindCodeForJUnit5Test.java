import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindCodeForJUnit5Test {
    @Test
    void findCodeForJUnit5inGithub() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();

        // Проверка наличия страницы SoftAssertions в wiki
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".wiki-rightbar").$$("ul li").shouldHave(itemWithText("SoftAssertions"));

        // проверка наличия кода для JUnit5 на странице SoftAssertions
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
}
