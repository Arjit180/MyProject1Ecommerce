package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_Register {

	@Test
	public void verifyRegisrationSuccessfully() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("input-firstname")).sendKeys("Kundan");
		driver.findElement(By.id("input-lastname")).sendKeys("kapoor");
		driver.findElement(By.id("input-email")).sendKeys("kundank9912003@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

	}  
	
}
