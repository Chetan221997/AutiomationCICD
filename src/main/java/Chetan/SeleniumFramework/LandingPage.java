package Chetan.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.abstractpackage.abstractcomponents;

public class LandingPage extends abstractcomponents{

	
	
	WebDriver driver;
	
	
	
	public LandingPage(WebDriver driver)
	{
		
		super(driver);
		//initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	WebElement  userEmails= driver.findElement(By.id("userEmail"));
	
	
	//pagefactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	JKifr	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
}
