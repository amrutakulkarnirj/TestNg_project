package TestNg_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common extends WatchList_functionality{
	
	public static void click(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void hover(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}
	
	public static boolean isDisplayed(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public static void sendKeys(String xpath, String text) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).sendKeys(text);;
	}
	}
	