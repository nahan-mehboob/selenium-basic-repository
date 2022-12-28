package basicprograms;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadingEg1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		WebElement chooseFile = driver.findElement(By.name("uploadfile_0"));	//assigning the location of choose file button
		//chooseFile.click();
		Thread.sleep(2000);
		chooseFile.sendKeys("C:\\Users\\admin\\Downloads\\Notes 8-11.docx");	//uploading this file
		WebElement submitFileBtn = driver.findElement(By.id("submitbutton"));	//assigning the location of submit button
		submitFileBtn.click();	//clicking on submit button




	}

}


