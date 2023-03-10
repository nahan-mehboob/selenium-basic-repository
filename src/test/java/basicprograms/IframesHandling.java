package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframesHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		//scrolling, clicking and navigating to iframe window
		WebElement iFrame1 = driver.findElement(By.id("a077aa5e"));	//assigned the location of jmeter iframe
		JavascriptExecutor js = (JavascriptExecutor) driver;	//instantiating javascript executor
		js.executeScript("arguments[0].scrollIntoView();",iFrame1);	//scrolling upto iframe
		//iFrame1.click();	//this should not work since we haven't yet switched to the next tab, ie, iframe tab
		driver.switchTo().frame(iFrame1);	//switching to iframe tab
		WebElement iFrameImage = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));	//if switching to iframe does not work, we assign the location of image or any text present on iframe, here used image
		iFrameImage.click();	//clicked on image on iframe 

		//switching back to parent window
		driver.switchTo().parentFrame();	//control switched back to main page //does not go back to the page only control goes back
		//driver.switchTo().defaultContent();	//control switching back to main page	//does not go back to the page only control goes back

		//performing actions in parent window
		WebElement enterEmail = driver.findElement(By.id("philadelphia-field-email"));
		enterEmail.sendKeys("abc@xyz.com");






	}

}


