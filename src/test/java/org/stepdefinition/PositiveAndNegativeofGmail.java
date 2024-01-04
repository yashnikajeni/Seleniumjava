package org.stepdefinition;

import org.bas.BaseClass;
import org.bas.FbLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveAndNegativeofGmail extends BaseClass{
	FbLoginPojo f;
	@Given("To launch the browser and maximize the window")
	public void to_launch_the_browser_and_maximize_the_window() {
	   launchbrowser();
	   windowmaximize();
	}

	@When("To launch the url of Gmail application")
	public void to_launch_the_url_of_Gmail_application() {
		launchurl("https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=ASKXGp2vZX-CJje4Ty9u3Luw1uzVnVmxatwQ9ZRwjFvOS0E4xCQfzgfLp17qTddLxiEtGj4MZ5ldtQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1443340318%3A1702211861494275&theme=glif");
	    
	}

	@When("To pass the valid username in email field")
	public void to_pass_the_valid_username_in_email_field() {
		f=new FbLoginPojo();
		passtext("arokya@gmail.com", f.getEmail());
	}

	@When("To click the next button")
	public void to_click_the_next_button() {
		f=new FbLoginPojo();
		clikbtn(f.getNext());
	    
	}

	@When("To check whether navigated to password field or not")
	public void to_check_whether_navigated_to_password_field_or_not() {
		System.out.println("success");
	    
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closebrowser();
		
	}




}
