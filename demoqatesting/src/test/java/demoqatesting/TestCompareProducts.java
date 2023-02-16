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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

class TestCompareProducts {

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
	void testCompareProduct() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/p/a")).click(); 
		WebElement firstProduct = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]")); 
		Actions action = new Actions(webDriver);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		action.moveToElement(firstProduct).perform();
		js.executeScript("arguments[0].click()",webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[1]/a")));
		//js.executeScript("arguments[0].click()", webDriver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td/a")));
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"cboxClose\"]")).click();
		WebElement secondProduct = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div[1]")); 
		action.moveToElement(secondProduct).perform();
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(6000);

		

}}
