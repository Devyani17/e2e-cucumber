package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public static WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//button[text()='NO THANKS ']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		LandingPage.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(NavBar);
	}
	
	public int getPopupSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}

}
