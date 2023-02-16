package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

class TestSorting {
	private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DT User\\Desktop\\chromedriver_wnew\\chromedriver.exe");
        webDriver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
        baseUrl = "https://shop.demoqa.com/";
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        webDriver.quit();
    }

	@Test
	void testSorting() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.xpath("/html/body/p/a")).click();
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")).sendKeys("DRESS"); 
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")).sendKeys(Keys.ENTER); 
		Select filterColor = new Select(webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[1]/select"))); 
		filterColor.selectByIndex(0);
		Select filterSize = new Select(webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[2]/select"))); 
		//filterSize.selectByIndex(1);
		Select grid = new Select(webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[3]/select")));
		//grid.selectByIndex(2); 
		Select relevance = new Select(webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select")));
		relevance.selectByIndex(0); 
		Thread.sleep(4000);
		

}}
