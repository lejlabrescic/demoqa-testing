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
import org.openqa.selenium.support.ui.Select;

class TestCartMalfunction {
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
	void testCartMalfunction() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
    	webDriver.findElement(By.xpath("/html/body/p/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
    	js.executeScript("arguments[0].click()",webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a")));
		Thread.sleep(3000);
		Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_color\"]"))); 
		select.selectByIndex(1); 
		Select selectTwo = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_size\"]"))); 
		selectTwo.selectByValue("38"); 
		webDriver.findElement(By.xpath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		Thread.sleep(3000);    
		js.executeScript("window.scrollTo(0, 0);");
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click(); 
		webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
    	webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("janeaustin");
    	webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("zvatcutihalida");
    	webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
    	Thread.sleep(3000);
    	webDriver.navigate().to(baseUrl); 
    	webDriver.findElement(By.cssSelector("#noo-site > div.page_fullwidth > div:nth-child(4) > div > div.padding-stylebox.wpb_column.vc_column_container.vc_col-sm-12.vc_col-lg-7.vc_col-md-7 > div > div > div > div.noo-sh-product-grid.woocommerce > div.noo-sh-product-html.columns_3.no_masonry.three.row.is-flex > div.noo-product-item.noo-product-sm-4.not_featured.post-1162.product.type-product.status-publish.has-post-thumbnail.product_cat-dress.product_cat-maxi-dresses.product_tag-dress.product_tag-maxi.product_tag-women.has-featured.instock.sale.shipping-taxable.purchasable.product-type-variable > div > h3 > a")).click();
    	Select color = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_color\"]"))); 
    	color.selectByIndex(1); 
    	Thread.sleep(5000);
    	Select size = new Select(webDriver.findElement(By.xpath("//*[@id=\"pa_size\"]"))); 
    	size.selectByIndex(1); 
    	webDriver.findElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click(); 
    	webDriver.navigate().to(baseUrl); 
    	String cart = webDriver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/span[2]")).getText(); 
		assertFalse(cart.contains("1")); 
		Thread.sleep(3000);
		assertTrue(cart.contains("2"));
		Thread.sleep(3000);


}}
