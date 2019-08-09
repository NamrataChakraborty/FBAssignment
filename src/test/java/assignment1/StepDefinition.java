/**
 * 
 */
package assignment1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

/**
 * @author namra
 *
 */
public class StepDefinition {

	private WebDriver driver = null;

	@After
	public void closeBrowser() {
		driver.quit();
	}

	@Given("^User opens the browser$")
	public void User_opens_the_browser() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@When("^User navigates to Facebook$")
	public void User_navigates_to_Facebook() {
		driver.get("https://www.facebook.com/");
		Assert.assertTrue("Validate Facebook login page", driver.getTitle().equals("Facebook – log in or sign up"));
	}

	@Then("^User should be able to login using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void User_should_be_able_to_login_using_Username_and_Password(String username, String password) {
		try {
			WebElement userNameField = driver.findElement(By.xpath("//*[@id='email']"));
			userNameField.sendKeys(username);
			userNameField.sendKeys(Keys.TAB);

			WebElement passwordField = driver.findElement(By.xpath("//*[@id='pass']"));
			passwordField.sendKeys(password);

			WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginbutton']"));
			loginButton.click();

			Thread.sleep(5000);

			// Navigate to user profile page and validate the URL contains the
			// user name
			WebElement profileLink = driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"));
			profileLink.click();
			Thread.sleep(10000);

			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue("Validate User is on his profile page", currentUrl.contains(username));

			// Navigate back to home page
			WebElement homePage = driver.findElement(By.xpath("//*[@id='u_0_c']/a"));
			homePage.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^User should be able to post a status message as \"([^\"]*)\"$")
	public void User_should_be_able_to_post_a_status_message_as(String message) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 500);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//textarea[contains(@title,'Write something here...')]")));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//textarea[contains(@title,'Write something here...')]")));
			driver.findElement(By.xpath("//textarea[contains(@title,'Write something here...')]")).click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@contenteditable='true']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']")));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys(message);

			WebElement postButton = driver.findElement(By.xpath("//span[text()='Post']"));
			postButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
