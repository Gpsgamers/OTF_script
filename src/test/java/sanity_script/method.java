package sanity_script;

import org.openqa.selenium.WebDriver;

public class method extends Element {
	public static WebDriver driver;
	public static void login(String Email, String Password) {
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}

}
