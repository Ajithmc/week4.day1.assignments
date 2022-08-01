package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablesInTestLeaf {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//count Of Columns
		List<WebElement> columns = driver.findElements(By.xpath("//table//th"));
		int countOfColumns = columns.size();
		System.out.println("The count of Columns : "+countOfColumns);
		
		//count Of Rows
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		int countOfRows = rows.size();
		System.out.println("The count of Rows : "+countOfRows);
		
		//Interact with Elements
		String text = driver.findElement(By.xpath("//table//tr[3]")).getText();
		System.out.println(text);
		
		//progess value of Interact with elements
		List<String> progressvalue = new ArrayList<String>();
		for(int i = 3; i<=5;i++) {
			String text2 = driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
			progressvalue.add(text2);
		}
		System.out.println("Progress Values : "+progressvalue);
		
		//least completed progress
		List<WebElement> value = driver.findElements(By.xpath("//td[2]"));
		List<Integer> values = new ArrayList<Integer>();
		
		for (WebElement list : value) {
			String individualValue = list.getText().replace("%", "");
			values.add(Integer.parseInt(individualValue));
			
		}
		
		int leastValue = Collections.min(values);
		System.out.println("The Least value is "+leastValue);
		
		String finalValue = Integer.toString(leastValue)+"%";
		System.out.println(finalValue);
		
		Collections.sort(values);
		System.out.println(values);
		
		
		//least completed progress
		driver.findElement(By.xpath("//font[text()="+"\""+finalValue+ "\""+"]/following::input")).click();		
	}

}
