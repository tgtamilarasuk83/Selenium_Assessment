package stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demobladedefenitions {
	
	

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	  //  throw new io.cucumber.java.PendingException();
	}

	@When("the user enters valid username as {string}")
	public void the_user_enters_valid_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	   // throw new io.cucumber.java.PendingException();
	}

	@When("When the user enters valid Password as {string}")
	public void when_the_user_enters_valid_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hello");
	    //throw new io.cucumber.java.PendingException();
	}
}
