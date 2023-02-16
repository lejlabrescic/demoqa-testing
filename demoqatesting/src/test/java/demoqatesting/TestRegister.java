package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestRegister {

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
	    void testRegistering() throws InterruptedException {
	    	webDriver.get(baseUrl);
	    	webDriver.findElement(By.xpath("/html/body/p/a")).click(); 
	    	webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click(); 
	    	webDriver.findElement(By.xpath("//*[@id=\"reg_username\"]")).sendKeys("janeaustin"); 
	    	webDriver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("janeaustin@gmail.com");
	    	webDriver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("zvatcutihalida");
	    	String alert = webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/span/div")).getText();
	    	assertTrue(alert.contains("Please enter a stronger password"));
	    	webDriver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("testingtheapplication123");
	    	webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")).click();
	    	Thread.sleep(3000);
	    	String pageUrl = webDriver.getCurrentUrl();
	    	assertEquals(pageUrl, "https://shop.demoqa.com/my-account/");
	    	Thread.sleep(1000);
	        

	    }

}
