package ru.rmpts.pages;

import java.time.Duration;
import java.util.List;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.rmpts.ru/")
public class MainPage extends PageObject {
    /*
     * #This selector can be used to search items just form
     * # first block of menu content 'div.menu__items > a[href*="/o-p"],
     * a[href*="/45"], a[href*="/40"]'
     */

    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(20);
    private static final String MINE_PAGE_NEWS_BLOCK_CAPTION = "Новости";
    // Main menu block
    private By menuSandwichButton = By.cssSelector(".header__menu--menu");
    private By menuItems = By.cssSelector("div.menu__items");
    private By menuContent = By.cssSelector("div.menu__content");
    private By menuAllItems = By.cssSelector("a.menu__item");
    private By newsBlockTitle = By.cssSelector("main h2");
    private By itemPageTitle = By.cssSelector("main h1");
    // Search block
    private By searchButton = By.cssSelector(".header__menu--search");
    private By searchField = By.cssSelector("form input");
    private By searchFormButton = By.cssSelector("button");
    private By searchResult = By.cssSelector(".search-result");
    private By searchResultItems = By.cssSelector("a h2");
    private By searchResultMessage = By.cssSelector("main h1");

    public Boolean check_the_main_page_opened() {
        this.open();
        WebElementFacade news_block = find(newsBlockTitle).waitUntilVisible();
        return news_block.getText().matches(MINE_PAGE_NEWS_BLOCK_CAPTION);
    }

    // *************steps for menu test common
    // Open menu
    public void click_menu_sandwich_button() {
        find(menuSandwichButton).waitUntilVisible().click();
    }

    // Get the menu blocks count
    public int get_menu_blocks_count() {

        WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(menuContent);// .waitUntilVisible();
        List<WebElementFacade> items = content.thenFindAll(menuItems);
        /*
         * int i=0;
         * for (WebElementFacade el : items){
         * System.out.println("Block number: " + (i+1));
         * for(WebElementFacade sub_el : el.thenFindAll(menuAllItems)){
         * System.out.println(sub_el.getText()+ " " +sub_el.getAttribute("href"));
         * }
         * i++;
         * }
         */
        return items.size();
    }

    // Catch a glance to menu blocks
    public Boolean get_menu_content() {
        WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(menuContent).waitUntilVisible();
        return content.isDisplayed();
    }

    // *************steps for menu blocks test
    public void select_menu_item(String sIndex) {
        //System.out.println("Expected index is: " + sIndex +"кодировка");
         int index = Integer.parseInt(sIndex) - 1;
       /* System.out.println("Actual item text is: " + withTimeoutOf(TIME_TO_WAIT).find(menuContent).waitUntilVisible()
                .thenFindAll(menuAllItems).get(index).getText()); 
                mvn verify "-Dwebdriver.remote.url=http://localhost:4444/wd/hub" "-Dwebdriver.remote.driver=chrome" "-Dwebdriver.remote.os=WINDOWS"
                */
        withTimeoutOf(TIME_TO_WAIT).find(menuContent).waitUntilVisible().thenFindAll(menuAllItems).get(index).click();
    }

    // Look through the title of opened page
    public String get_item_page_title() {
        return withTimeoutOf(TIME_TO_WAIT).find(itemPageTitle).getText();
    }

    // **************steps for search test
    // Click the search button on main page
    public void click_search_button() {
        withTimeoutOf(TIME_TO_WAIT).find(searchButton).click();
    }

    // Type the text for search in the search field
    public void type_search_text(String text) {
        withTimeoutOf(TIME_TO_WAIT).find(searchField).sendKeys(text);
    }

    // Click the search form button
    public void click_search_form_button() {
        withTimeoutOf(TIME_TO_WAIT).find(searchFormButton).click();
        ;
    }

    // get the search result
    public List<WebElementFacade> get_search_result() {
        return withTimeoutOf(TIME_TO_WAIT).find(searchResult).waitUntilVisible().thenFindAll(searchResultItems);
    }

    // get the search result message
    public String get_search_result_message() {
        return withTimeoutOf(TIME_TO_WAIT).find(searchResultMessage).getText();
    }

}
