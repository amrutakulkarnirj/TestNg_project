package TestNg_framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mainDriver {
	public static WebDriver driver;
	public static void CreaterInstance(String browser)
	{
		switch (browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			System.setProperty("webdriver.firefox.driver", "");
			driver = new FirefoxDriver();
			break;
			
		case "Edge":
			System.setProperty("webdriver.edge.driver", "");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println(browser+" is not correct keyword. Please select browser amoung Chrome, Firefox or Edge");
			break;
		}
	}

}
