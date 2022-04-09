package ru.rmpts.steps.serenity_steps;

import ru.rmpts.pages.MainPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import java.util.List;
import org.assertj.core.api.Assertions;

public class SearchSteps extends UIInteractionSteps{

    private static final String HISTORY="История";
    private MainPage mainPage;

    @Step("user navigates to main page")
    public void open_main_page() {
      Assertions.assertThat(mainPage.check_the_main_page_opened()).isTrue();
    }

    @Step("user clicks search button")
    public void click_search_button() {
        mainPage.click_search_button();
    }

    @Step("the user types {0} in a search field")
    public void type_search_text(String text) {
        mainPage.type_search_text(text);
    }

    @Step("the user presses the search button")
    public void click_search_form_button() {
        mainPage.click_search_form_button();
    }

    @Step("the user should see the message {string}")
    public void check_the_result_items() {
        List<WebElementFacade> search_result = mainPage.get_search_result();
        search_result.get(1).click();
        Assertions.assertThat(mainPage.get_item_page_title()).isEqualTo(HISTORY);
    }

    @Step("the user should see the popup {string}")
    public void check_the_text_not_found(String message) {
        Assertions.assertThat(mainPage.get_search_result_message()).isEqualTo(message);
    }

}
