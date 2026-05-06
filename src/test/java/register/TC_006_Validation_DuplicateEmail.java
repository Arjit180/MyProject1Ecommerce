package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_006_Validation_DuplicateEmail {

	
	@Test
	public void verifyRegisrationMessageSuccessAccountcreated() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys("Arjit");
		driver.findElement(By.id("input-lastname")).sendKeys("Garg");
		driver.findElement(By.id("input-email")).sendKeys("arjitg1700@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
        String expectedHeading = "Warning: E-Mail Address is already registered!";
		
		String actualHeading = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		
		System.out.println(actualHeading);
		
		Assert.assertEquals(actualHeading, expectedHeading);

}
}


