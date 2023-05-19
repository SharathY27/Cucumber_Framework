package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Pending_Timesheets_StepDef {

	@Given("the user is on HomePage")
	public void the_user_is_on_home_page() {
		System.out.println("the user is on HomePage");
	}

	@When("the user clicks on time option from the Menu")
	public void the_user_clicks_on_time_option_from_the_menu() {
		System.out.println("the user clicks on time option from Menu");
	}

	@When("the user enters name as {string}")
	public void the_user_enters_name_as(String string) {
		System.out.println("the user enters name as "+string);
	}

	@When("clicks on the view button")
	public void clicks_on_the_view_button() {
		System.out.println("clicks on the view button");
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String string) {
		System.out.println("the user should see the message as "+string);
	}

}
