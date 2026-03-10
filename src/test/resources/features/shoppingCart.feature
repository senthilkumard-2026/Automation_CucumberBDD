Feature: Add product to cart

Scenario: Add Book to cart and verify total price

Given User navigates into "https://demowebshop.tricentis.com/"
When User selects category "Books"
And User adds product "Computing and Internet" to cart
Then user verifies confirmation message "The product has been added to your shopping cart"
When user navigates into shopping cart
Then user verifies item "Computing and Internet" is present in cart
And User logs total price

