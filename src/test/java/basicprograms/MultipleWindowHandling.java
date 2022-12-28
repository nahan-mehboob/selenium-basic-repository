package basicprograms;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");	//lauched the url
		driver.manage().window().maximize();	//maximized the window

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait //waits for 10 seconds to load all the elements of webpage

		String parentWindow = driver.getWindowHandle();	//get the window handle of parent window
		System.out.println("The parent window handle is: "+parentWindow); 	//printing the window handle

		WebElement openNewWindowBtn = driver.findElement(By.id("newWindowBtn"));	//parent window
		openNewWindowBtn.click();	//parent window

		Set<String> allChildWindows = driver.getWindowHandles();	//window handles of all the child windows
		System.out.println(allChildWindows);

		Iterator<String>iterator = allChildWindows.iterator();	//moving to the child window
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			//if parent window not equals child window switch to child window
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);

				//performing actions in child window
				driver.manage().window().maximize();	//maximized child window
				System.out.println(driver.getCurrentUrl());	//child window url //if we need to do further actions in child window, give it inside the if loop


			}
		}
		driver.switchTo().window(parentWindow);	//switched to parent window
		System.out.println(driver.getCurrentUrl());	//parent window url
		System.out.println(driver.getTitle());	//title of parent window
		driver.quit();
	}

}



