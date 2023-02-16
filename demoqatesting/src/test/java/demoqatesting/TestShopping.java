package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class TestShopping {

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
	void testShopping() throws InterruptedException {
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
    	webDriver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a")).click(); 
    	webDriver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click(); 
    	webDriver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Jane"); 
    	webDriver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Austin"); 
    	Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"billing_country\"]"))); 
    	select.selectByIndex(1);
    	webDriver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("Islamabad 34"); 
    	webDriver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Islamabad"); 
    	webDriver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("3663"); 
    	webDriver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("555444"); 
    	webDriver.findElement(By.xpath("//*[@id=\"terms\"]")).click(); 
    	webDriver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
    	Thread.sleep(3000); 
    	String currentUrl = webDriver.getCurrentUrl(); 
    	assertEquals(currentUrl, "https://shop.demoqa.com/checkout/"); 
    	
    	
		

}
}