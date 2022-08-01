package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch the URL https://www.chittorgarh.com/
		//	2. Click on stock market
		//	3. Click on NSE bulk Deals
		//	4. Get all the Security names
		//	5. Ensure whether there are duplicate Security names//
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on skip
		driver.findElement(By.xpath("//*[@id=\"splashBackURL\"]")).click();
		
		// Click on stock market
		WebElement stockOption = driver.findElement(By.xpath("//a[text()='STOCK MARKET ']"));
		stockOption.click();
		
		// Click on NSE bulk Deals
		WebElement NseBulk = driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']"));
		NseBulk.click();
		
	    Actions Builder=new Actions(driver);
	    Thread.sleep(2000);
		Builder.moveToElement(NseBulk).click();
		
		//Security Name
		String header = driver.findElement(By.linkText("Security Name")).getText();
		System.out.println(header);
		
		List<WebElement> rowSize = driver.findElements(By.xpath("(//table)[2]//tr"));
		int sizeOfrows = rowSize.size();
		System.out.println(sizeOfrows);
		
		 List<String> rowList=new ArrayList<String>();
		
		 //Get all the Security names
		for(int i =1; i < sizeOfrows; i++) {
			String names = driver.findElement(By.xpath("(//table)[2]//tr["+i+"]/td[3]")).getText();
			System.out.println(names);
			rowList.add(names);
		}
		
		 //Remove duplicate using set
		Set<String>dupnames=new LinkedHashSet<String>(rowList);
		int size = dupnames.size();
		System.out.println(size);
		
		//check whether the duplicates in security names
		if(rowList.size()== dupnames.size()) {
			System.out.println("It has no duplicates");
		}
		else {
			System.out.println("It has duplicates");
		}
		
	}

}
