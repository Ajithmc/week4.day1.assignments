package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllValuesInTables {

	public static void main(String[] args) {
		// Launch the URL https://html.com/tags/table/
		// You have to print the respective values based on given Library
		//(hint: if the library was absolute usage, then print all its value)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement text1 = driver.findElement(By.xpath("((//table)[1]//tr)[2]/td[1]"));
		String library1 = text1.getText();
		System.out.println(library1);
		
		List<String> listOfLibrary1 = new ArrayList<String>();
		
		List<String> listOfLibrary2 = new ArrayList<String>();
		
		for(int i = 2 ; i<=4 ;i++) {
			 String marketShare = driver.findElement(By.xpath("((//table)[1]//tr)[2]/td["+i+"]")).getText();
			 listOfLibrary1.add(marketShare);
			
		}
		 System.out.println("Values : "+listOfLibrary1);
		 
		 WebElement text2 = driver.findElement(By.xpath("((//table)[1]//tr)[3]/td[1]"));
		 String library2 = text2.getText();
		 System.out.println(library2);
		
		 for(int j = 2 ; j<=4 ;j++) {
			 String absoluteUsage = driver.findElement(By.xpath("((//table)[1]//tr)[3]/td["+j+"]")).getText();
			 listOfLibrary2.add(absoluteUsage);
			
		}
		 System.out.println("Values : "+listOfLibrary2);
	}

}
