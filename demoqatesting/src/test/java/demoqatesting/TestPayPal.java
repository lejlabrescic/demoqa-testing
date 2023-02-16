package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestPayPal {

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
	void testPaypal() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
    	webDriver.findElement(By.xpath("/html/body/p/a")).click();
    	JavascriptExecutor js = (JavascriptExecutor) webDriver;
    	js.executeScript("arguments[0].scrollIntoView(true)", webDriver.findElement(By.xpath("//*[@id=\"text-1\"]/div/ul/li[4]")));
    	WebElement paypalLink = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/footer/div[2]/div/a")); 
    	paypalLink.click(); 
    	String payPalUrl = paypalLink.getText(); 
    	assertFalse(payPalUrl.contains("Paypal")); 
    	Thread.sleep(3000);
    	
    	
    	

}}
