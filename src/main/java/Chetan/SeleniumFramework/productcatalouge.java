package Chetan.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.abstractpackage.abstractcomponents;

public class productcatalouge extends abstractcomponents{
	
WebDriver driver;
	
	
	public void productcatalouge (WebDriver driver)
	{ }

	@FindBy(css= ".mb-3")
	List <WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductsList()
	{
		waitforelementtoappear(productsBy);
		return products;
	}
	
}





