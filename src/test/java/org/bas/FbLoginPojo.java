package org.bas;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo extends BaseClass{
	
	public FbLoginPojo() {
		PageFactory.initElements(driver, this);
		
		}	
			
			
			@FindBy(id = "identifierId")
			private WebElement email;
			
			@FindBy(xpath = "//span[text()=\"Next\"]")
			private WebElement next;

			public WebElement getEmail() {
				return email;
			}

			public WebElement getNext() {
				return next;
			}
		
		
		

	
	
	
	
		
		
		


}
