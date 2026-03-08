Feature: Demo Web Shop Test Functionality

Scenario: Add to cart Test with add any item

Given User can navigate intp demo webshop url
When User selects the category as Books
And User added the cart book as Computing and Internet
Then Verify the confirmation message after addeed to cart
When User navigates into shopping cart
Then Verify the item is present in the shopping cart
And Print the total price shown in the shopping cart

