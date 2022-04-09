package ru.rmpts.steps.serenity_tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ru.rmpts.steps.serenity_steps.SearchSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SerenityJUnit5Extension.class)
public class SearchTests {

    public static final String  SEARCH_TEXT="История";

    @Managed //(driver = "chrome")//, options = "headless")
    WebDriver driver;

    @Steps
    SearchSteps searchSteps;


    @Test
    @DisplayName("When user search "+SEARCH_TEXT+" the page "+SEARCH_TEXT+" has been found")
    @Pending
    public void user_check_the_second_link() {
        searchSteps.open_main_page();
        searchSteps.click_search_button();
        searchSteps.type_search_text(SEARCH_TEXT);
        searchSteps.click_search_form_button();
        searchSteps.check_the_result_items();
    }

  /*   @Test
    public void user_check_the_message(String message) {
        searchSteps.check_the_text_not_found(message);
    }

    @Test
    public void user_check_the_popup_message(String message) {
       // searchSteps.check_the_text_not_found(message);
    }
 */
}
