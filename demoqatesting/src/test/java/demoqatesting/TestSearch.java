package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class TestSearch {
	private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DT User\\Desktop\\chromedriver_wnew\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://shop.demoqa.com/";
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        webDriver.quit();
    }

	@Test
	void testSearch() throws InterruptedException {
	webDriver.get(baseUrl);
    webDriver.manage().window().maximize();
    webDriver.findElement(By.xpath("/html/body/p/a")).click();
    webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
    webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("janeaustin");
    webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("zvatcutihalida");
    webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
    Thread.sleep(3000);
    webDriver.navigate().to(baseUrl);
    Thread.sleep(3000);
    webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a")).click();
	WebElement search = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")); 
	search.sendKeys("dress"); 
	search.sendKeys(Keys.ENTER); 
	Thread.sleep(3000);
	WebElement product = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]")); 
	String dress = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[2]/div/h3/a")).getText();
	Actions action = new Actions(webDriver);
	action.moveToElement(product).perform();
	webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/a")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) webDriver;
	js.executeScript("window.scrollTo(0, 0);");
	webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[1]/a")).click();
	Thread.sleep(3000);
	String dressInWishlist = webDriver.findElement(By.xpath("//*[@id=\"yith-wcwl-row-1467\"]/td[3]/a")).getText(); 
	assertEquals(dress, dressInWishlist);
	
}}
