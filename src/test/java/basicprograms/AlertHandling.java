package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		WebElement customerId = driver.findElement(By.name("cusid"));	//assigning the location of customer id search bar
		customerId.sendKeys("1111");	//inserting the value in the search bar

		WebElement submitButton = driver.findElement(By.name("submit"));	//assigning the value of submit button
		submitButton.click();	//clicking the submit button
		Thread.sleep(2000);

		driver.switchTo().alert().accept();	//clicks the OK button of the first alert
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		System.out.println(driver.switchTo().alert().getText());	//gets the message of the second alert
		driver.switchTo().alert().dismiss();	//clicks the ok button of the alert









	}

}


