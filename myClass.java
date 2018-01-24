package automationFramework;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class myClass {

	@Test
	public void myTest() {
		String testURL = "www.shipt.com";
		String my_username = "qatest@shipt.com";
		String my_password = "Sh1pt123!";
		String my_item1 = "Dove Bodywash";
		String my_item2 = "Cheerios";
		WebDriver driver = new ChromeDriver();
		
		// Access Shipt website
		driver.get(testURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Login
		driver.findElement(By.xpath("//*[text() = 'Log In']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(my_username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(my_password, Keys.ENTER);
		
		// Use the search feature to find a product and add it to the cart
		driver.findElement(By.id("search")).sendKeys(my_item1, Keys.ENTER);
		driver.findElement(By.xpath("//p[@class = 'grid-product-name']/../button[@aria-label = 'Add']")).click();

		// Use the category menu to find a product and add it to the cart
		driver.findElement(By.xpath("//button[@data-full-label='Shop by Category']")).click();
		driver.findElement(By.xpath("//*[text() = 'Breakfast']")).click();
		driver.findElement(By.xpath("//*[@aria-label = 'General Mills Cheerios']/div/div/button[@aria-label = 'Add']")).click();
		
		// Validate that the correct products exist in the cart
		driver.findElement(By.xpath("//web-cart-button/button")).click();
		Integer foundItem1 = driver.findElements(By.xpath("//*[contains(@aria-label, 'Dove Bodywash']")).size();
		if(foundItem1 != 0){
			System.out.println("Dove Bodywash is in the cart.");
			}else{
			System.out.println("Dove Bodywash is NOT in the cart.");
			}
		Integer foundItem2 = driver.findElements(By.xpath("//*[contains(@aria-label, 'General Mills Cheerios']")).size();
		if(foundItem2 != 0){
			System.out.println("Cheerios are in the cart.");
			}else{
			System.out.println("Cheerios are NOT in the cart.");
			}
		
		driver.close();
	}

}
