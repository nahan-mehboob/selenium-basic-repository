package basicprograms;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandlingDemo3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");	//launched the url
		driver.manage().window().maximize();	//maximized the window

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait //waits for 10 seconds to load all the elements of webpage

		String parentWindow = driver.getWindowHandle();	//get the window handle of parent window
		System.out.println("The parent window handle is: "+parentWindow); 	//printing the window handle

		//1st child window
		WebElement openNewWindowBtn=driver.findElement(By.id("newWindowBtn"));
		openNewWindowBtn.click();

		//2nd child window
		WebElement openNewTabWindowBtn=driver.findElement(By.id("newTabBtn"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",openNewTabWindowBtn);
		openNewTabWindowBtn.click();

		//getting all child windows
		Set<String>allChildWindows=driver.getWindowHandles();
		System.out.println(allChildWindows);

		//navigating to both child windows
		Iterator<String>iterator=allChildWindows.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(2000);

				driver.manage().window().maximize();
				System.out.println("Child URL :"+driver.getCurrentUrl());
				Thread.sleep(2000);

			}

		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		System.out.println("Parent URL :"+driver.getCurrentUrl());
		System.out.println("Parent Title :"+driver.getTitle());
		driver.quit();


	}

}


