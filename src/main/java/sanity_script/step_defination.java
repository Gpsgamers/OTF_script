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

	@Given("Navigate to the login page")
	public void navigate_to_the_login_page() {
		driver.get(url);
	}

	@When("Goes to offline")
	public void goes_to_offline() {
		offline();
	}

	@Then("single {string} toast is displayed")
	public void single_toast_is_displayed(String string) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Toast(string)));
		Assert.assertTrue(element.isDisplayed(), "Toast displayed worngly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Toast(string)));
	}

	@When("click on the singin button without filling the email and password")
	public void click_on_the_singin_button_without_filling_the_email_and_password() {
		driver.findElement(sign_in).click();
		
	}

	@When("fill with invalid emailID and password click on the signin button")
	public void fill_with_invalid_email_id_and_password_click_on_the_signin_button() throws InterruptedException {
		login("udwahiu@d.com", "Wedadawdwa");
		driver.findElement(emailfield).clear();
		driver.findElement(password).clear();
	}

	@When("connect back to online")
	public void connect_back_to_online() throws InterruptedException {
		online();
	}

	@When("Enter the username and password and click on the login the button.")
	public void enter_the_username_and_password_and_click_on_the_login_the_button() throws InterruptedException {
		login(Owner, Owner_password);
	}

	@Then("If login success page should be navigating to the stream page.")
	public void if_login_success_page_should_be_navigating_to_the_stream_page() {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://onthefly-qa.contus.us/broadcast"), "invalid URL");
	}

	@Given("Navigate to the stream page")
	public void navigate_to_the_stream_page() {
		driver.get("https://onthefly-qa.contus.us/broadcast");
		wait.until(ExpectedConditions.visibilityOfElementLocated(stream_menu));
	}

	@When("click on the create stream button")
	public void click_on_the_create_stream_button() {
		driver.findElement(create_stream_btn(1)).click();
	}

	@When("click on the create Record video button")
	public void click_on_the_create_record_video_button() {
		driver.findElement(record_Video_btn).click();
	}

	@When("click on the Schedule Webinar video button")
	public void click_on_the_schedule_webinar_video_button() {
		driver.findElement(schedule_Webinar_btn).click();
	}

	@When("click on the upcoming tab")
	public void click_on_the_upcoming_tab() {
		driver.findElement(upcomming_Tab).click();
	}

	@When("click on the Past tab")
	public void click_on_the_past_tab() {
		driver.findElement(past_Tab).click();
	}

	@When("try to search on the search")
	public void try_to_search_on_the_search() {
		driver.findElement(searchField).sendKeys("sample");
	}

	@Then("loader is displayed")
	public void loader_is_displayed() {
		Assert.assertTrue(driver.findElement(loader).isDisplayed(), "loader is not displayed");
	}

	@Given("Navigate to the destination page by click on the destination menu")
	public void navigate_to_the_destination_page_by_click_on_the_destination_menu() {
		driver.navigate().refresh();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(destination_menu)).click();
	}

	@Given("Navigate to the library page by clicking on the library menu")
	public void navigate_to_the_library_page_by_clicking_on_the_library_menu() {
		driver.findElement(library_menu).click();
	}

	@Then("show stopper Ui with {string} content is displayed")
	public void show_stopper_ui_with_content_is_displayed(String string) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(show_stopper_Ui));
		Assert.assertTrue(element.isDisplayed(), "show stoppe Ui is not displayed");
	}

	@When("click on the Try again button")
	public void click_on_the_try_again_button() {
		driver.findElement(tryagain_btn).click();
	}

	@Then("page should not reload and show stopper Ui is not removed")
	public void page_should_not_reload_and_show_stopper_ui_is_not_removed() {
		Assert.assertTrue(driver.findElement(show_stopper_Ui).isDisplayed(), "show stopper Ui is not displayed");
	}

	@Then("page should be loaded and showstopper ui should not be displayed")
	public void page_should_be_loaded_and_showstopper_ui_should_not_be_displayed() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(show_stopper_Ui));
		Assert.assertFalse(driver.findElement(show_stopper_Ui).isDisplayed(), "show stopper Ui is displayed");
	}

	@Given("Navigate to the Members page by clicing on the members menu")
	public void navigate_to_the_members_page_by_clicing_on_the_members_menu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(members_menu));
		driver.findElement(members_menu).click();
	}

	@Given("Navigate to pre-preview screen")
	public void navigate_to_pre_preview_screen() {
		stream_creation("new stream");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(entering_stream_loader));
	}

	Boolean click;

	@When("Click on the Enter stream button")
	public void click_on_the_enter_stream_button() {
		try {
			driver.findElement(enter_stream_btn).click();
			click = true;
		} catch (Exception e) {
			click = false;
		}
	}

	@Then("Enter stream stream button should not be clickable")
	public void enter_stream_stream_button_should_not_be_clickable() {
		Assert.assertTrue(click == driver.findElement(enter_stream_btn).isEnabled(), "element is clickable");
	}

	@Then("page is navigating to the studio page")
	public void page_is_navigating_to_the_studio_page() {
		Assert.assertFalse(driver.findElement(enter_stream_btn).isDisplayed(), "page is not navigating to studio page");
	}

	@Given("navigate to the studio page")
	public void navigate_to_the_studio_page() {
		Assert.assertFalse(driver.findElement(enter_stream_btn).isDisplayed(), "page is not navigating to studio page");
	}

	@Then("page should not reload and not navigate to the pre-preview screen")
	public void page_should_not_reload_and_not_navigate_to_the_pre_preview_screen() {
		Assert.assertFalse(driver.findElement(show_stopper_Ui).isDisplayed(), "show stopper Ui is not displayed");
	}

	@Then("page should be loaded and navigated to the pre-preview screen")
	public void page_should_be_loaded_and_navigated_to_the_pre_preview_screen() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(entering_stream_loader));
		Assert.assertTrue(driver.findElement(enter_stream_btn).isDisplayed(),
				"page is not navigating to the pre-preview screen");
	}

}
