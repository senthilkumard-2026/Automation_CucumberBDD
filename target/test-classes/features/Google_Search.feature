Feature: Google Search Functionality

@Smoke
Scenario Outline: Google Search Test with multiple data

Given user can able to navigates into google website
When user enters the "<product_name>" details in the search box
Then user can successfully see the product "<Expected_product_result>"

Examples:
|product_name|Expected_product_result|
|Samsung phones|Samsung phones - Google Search|
|Iphone phones|Iphone phones - Google Search|
<<<<<<< HEAD
|Oneplus phones|Oneplus phones - Google Search|
=======
|Oneplus phones|Oneplus phones - Google Search|
|Oneplus phones_sh|Oneplus phones - Google Search|
|Oneplus phones_sh1|Oneplus phones - Google Search|
|Oneplus phones_sh1|Oneplus phones - Google Search|
>>>>>>> 7aa53a5d49d77ee8fd01aa264c624b5b08dc82ee
