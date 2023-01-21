package TestNg_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WatchList_functionality extends mainDriver {
	//public static WebDriver driver;
	@BeforeMethod
	public void setup() {
	//mainDriver.CreaterInstance("Chrome");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\RJ\\Documents\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.tickertape.in/");
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//i[@class=\"jsx-1245644719 jsx-2319868650 icon-Close text-24 text-primary\"]")).click();
	    } 
	catch (NoSuchElementException e) {
	System.out.println("pop up not displayed");
	}
	}
	
	@Test(priority =1)
	public void url_Test() {
	String url = driver.getCurrentUrl();
	Assert.assertEquals(url, "https://www.tickertape.in/");
	}
	
	@Test(priority = 2)
	public void loginHoverTest() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
	Thread.sleep(5000);
	boolean popup = common.isDisplayed("//div[@class=\"jsx-160258998 overflowmenu-root theme-dark transition-all transition-all-01\"]");
	Assert.assertTrue(popup);
	}
	
	@Test(priority =3)
	public void login_button_Test() throws InterruptedException {
		
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
	common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
    Thread.sleep(1000);
	String url = driver.getCurrentUrl();
	Assert.assertEquals(url, "https://www.tickertape.in/watchlist?");
	}
	
	@Test(priority =4)
	public void watchlist_button_Test() throws InterruptedException {
    common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	Thread.sleep(1000);
	try {
	//common.click("//*[@class=\\\"jsx-1505615841\\\"])[2]\"");
    driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
    } catch (NoSuchElementException e) {
    System.out.println("pop up not displayed");
    }
		
    Thread.sleep(5000);
    // common.click("//span[@class=\"jsx-1548501762 typography-body-medium-m text-primary create-watchlist-text\"]");	
    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    boolean text = common.isDisplayed("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =5)
	public void equity_button_Test() throws InterruptedException {
	 common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
     Thread.sleep(1000);
     common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	 try {
     driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	 } catch (NoSuchElementException e) 
	 {
     System.out.println("pop up not displayed");
	 }
    Thread.sleep(1000);

	//driver.findElement(By.xpath("//span[@class=\"jsx-1548501762 typography-body-medium-m text-primary create-watchlist-text\"]")).click();
    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");

    common.click("//button[text()=\"Create\"]");
    Thread.sleep(1000);
	//driver.findElement(By.xpath("//span[@class=\"jsx-1548501762 typography-body-medium-m text-primary create-watchlist-text\"]")).click();
    }
	
	@Test(priority =6)
	public void search_stocks_button_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	//Thread.sleep(1000);
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
    common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	//driver.findElement(By.xpath("//button[text()=\"Search Stocks, ETFs & Indices\"]")).click();
	
    }
	
	@Test(priority =7)
	public void search_button_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

	driver.findElement(By.xpath("//span[@class=\"jsx-1548501762 typography-body-medium-m text-primary create-watchlist-text\"]")).click();
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");

	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	
    }
	
	@Test(priority =8)
	public void search_text_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	
    }
	
	@Test(priority =9)
	public void relatedtext_tickers_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	//common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	//driver.findElement(By.xpath("//button[text()=\"Search Stocks, ETFs & Indices\"]")).click();
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	Thread.sleep(5000);
	boolean popup = common.isDisplayed("//div[@class=\"jsx-2935546663 jsx-2558771711 jsx-4231945155 assets-suggestion-container load-more-btn \"]");
	Assert.assertTrue(popup);
	}
	
	@Test(priority =10)
	public void watchlist_icon_logo_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	Thread.sleep(5000);
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	boolean logo= common.isDisplayed("//a[@id=\"stock-suggestion-Tata Consultancy Services Ltd\"]/div[2]/a/img");
	Assert.assertTrue(logo);
	}
	
    @Test(priority =11)
	public void edit_saved_watchlist_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	boolean wholepage= common.isDisplayed("//div[@class=\"jsx-3127350202 animation-container watchlist-page\"]");
	Assert.assertTrue(wholepage);
	}

	@Test(priority =12)
	public void performance_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//span[@class=\"jsx-703606493 jsx-4090259817 tab-header typography-body-regular-m active\"]/..");
	boolean text= common.isDisplayed("//span[text()=\"Performance\"]");
	Assert.assertTrue(text);
	}
	
	@Test(priority =13)
	public void Technical_test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
	Thread.sleep(1000);
	common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
	Thread.sleep(1000);

	common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
	    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//span[@class=\"jsx-703606493 jsx-4090259817 tab-header typography-body-regular-m \"]");
	boolean text= common.isDisplayed("//span[text()=\"Technicals\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =14)
	public void Forecasts_test() throws InterruptedException {
		common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
	    Thread.sleep(1000);
	    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
		try {
			driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
		} catch (NoSuchElementException e) 
		{
			System.out.println("pop up not displayed");
		}
	    Thread.sleep(1000);

	    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
	    
		Thread.sleep(5000);
		common.click("//button[text()=\"Create\"]");
		common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
		common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
		common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
		common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
		common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
		common.click("//span[@class=\"jsx-703606493 jsx-4090259817 tab-header typography-body-regular-m \"]");
		boolean text= common.isDisplayed("//span[text()=\"Forecasts\"]/..");
		Assert.assertTrue(text);
	}
	
	@Test(priority =15)
	public void Activity_test() throws InterruptedException {
		common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
	    Thread.sleep(1000);
	    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
		try {
			driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
		} catch (NoSuchElementException e) 
		{
			System.out.println("pop up not displayed");
		}
	    Thread.sleep(1000);

	    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
	    
		Thread.sleep(5000);
		common.click("//button[text()=\"Create\"]");
		common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
		common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
		common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
		common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
		common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
		common.click("//span[@class=\"jsx-703606493 jsx-4090259817 tab-header typography-body-regular-m \"]");
		boolean text= common.isDisplayed("//span[text()=\"Activity\"]/..");
		Assert.assertTrue(text);
	}
	
	@Test(priority =16)
	public void fundamental_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
    Thread.sleep(1000);
    common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//span[@class=\"jsx-703606493 jsx-4090259817 tab-header typography-body-regular-m \"]/..");
	boolean text= common.isDisplayed("//span[text()=\"Fundamentals\"]/..");
	Assert.assertTrue(text);
	
	}
	
	@Test(priority =17)
	public void time_period_1D_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//input[@class=\"jsx-2275203603\"]/..");
	boolean text= common.isDisplayed("//p[text()=\"1D\"]/..");
	Assert.assertTrue(text);
	
	}
	
	@Test(priority =18)
	public void time_period_1M_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	//driver.findElement(By.xpath("//button[text()=\"Create\"]")).click();
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//input[@class=\"jsx-2275203603\"]/..");
	boolean text= common.isDisplayed("//p[text()=\"1M\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =19)
	public void time_period_3M_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//input[@class=\"jsx-2275203603\"]/..");
	boolean text= common.isDisplayed("//p[text()=\"3M\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =20)
	public void time_period_6M_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//input[@class=\"jsx-2275203603\"]/..");
	boolean text= common.isDisplayed("//p[text()=\"6M\"]/..");
	//System.out.println(text);
	Assert.assertTrue(text);
	
	}
	
	@Test(priority =21)
	public void time_period_1Y_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//input[@class=\"jsx-2275203603\"]/..");
	boolean text= common.isDisplayed("//p[text()=\"1Y\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =22)
	public void group_by_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);

    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//span[@role=\"button\"]");
	boolean text= common.isDisplayed("//span[@class=\"jsx-835637087 jsx-3405310386 group-by-default-color mr2 typography-body-medium-m\"]/..");
	Assert.assertTrue(text);
	}
	
	@Test(priority =23)
	public void group_by_sector_Test() throws InterruptedException {
	common.hover("//h5[@class=\"jsx-24004412 typography-body-medium-l navtext \"]");
    Thread.sleep(1000);
    common.click("//span[@class=\"jsx-1033646475 d-flex watchlist-image typography-body-medium-m\"]/..");
	try {
		driver.findElement(By.xpath("(//*[@class=\"jsx-1505615841\"])[2]")).click();
	} catch (NoSuchElementException e) 
	{
		System.out.println("pop up not displayed");
	}
    Thread.sleep(1000);
    common.click("//div[@id=\"app-container\"]/div/div/div/div/aside/div[1]/div[1]/a/span");
	//driver.findElement(By.xpath("//span[@class=\"jsx-1548501762 typography-body-medium-m text-primary create-watchlist-text\"]")).click();
    
	Thread.sleep(5000);
	common.click("//button[text()=\"Create\"]");
	common.click("//button[@class=\"jsx-2679829868 jsx-2491292752 regular primary button-root\"]/..");
	common.click("//input[@class=\"jsx-1469468354 stock-input-box full-width input\"]");
	common.sendKeys("//input[@aria-label=\"search text\"]", "TCS");
	common.click("//img[@class=\"jsx-2243824175 jsx-152776563\"]/..");
	common.click("//div[@class=\"Toastify__toast Toastify__toast--success\"]/..");
	common.click("//span[@role=\"button\"]");
	common.click("//li[@class=\"jsx-2525918057 jsx-2587875027 suggestion-menu-item suggestion-text-container typography-body-medium-m selected  \"]");
	}
	
	@AfterMethod
    public void close() {
    driver.quit();
    }
    }
