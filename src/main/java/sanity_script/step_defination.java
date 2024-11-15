package sanity_script;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class step_defination extends method {
	public static WebDriverWait wait;
	
	@Given("Navigate to login the page")
	public void navigate_to_login_the_page() {
		driver.get(url);
	}

	@When("go to offline in login page")
	public void go_to_offline_in_login_page() throws InterruptedException {
		offline();
	}
	@Then("You are currently offline toast should be displayed")
	public void you_are_currently_offline_toast_should_be_displayed() {
		String content = "You are currently offline";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast("You are currently offline")));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content))); 
	}

	@Given("Navigate to login page")
	public void navigate_to_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains(url),"not in login page");
	}

	@When("click on the signin btn in offline")
	public void click_on_the_signin_btn_in_offline() throws InterruptedException {
		driver.findElement(sign_in).click();
	}
	
	@Then("Please check your internet connection toast should be displayed")
	public void please_check_your_internet_connection_toast_should_be_displayed() {
		String content = "Please check your internet connection";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}
	
	@When("come back to online in login page")
	public void come_back_to_online_in_login_page() {
		online();
	}

	@Then("Connected toast should be displayed")
	public void connected_toast_should_be_displayed() {
		String content = "Connected";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}
	
	@When("Enter the username and password and click on the login the button.")
	public void enter_the_username_and_password_and_click_on_the_login_the_button() throws InterruptedException {
		login(Owner, Owner_password);
	}
	
	@Then("If login success page should be navigating to the stream page.")
	public void if_login_success_page_should_be_navigating_to_the_stream_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		Assert.assertTrue(driver.getCurrentUrl().equals("https://onthefly-qa.contus.us/broadcast"), "invalid URL");
	}
	//
	@Given("Navigate to the stream page")
	public void navigate_to_the_stream_page() {
		driver.get(url+"broadcast");
	}

	@When("Goes to offline in stream page")
	public void goes_to_offline_in_stream_page() throws InterruptedException {
		offline();
	}

	@Then("You are currently offline toast is displayed in stream page")
	public void you_are_currently_offline_toast_is_displayed_in_stream_page() {
		String content = "You are currently offline";
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}

	@When("click on the create stream button")
	public void click_on_the_create_stream_button() {
	}

	@When("click on the create Record video button")
	public void click_on_the_create_record_video_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Please check your internet connection toast is displayed")
	public void please_check_your_internet_connection_toast_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the Schedule Webinar video button")
	public void click_on_the_schedule_webinar_video_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Please check your internet connection toast is displayed in stream page")
	public void please_check_your_internet_connection_toast_is_displayed_in_stream_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the upcoming tab in stream page")
	public void click_on_the_upcoming_tab_in_stream_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the Past tab in stream page")
	public void click_on_the_past_tab_in_stream_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("try to search on the search")
	public void try_to_search_on_the_search() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("loader is displayed in stream page")
	public void loader_is_displayed_in_stream_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online")
	public void connect_back_to_online() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed")
	public void connected_toast_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	

}
