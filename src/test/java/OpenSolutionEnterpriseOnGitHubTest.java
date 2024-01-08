import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenSolutionEnterpriseOnGitHubTest {

    @Test
    void openSolutionEnterpriseOnGitHub() {

        open("https://github.com/");
        $(".header-menu-wrapper").$(withText("Solutions")).hover();
        $(".header-menu-wrapper").$(withText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldBe(visible);
    }
}
