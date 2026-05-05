Feature: Category of the product  

   Background:
	  Given User is in the dashboard page .
      When  he click on the Cart  .
      And click on the Place order
 	
  @Login
  Scenario: Tamilarasu 4-4-26 User can acess the Product category to acces the product categories 
   
  
  Then he give the valid details<Name>, <Country> , <City> ,<Credit_Number> , <Month> , <Year>.
  And Click on the purchase.
    