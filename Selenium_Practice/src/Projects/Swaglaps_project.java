package Projects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Swaglaps_project {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String url = "https://www.saucedemo.com/v1/";
		driver.get(url);

		// user login			
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");

		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		
		// add the product to the cart section
		WebElement addcart1 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
		addcart1.click();

		WebElement addcart2 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
		addcart2.click();


		// check the cart section

		WebElement cartlist = driver.findElement(By.id("shopping_cart_container"));
		cartlist.click();


		// checkout the product
		JavascriptExecutor java = (JavascriptExecutor) driver;
		WebElement checkoutbutton = driver.findElement((By.xpath("//a[@href=\"./checkout-step-one.html\"]")));
		java.executeScript("arguments[0].scrollIntoView();", checkoutbutton);
		checkoutbutton.click();


		// checkout info
		WebElement firstname = driver.findElement(By.id("first-name"));
		firstname.sendKeys("vijay");

		WebElement lastname = driver.findElement(By.id("last-name"));
		lastname.sendKeys("kumar");

		WebElement zipcode = driver.findElement(By.id("postal-code"));
		zipcode.sendKeys("625671");

		// continue option
		WebElement continuebutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		continuebutton.click();

		// checkout summary of the product details and price)
		WebElement summaryinfo=driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]"));
		String info=summaryinfo.getText();
		System.out.println(info);
		
		// finish the action
		WebElement finishbutton = driver.findElement(By.xpath("//a[@href=\"./checkout-complete.html\"]"));
		java.executeScript("arguments[0].scrollIntoView();", finishbutton);
		finishbutton.click();

		// get the feedback to successful ordered
		WebElement ordered = driver.findElement(By.className("complete-header"));
		String text = ordered.getText();
		System.out.println(text);



	}

}