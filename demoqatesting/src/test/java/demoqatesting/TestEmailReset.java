package demoqatesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.support.locators.RelativeLocator;

import javax.mail.*;
import javax.mail.search.SubjectTerm;

class TestEmailReset {
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
	void testEmailReset() throws InterruptedException, MessagingException {
	 webDriver.get(baseUrl);
     webDriver.manage().window().maximize();
 	webDriver.findElement(By.xpath("/html/body/p/a")).click();
     webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
     webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/a")).click(); 
     webDriver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("janeaustintexas8@gmail.com");
     webDriver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/p[3]/button")).click();
     Thread.sleep(6000);
     webDriver.get("https://www.google.com/intl/hr/gmail/about/");
     Thread.sleep(3000);
     webDriver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
     WebElement email = webDriver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
    		 email.sendKeys("janeaustintexas8@gmail.com"); 
     email.sendKeys(Keys.ENTER);
     WebElement password = webDriver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")); 
     password.sendKeys("Testpassword1'");
     password.sendKeys(Keys.ENTER); 
     WebElement search = webDriver.findElement(By.xpath("//*[@id=\"gs_lc50\"]/input[1]"));
    		 search.sendKeys("tools");
    search.sendKeys(Keys.DOWN);
    search.sendKeys(Keys.ENTER); 
    String emailHeadline = webDriver.findElement(By.xpath("//*[@id=\":9e\"]")).getText(); 
    assertTrue(emailHeadline.contains("Password Reset Request for ToolsQA Demo Site"));
    Thread.sleep(3000);
    
     
    
     

}}
