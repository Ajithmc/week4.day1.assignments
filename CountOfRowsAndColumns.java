package week4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountOfRowsAndColumns {

	public static void main(String[] args) {
		//1. Launch the URL https://html.com/tags/table/
		//2. Get the count of number of rows
		//3. Get the count of number of columns
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Total Rows in Table1
		List<WebElement> rowsinTable1 = driver.findElements(By.xpath("(//table)[1]//tr"));
		int rowSize1 = rowsinTable1.size();
		System.out.println("Total Rows in Table1 = "+rowSize1);
		
		//Total Columns in Table1
		List<WebElement> columnsinTable1 = driver.findElements(By.xpath("(//table)[1]//th"));
		int columnSize1 = columnsinTable1.size();
		System.out.println("Total Columns in Table1 = "+columnSize1);
		
		//Total Rows in Table2
		List<WebElement> rowsinTable2 = driver.findElements(By.xpath("(//table)[2]//tr"));
		int rowSize2 = rowsinTable2.size();
		System.out.println("Total Rows in Table2 = "+rowSize2);
		
		//Total Columns in Table1
		List<WebElement> columnsinTable2 = driver.findElements(By.xpath("(//table)[2]//th"));
		int columnSize2 = columnsinTable2.size();
		System.out.println("Total Columns in Table2 = "+columnSize2);
	}

}
