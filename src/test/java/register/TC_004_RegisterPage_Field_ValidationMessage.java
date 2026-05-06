package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_RegisterPage_Field_ValidationMessage {
	
	@Test
	public void verifyRegisrationMessageSuccessAccountcreated() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		// Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		// Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		// Thread.sleep(3000);

		driver.findElement(By.id("input-firstname")).sendKeys("Arjit");
		driver.findElement(By.id("input-lastname")).sendKeys("Garg");
		driver.findElement(By.id("input-email")).sendKeys(generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		String actualHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		
		System.out.println(actualHeading);
		
		Assert.assertEquals(actualHeading, expectedHeading);
		
        String expectedHeading1 = "Congratulations! Your new account has been successfully created!";
		
		String actualHeading1 = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
		
		System.out.println(actualHeading1);
		
		Assert.assertEquals(actualHeading1, expectedHeading1);
		
        String expectedHeading2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		
		String actualHeading2 = driver.findElement(By.xpath("//p[contains(text(),'You can now take advantage of member privileges to')]")).getText();
		
		System.out.println(actualHeading2);
		
		Assert.assertEquals(actualHeading2, expectedHeading2);
		
        String expectedHeading3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		
		String actualHeading3 = driver.findElement(By.xpath("//p[contains(text(),'If you have ANY questions about the operation of t')]")).getText();
		
		System.out.println(actualHeading3);
		
		Assert.assertEquals(actualHeading3, expectedHeading3);
		
        String expectedHeading4 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		
		String actualHeading4 = driver.findElement(By.xpath("//p[contains(text(),'A confirmation has been sent to the provided e-mai')]")).getText();
		
		System.out.println(actualHeading4);
		
		Assert.assertEquals(actualHeading4, expectedHeading4);
		
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
