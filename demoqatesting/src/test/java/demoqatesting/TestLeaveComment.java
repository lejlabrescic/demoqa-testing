package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestLeaveComment {
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
	void testLeaveBlogComment() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.xpath("/html/body/p/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true)", webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[6]/div/div/div/div/div/div[2]/div[4]")));
		js.executeScript("arguments[0].click()",webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[6]/div/div/div/div/div/div[2]/div[4]/div/h3/a"))); 
		Thread.sleep(4000); 
		js.executeScript("arguments[0].scrollIntoView(true)", webDriver.findElement(By.xpath("//*[@id=\"reply-title\"]/span")));
		Thread.sleep(3000);
		webDriver.findElement(By.cssSelector("#author")).sendKeys("janedoe"); 
		webDriver.findElement(By.cssSelector("#email")).sendKeys("janedoe@gmail.com"); 
		webDriver.findElement(By.cssSelector("#comment")).sendKeys("Sample comment"); 
		webDriver.findElement(By.xpath("//*[@id=\"aiowps-captcha-answer\"]")).sendKeys("15"); 
		Thread.sleep(7000); 
		webDriver.findElement(By.cssSelector("#submit")).click();
		Thread.sleep(10000); 
		

		

}}
