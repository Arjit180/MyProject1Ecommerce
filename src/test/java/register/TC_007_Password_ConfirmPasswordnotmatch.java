package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_007_Password_ConfirmPasswordnotmatch {
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
		driver.findElement(By.id("input-email")).sendKeys(generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("123");
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
        String expectedHeading = "Password1 confirmation does not match password!";
		
		String actualHeading = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		
		System.out.println(actualHeading);
		
		Assert.assertEquals(actualHeading, expectedHeading);

}
	public String generateBrandNewEmail() {

		Date date = new Date();
		String stringDate = date.toString();

		System.out.println(stringDate);

		String noSpaceStringDate = stringDate.replaceAll("\\s", "");

		System.out.println(noSpaceStringDate);

		String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");

		System.out.println(noColonStringDate);

		String emailWithTimeStamp = "Arjit" + noColonStringDate + "@gmail.com";

		return emailWithTimeStamp;
}
}

