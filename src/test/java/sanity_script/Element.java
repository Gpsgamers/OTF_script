package sanity_script;

import org.openqa.selenium.By;

import Runner_script.Runner;

public class Element extends Runner {
	// login page
	public static By emailfield = By.xpath("//*[@label ='email']");
	public static By password = By.xpath("//*[@label ='password']");
	public static By sign_in = By.xpath("//*[text() ='Sign In']");
	
	//stream page
	public static By create_stream_btn (int index) {
		return By.xpath("(//*[text()='Create Stream'])["+index+"]");
	}
	public static By record_Video_btn =By.xpath("//*[text()='Record Video']");
	public static By schedule_Webinar_btn = By.xpath("//*[text()='Schedule Webinar']");
	public static By create_with_Studio_btn = By.xpath("//*[text()='Stream with Studio']");
	public static By pre_Recorded_stream_btn = By.xpath("//*[text()='Pre-Recorded Stream']");
	public static By all_Tab = By.xpath("//button[text()='All']");
	public static By upcomming_Tab= By.xpath("//button[text()='Upcoming']");
	public static By past_Tab = By.xpath("//button[text()='Past']");
	public static By searchField = By.xpath("//input[@class='table_search_input     ']");
	
	public static By orginazation_Dropdown = By.xpath("//button[@class='multi_login btn-icon ']");
	
	
}
