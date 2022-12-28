package basicprograms;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");	//launched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	//implicit wait

		WebElement customerId=driver.findElement(By.name("cusid"));
		Wait<WebDriver> wait =new FluentWait <WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException. class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("cusid")));
		customerId.sendKeys("2345");



	}

}



