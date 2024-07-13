package Chetan.SeleniumFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Frameworkpart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//after clicking on cart button in last step, here we add string to 
		//check whether added product is displayed in cart or not 
		
		String ProductName= "ZARA COAT 3";
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		
		LandingPage landingpage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("itschetu123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Chetan@1997");
		driver.findElement(By.id("login")).click();
		
		// on click login button may take to time load the products so 
		//until products loading we put expilict wait here
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//from here on we inspected the products
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		// for "product added  to cart" toast message is displayed for few seconds
		//so wait for that toast we adding implicit wait
		
		//WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//"Loading icon" is displayed so we are writing this code until loading icon is gone we can't
		// click on cart button 
		// Loading icon is fast so we can't inspect, so we are writing direct code of the icon
		
		//"ng-animating" - this is the css when we got after inspecting the loading icon
		
		//wait1.until(ExpectedConditions.invisibilityOfElementLocated
				//(By.cssSelector(".ng.animating"))); "here we can use this implicit or
		//we can use another which is below , if we use this performance is slow, so to perform
		//speed we used below one"
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		
		//now click on cart inspect
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//getting products name in cart list
		
	List<WebElement> cartproducts= driver.findElements(By.cssSelector(".cartSection h3"));
		
		
	Boolean match=	cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(ProductName));
	
	Assert.assertTrue(match);
		
		//click on "check out"button
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	
	Actions a= new Actions(driver);
	
	//clicking on my country field
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	
	//selecting india option
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	
	
	//place order button
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	//"thankyou for the order" text grabing
	
	String confirmMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	driver.close();
	
	
	
	
	
	
	
	}
	

}
