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
import org.openqa.selenium.support.ui.Select;

class TestAddToCart {
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
	void testAddingToCart() throws InterruptedException {
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
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/h3/span"));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		js.executeScript("arguments[0].click()",webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a")));
		Thread.sleep(3000);
		Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_color\"]"))); 
		select.selectByIndex(1); 
		Select selectTwo = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_size\"]"))); 
		selectTwo.selectByValue("38"); 
		webDriver.findElement(By.xpath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		Thread.sleep(3000);
		String cart = webDriver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/span[2]")).getText(); 
		assertTrue(cart.contains("1")); 
		webDriver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a")).click();
		Thread.sleep(2000);
		
	}

}
