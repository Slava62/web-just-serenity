package ru.rmpts.steps.serenity_tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ru.rmpts.steps.serenity_steps.MainSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@ExtendWith(SerenityJUnit5Extension.class)
public class MainTests {

    public static final String MENU_BLOCKS_NUMBER="7";

    @Steps
    MainSteps userSteps;

    @Managed //(driver = "chrome")//, options = "headless")
    WebDriver driver;
    
    
    @Test
    @DisplayName("When the menu is opened the menu blocks amount is 7")
    //@Pending
    public void userCheckTheMenuBlocksCount() {
        userSteps.open_main_page();
        userSteps.click_menu_sandwich_button();
        userSteps.check_the_menu_is_displayed();
        userSteps.check_the_menu_blocks_count(MENU_BLOCKS_NUMBER);

    }

   
    @ParameterizedTest(name="#{index} - When the item {0} is selected the page {1} has been opened")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void userSelectsTheMenuItem(String item_index, String item_page) {
        userSteps.open_main_page();
        userSteps.click_menu_sandwich_button();
        userSteps.user_selects_the_menu_item(item_index);
        userSteps.check_the_opened_page_caption(item_page);
    }

}
