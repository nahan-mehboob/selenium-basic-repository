package basicprograms;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");	//lauched the url
		driver.manage().window().maximize();	//maximized the window

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait //waits for 10 seconds to load all the elements of webpage
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	//old command for implicit wait //waits for 5 seconds to load all the elements of webpage

		JavascriptExecutor js = (JavascriptExecutor) driver;	//instantiating jsexecutor
		/*js.executeScript("window.scrollBy(0,1000)");//scroll down
		Thread.sleep(5000); //execution stops for 5 seconds
		js.executeScript("window.scrollBy(0,-1000)");//scroll up
		WebElement allCoursesInclude = driver.findElement(By.xpath("//h2[contains(text(),'Courses include')]"));	//assigning the location of all course include 
		js.executeScript("arguments[0].scrollIntoView();",allCoursesInclude); //scrolling upto all course include element
		System.out.println(allCoursesInclude.getText());*/	//getting the text of that element

		WebElement insuranceProject = driver.findElement(By.xpath("//a[contains(text(),'nce Proje')]"));	//assigning the location for Insurance Project tab
		js.executeScript("arguments[0].click();",insuranceProject);	//click command using jsexecutor












	}

}



