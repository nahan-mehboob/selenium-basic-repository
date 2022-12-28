package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/select-input.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select select = new Select(dropdown);
		//select.selectByIndex(1);	//red is selected using index
		//select.selectByValue("Yellow");	//yellow is selected using value
		select.selectByVisibleText("Green");	//green selected using visible text method
		
		
		
		
		
		


	}

}



