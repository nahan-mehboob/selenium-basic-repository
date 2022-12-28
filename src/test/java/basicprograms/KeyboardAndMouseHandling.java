package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAndMouseHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		Actions actions = new Actions(driver);	//to carry out keyboard and mouse events
		//WebElement homeButton = driver.findElement(By.xpath("//a[text()='Home']"));	//assigning the location of home button
		//actions.contextClick(homeButton).build().perform();	//right clicks on home tab
		//build and perform are used to compile and execute the Actions class
		//actions.doubleClick(homeButton).build().perform();	//double clicks on the home button

		WebElement input_Form = driver.findElement(By.xpath("//a[contains(text(),'Input')]"));	//input form tab location assigned to input_Form
		//input_Form.click();
		actions.doubleClick(input_Form).build().perform();	//double clicks on input form
		WebElement msg_Box = driver.findElement(By.xpath("//input[@id='single-input-field']"));	//message box location assigned to msg_Box
		msg_Box.sendKeys("Hi"); //inserted hi into message box
		WebElement show_MsgBox_Button = driver.findElement(By.xpath("//button[@id='button-one']")); //show message button assigned to Show_MsgBox_Button
		actions.sendKeys(show_MsgBox_Button,Keys.ENTER).build().perform();	//performing enter key press from keyboard

		msg_Box.clear();	//clears the message box
		actions.keyDown(Keys.SHIFT).build().perform();	//presses shift key
		msg_Box.sendKeys("he");	//enters he into msg_Box, it will be inserted as HE since shift key is pressed
		actions.keyUp(Keys.SHIFT).build().perform();	//releases shift key
		msg_Box.sendKeys("llo");	////enters llo into msg_Box, it will be inserted as llo since shift key is released






	}

}



