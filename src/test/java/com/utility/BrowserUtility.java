package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	public static WebDriver driver;
	

	public static WebDriver supplyDriver(String browser) {
		
		if (browser.equals("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1400,1500");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--no-sandbox");
//			options.addArguments("start-maximized");
//			options.addArguments("enable-automation");
//			options.addArguments("--disable-infobars");
//			options.addArguments("--disable-dev-shm-usage");
			
			
			
			
			// Set version 116
			ChromeOptions options = new ChromeOptions();
			options.setBrowserVersion("117");			
			options.setCapability("browserVersion", "100");
			options.setCapability("platformName", "Windows");
			// Showing a test name instead of the session id in the Grid UI
			options.setCapability("se:name", "My simple test"); 
			// Other type of metadata can be seen in the Grid UI by clicking on the 
			// session info or via GraphQL
			options.setCapability("se:sampleMetadata", "Sample metadata value"); 
			//co.addArguments("--headless=new");
			try {
				options.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    /* How to add test badge */
				    put("name", "Test badge...");

				    /* How to set session timeout */
				    put("sessionTimeout", "15m");

				    /* How to set timezone */
				    put("env", new ArrayList<String>() {{
				        add("TZ=UTC");
				    }});

				    /* How to add "trash" button */
				    put("labels", new HashMap<String, Object>() {{
				        put("manual", "true");
				    }});

				    /* How to enable video recording */
				    put("enableVideo", true);
				}});
				driver = new RemoteWebDriver(new URL("http://43.204.102.13:4444/wd/hub"), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ChromeDriver(options);
			
		} else if (browser.equals("firefox")) {
			return new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			return new InternetExplorerDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		} else {
			return null;
		}
	}

	public static void openBrowser() {

	}

	public static void closeBrowser() {

	}

}
