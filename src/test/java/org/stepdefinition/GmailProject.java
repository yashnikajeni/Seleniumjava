package org.stepdefinition;

import org.bas.BaseClass;
import org.bas.FbLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailProject extends BaseClass {
	
	FbLoginPojo f;
	
	@Given("User has to launch the browser and maximize the windows")
	public void user_has_to_launch_the_browser_and_maximize_the_windows() {
	  launchbrowser();
	  windowmaximize();
	}

	@When("User has launch the url of the Gmail application")
	public void user_has_launch_the_url_of_the_Gmail_application() {
		launchurl("https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=ASKXGp2vZX-CJje4Ty9u3Luw1uzVnVmxatwQ9ZRwjFvOS0E4xCQfzgfLp17qTddLxiEtGj4MZ5ldtQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1443340318%3A1702211861494275&theme=glif");

	}

	@When("User has to pass the data {string}in Email field")
	public void user_has_to_pass_the_data_in_Email_field(String em) {
	   f=new FbLoginPojo();
	   passtext(em, f.getEmail());
	}

	@When("User has to click the next button")
	public void user_has_to_click_the_next_button() {
		f=new FbLoginPojo();
		clikbtn(f.getNext());
	    
	}

	@When("User has to check whether navigated to password page or not")
	public void user_has_to_check_whether_navigated_to_password_page_or_not() {
	    System.out.println("success");
	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	  closebrowser();
	}




}
