package sanity_script;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class method extends Element {
//	public static WebDriver driver;
	public static void login(String Email, String Password){
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}
	
	public static void stream_creation(String name) {
		driver.get("https://onthefly-qa.contus.us/broadcast");
		driver.findElement(create_stream_btn(1)).click();
		driver.findElement(create_with_Studio_btn).click();
		driver.findElement(Title_field).sendKeys(name);
		driver.findElement(createLivestream_btn).click();
	}
	

}
