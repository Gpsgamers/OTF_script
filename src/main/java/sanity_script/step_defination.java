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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}
	
	@When("come back to online in login page")
	public void come_back_to_online_in_login_page() {
		online();
	}

	@Then("Connected toast should be displayed in login page")
	public void connected_toast_should_be_displayed_in_login_page() {
		String content = "Connected";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		String content = "Login success";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertTrue(driver.getCurrentUrl().equals("https://onthefly-qa.contus.us/broadcast"), "invalid URL");
	}
	//
	@Given("Navigate to the stream page")
	public void navigate_to_the_stream_page() {
//		driver.get(url+"broadcast");
	}

	@When("Goes to offline in stream page")
	public void goes_to_offline_in_stream_page() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(stream_menu));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		offline();
	}

	@Then("You are currently offline toast is displayed in stream page")
	public void you_are_currently_offline_toast_is_displayed_in_stream_page() {
		String content = "You are currently offline";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}

	@When("click on the create stream button")
	public void click_on_the_create_stream_button() {
		driver.findElement(create_stream_btn(1)).click();
	}

	@When("click on the create Record video button")
	public void click_on_the_create_record_video_button() {
		driver.findElement(record_Video_btn).click();
	}

	@Then("Please check your internet connection toast is displayed in stream page")
	public void please_check_your_internet_connection_toast_is_displayed_in_stream_page() {
		String content = "Please check your internet connection";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
	}

	@When("click on the Schedule Webinar video button")
	public void click_on_the_schedule_webinar_video_button() {
		driver.findElement(schedule_Webinar_btn).click();
		
	}

	@When("click on the upcoming tab in stream page")
	public void click_on_the_upcoming_tab_in_stream_page() {
		driver.findElement(upcomming_Tab).click();
	}

	@When("click on the Past tab in stream page")
	public void click_on_the_past_tab_in_stream_page() {
		driver.findElement(past_Tab).click();
	}

	@When("try to search on the search")
	public void try_to_search_on_the_search() {
		driver.findElement(searchField).sendKeys("s");
	}

	@Then("loader is displayed in stream page")
	public void loader_is_displayed_in_stream_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		Assert.assertTrue(element.isDisplayed(),"Loader is not displayed");
	}

	@When("connect back to online")
	public void connect_back_to_online() {
		online();
	}

	@Then("Connected toast is displayed in stream page")
	public void connected_toast_is_displayed_in_stream_page() {
		String content = "Connected";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(content)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(content)));
		driver.navigate().refresh();
	}
	
	
	@When("click on the destination menu")
	public void click_on_the_destination_menu() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page is navigating to the destination page from the stream page")
	public void page_is_navigating_to_the_destination_page_from_the_stream_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Goes to offline in destination")
	public void goes_to_offline_in_destination() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("You are currently offline toast is displayed in destination page")
	public void you_are_currently_offline_toast_is_displayed_in_destination_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online in destination page")
	public void connect_back_to_online_in_destination_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed is destination page")
	public void connected_toast_is_displayed_is_destination_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the library menu from destination page")
	public void click_on_the_library_menu_from_destination_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page is navigating to the destination page")
	public void page_is_navigating_to_the_destination_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Goes to offline in library page")
	public void goes_to_offline_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("show stopper Ui is displayed in library page")
	public void show_stopper_ui_is_displayed_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("You are currently offline toast is displayed in library page")
	public void you_are_currently_offline_toast_is_displayed_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the try again button from the show stopper Ui in library page")
	public void click_on_the_try_again_button_from_the_show_stopper_ui_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("show stopper Ui should not removed in library page")
	public void show_stopper_ui_should_not_removed_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online in library page")
	public void connect_back_to_online_in_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed is library page")
	public void connected_toast_is_displayed_is_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("show stopper Ui should be removed from the library page")
	public void show_stopper_ui_should_be_removed_from_the_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the member menu from library page")
	public void click_on_the_member_menu_from_library_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page is navigating to the members page")
	public void page_is_navigating_to_the_members_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Goes to offline in members page")
	public void goes_to_offline_in_members_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online in members page")
	public void connect_back_to_online_in_members_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed is members page")
	public void connected_toast_is_displayed_is_members_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Navigate to pre-preview screen")
	public void navigate_to_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Goes to offline in pre-preview screen")
	public void goes_to_offline_in_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("You are currently offline is displayed in pre-preview screen")
	public void you_are_currently_offline_is_displayed_in_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Click on the Enter stream button")
	public void click_on_the_enter_stream_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Enter stream button should not be clickable")
	public void enter_stream_button_should_not_be_clickable() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page is not navigating to the studio page")
	public void page_is_not_navigating_to_the_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online in pre-preview screen")
	public void connect_back_to_online_in_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed in pre-preview screen")
	public void connected_toast_is_displayed_in_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page is navigating to the studio page")
	public void page_is_navigating_to_the_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Goes to offline in studio page")
	public void goes_to_offline_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("show stopper Ui is displayed in studio page")
	public void show_stopper_ui_is_displayed_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("You are currently offline toast is displayed in studio page")
	public void you_are_currently_offline_toast_is_displayed_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on the try again button from the show stopper Ui in studio page")
	public void click_on_the_try_again_button_from_the_show_stopper_ui_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("show stopper Ui should not removed in studio page")
	public void show_stopper_ui_should_not_removed_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("connect back to online in studio page")
	public void connect_back_to_online_in_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Connected toast is displayed is studio page")
	public void connected_toast_is_displayed_is_studio_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page should be navigating to the pre-preview screen")
	public void page_should_be_navigating_to_the_pre_preview_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

}
