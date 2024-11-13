package sanity_script;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class config {
	private ChromeDriver chromeDriver;
	private EdgeDriver edgeDriver;
	private FirefoxDriver firefoxDriver;

	public config(ChromeDriver chromeDriver) {
		this.chromeDriver = chromeDriver;
	}

	public config(EdgeDriver edgeDriver) {
		this.edgeDriver =edgeDriver;
	}

	public config(FirefoxDriver firefoxDriver) {
		this.firefoxDriver = firefoxDriver;
	}
}
