package basicprograms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementLocating {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");	//launching new url
		driver.manage().window().maximize();	//maximizing the window
		/*String current_Url = driver.getCurrentUrl(); 	//getting current url to a string
		System.out.println("Current URL is "+current_Url);
		WebElement table_Tab = driver.findElement(By.xpath("//a[contains(text(),'Table')]"));	//assigning the location of table tab to tableTab
		table_Tab.click();
		WebElement newyork = driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[6]//td[3]"));	//assigning the location of newyork element to newyork, first locate the whole table, then specify the elements
		boolean newyork_Display = newyork.isDisplayed();
		System.out.println(newyork_Display);*/

		WebElement input_Form = driver.findElement(By.xpath("//a[contains(text(),'Input')]"));	//input form tab location assigned to input_Form
		input_Form.click();
		WebElement msg_Box = driver.findElement(By.xpath("//input[@id='single-input-field']"));	//message box location assigned to msg_Box
		msg_Box.sendKeys("Hi"); //inserted hi into message box
		WebElement show_MsgBox_Button = driver.findElement(By.xpath("//button[@id='button-one']")); //show message button assigned to Show_MsgBox_Button
		show_MsgBox_Button.click(); //clicked on show message button
		WebElement your_Msg = driver.findElement(By.xpath("//div[@id='message-one']"));	//Your message location assigned to your_Msg
		Boolean your_Msg_Display = your_Msg.isDisplayed(); //finding whether your message has displayed the given message hi
		System.out.println(your_Msg_Display); //printing the boolean result of your_Msg_Display
		System.out.println(your_Msg.getText());	//getting the text that had been given inside your_Msg 



	}

}



