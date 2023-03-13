package StepDefinitions;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.en.*;

public class EnsekBuyEnergy {
	static WebDriver driver = null;

	@Given("browser is open")
	public static void browser_is_open() {

		// 0-always ask, 1-Allow, 2-Block

		ChromeOptions options = new ChromeOptions();

		HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		conentSettings.put("notifications", 2);
		conentSettings.put("geolocation", 2);
		conentSettings.put("media_stream", 2);

		profile.put("managed_default_content_settings", conentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver","/Users/jaisreekasera/CucumberJava/src/test/resources/drivers/chromedriver");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(options);
		// MaximizeWindow
		driver.manage().window().maximize();

		driver.manage().window().maximize();
		driver.navigate().to("https://ensekautomationcandidatetest.azurewebsites.net/");
		
	}

	@Given("user is on Ensek Website")
	public void user_is_on_Ensek_Website() throws InterruptedException {
		System.out.println("Inside Step - ENSEK");
	}
		
		
	@And("User clicks on Buy energy")
	public void User_clicks_on_Buy_energy() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Buy energy')]")).click();
		Thread.sleep(2000);
		System.out.println("User clicked on Buy Energy");
		
	
	}


	@Then("click on reset button")
	public void click_on_reset_button() throws InterruptedException{
		driver.findElement(By.xpath("//*[contains(@name,'Reset')]")).click();
	}


	
	@And("Buy Energy page gets displayed and user buys the energy")
	public void Buy_Energy_page_gets_displayed_and_user_buys_the_energy() throws InterruptedException{
		
		
				List<WebElement> rowElements = driver.findElements(By.xpath("//*[@class='table']/tbody/tr"));
				int rowSize = rowElements.size();
				System.out.println("row size is " + rowSize);
				
				List<WebElement> columnElements = driver.findElements(By.xpath("//*[@class='table']/tbody/tr[1]/td"));
				int colSize = columnElements.size();
				System.out.println("column size is " + colSize);
				
	
				for (int i =1; i<= rowSize; i++) {
					
					String table_data = driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[1]")).getText();
					System.out.println("Energy type for row "+ i +" is " + table_data);
					
						
						for(int j=1; j<=colSize ; j++) {	
							
							String celldata = driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td["+ j +"]"))
									.getText();
							System.out.println(celldata);
							
							String not_available_text = driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[4]")).getText();
							
							String units_available = driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[3]")).getText();
							
							String units_required = units_available;
									
							if(!celldata.equals("Nuclear") && !not_available_text.equals("Not Available")) {
							
							driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[4]/input")).click();
							driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[4]/input")).clear();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[4]/input")).sendKeys(units_required);
			
							//click on Buy button
							
							driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[5]")).click();
							Thread.sleep(2000);
							
							//Message after buying the energy
							
							String actual_message = driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText();
							System.out.println(actual_message);
							
							int units_left = Integer.parseInt(units_available) - Integer.parseInt(units_required);
							
							String expected_message = "Thank you for your purchase of " + units_required + " units of " + table_data + " We have popped it in the post and it will be with you shortly.\n"
									+ "There are now " + units_left + " units of " + table_data + " left in our stores.";
							
							if (expected_message.equals(actual_message)) {
								System.out.println("actual and expected messages matched");
							}
							
							else {
								System.out.println("actual and expected messages did not match");
							}
							
							//Click on Buy more button
							driver.findElement(By.xpath("/html/body/div[2]/p[2]/a")).click();
						

							
							}
						}
						
					}
	     }
	
						

	
	@And("Close the Browser")
	public void Close_the_Browser()throws InterruptedException {
	
	//Close the Chrome Browser
	driver.close();		
	System.out.println("User Close the Browser");
	
	
	
}
}

	
