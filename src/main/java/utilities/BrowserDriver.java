package utilities;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class BrowserDriver {
	
	private final String chromeDriverPath = "./src/main/resources/drivers/chromedriver.exe";
	private WebDriver driver;
	private WebDriverWait wait;
	private final String browserName;
	
	public BrowserDriver(String browserName) {
		this.browserName = browserName;
		createDriver();
		this.wait = new WebDriverWait(driver, 60);
	}

	private void createDriver() {
	
		if(browserName.toUpperCase().equals("CHROME"))
			createChromeDriver();
		else
			throw new IllegalArgumentException ("invalid browser name");
	}

	private void createChromeDriver() {
		File chromeDriverFile = new File(chromeDriverPath);
		if (!chromeDriverFile.exists())
			throw new RuntimeException("chrome driver does not exist on " + 
		                                chromeDriverPath);
		try {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			this.driver = new ChromeDriver();
		}
		catch (Exception ex) {
			throw new RuntimeException("could not create the chrome driver");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebDriverWait getWebDriverWait() {
		return wait;
	}
}
