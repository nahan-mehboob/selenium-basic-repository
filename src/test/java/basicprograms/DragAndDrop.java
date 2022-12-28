package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		Actions actions = new Actions(driver);
		WebElement amount5000Source = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));	//source
		WebElement amount5000Destination = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]")); 	//destination
		actions.dragAndDrop(amount5000Source, amount5000Destination).build().perform(); 	//dragging and dropping source and destination

	}

}



