package sanity_script;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\main\\java\\feature_file\\OTF_offline.feature",

}, // Path to feature files
		glue = { "sanity_script" }, // Package for step definitions
		plugin = { "pretty", // For console output
				"html:target/cucumber-reports/Cucumber.html", // HTML report
				"json:target/cucumber-reports/Cucumber.json" // JSON report
		}, monochrome = true // To make console output more readable

)
public class Runner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String Browser, Owner, Admin, cohost, Owner_password, Admin_password, cohost_password, url;

	@BeforeClass
	@Parameters({ "browser", "environment" })
	public void browserlaunchconfiguration(String browser, String environment) throws InterruptedException {
		Browser = browser;
		System.out.println(Browser);
		driver = launchbrowser(browser);
		Environment(environment);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void browserQuitconfiguration() {
		driver.quit();
	}

	// launch browser
	public WebDriver launchbrowser(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("--use-fake-ui-for-media-stream");
			return new ChromeDriver(options);
		} else if (browser.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			return new EdgeDriver(options);
		} else if (browser.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			return new FirefoxDriver(options);
		} else if (browser.equals("safari")) {
			SafariOptions options = new SafariOptions();
			return new SafariDriver(options);
		} else {
			return null;
		}
	}

	public void Environment(String Env) {
		switch (Env) {
		case "QA":
			url = "https://onthefly-qa.contus.us/";

			Owner = "guruprasad.b@contus.in";
			Owner_password = "Welcome@123";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;

		case "DEV":
			url = "https://onthefly-dev.contus.us/";

			Owner = "rahul.s@contus.in";
			Owner_password = "";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;

		case "Live":
			url = "https://console.onthefly.stream/";

			Owner = "guruprasad.b@contus.in";
			Owner_password = "Welcome@123";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;
		}
	}

	public static void offline() throws InterruptedException {
		Map<String, Object> offlineParams = new HashMap<>();
		offlineParams.put("offline", true);
		offlineParams.put("latency", 0); // Latency in ms (no delay)
		offlineParams.put("downloadThroughput", 0); // Download speed (0 = disconnected)
		offlineParams.put("uploadThroughput", 0); // Upload speed (0 = disconnected)

		switch (Browser) {
		case "chrome":
			((ChromeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", offlineParams);
			Thread.sleep(3000);
			System.out.println("Network disconnected");
			break;

		case "firefox":
			// not working
			((FirefoxDriver) driver)
					.executeScript("window.navigator.serviceWorker.controller.postMessage({offline: true});");
			break;
		case "edge":
			((EdgeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", offlineParams);
			break;
		}
	}

	public static void online() {
		Map<String, Object> onlineParams = new HashMap<>();
		onlineParams.put("offline", false);
		onlineParams.put("latency", 0); // Set small latency to simulate a real connection
		onlineParams.put("downloadThroughput", -1); // -1 for normal speed
		onlineParams.put("uploadThroughput", -1); // -1 for normal speed

		switch (Browser) {
		case "chrome":
			((ChromeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", onlineParams);
			System.out.println("Network connected");
			break;

		case "firefox":
			// not working
			((FirefoxDriver) driver)
					.executeScript("window.navigator.serviceWorker.controller.postMessage({offline: false});");
			break;

		case "edge":
			((EdgeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", onlineParams);
			break;
		}
	}

}
