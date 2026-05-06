package register;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P20_Register_LogicCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open URL
		driver.get(
				"https://logicnextgen.com/projects/logiccart/upload/index.php?route=account/register&language=en-gb");
		driver.findElement(By.id("input-firstname")).sendKeys("Kundan");
		driver.findElement(By.id("input-lastname")).sendKeys("Kapoor");
		driver.findElement(By.id("input-email")).sendKeys("kundan" + System.currentTimeMillis() + "@test.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");

		Thread.sleep(5000);

		driver.findElement(By.id("newsletter-yes")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("k_kapoor_check_box")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("k_kapoor_developer_button")).click();

		// Close browser
		// driver.quit();

	}

}