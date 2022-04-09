Feature: Search

   @search_ex
   Scenario: Search for existing text
       Given user navigates to main page 
       When user clicks search button
       And the user types "История" in a search field
       And the user presses the search button
       Then the second link follows to history block

   @search_no
   Scenario: Search for no existig text
       Given user navigates to main page 
       When user clicks search button
       And the user types "Not existing text" in a search field
       And the user presses the search button
       Then the user should see the message "Найдено 0 результатов."

   @search_em
   @use
   Scenario: Search with empty search field
       Given user navigates to main page 
       When user clicks search button
       And the user presses the search button
       Then the user should see the popup "Заполните это поле." 