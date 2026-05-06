package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0002_Register_With_Dynamic_Email_Experiment {

	@Test
	public void verifyRegisrationSuccessfully() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		// Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		// Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		// Thread.sleep(3000);

		driver.findElement(By.id("input-firstname")).sendKeys("Kundan");
		driver.findElement(By.id("input-lastname")).sendKeys("kapoor");
		driver.findElement(By.id("input-email")).sendKeys(generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

	}

	public String generateBrandNewEmail() {

		Date date = new Date();
		String stringDate = date.toString();

		System.out.println(stringDate);

		String noSpaceStringDate = stringDate.replaceAll("\\s", "");

		System.out.println(noSpaceStringDate);

		String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");

		System.out.println(noColonStringDate);

		String emailWithTimeStamp = "Suman" + noColonStringDate + "@gmail.com";

		return emailWithTimeStamp;

	}
}

