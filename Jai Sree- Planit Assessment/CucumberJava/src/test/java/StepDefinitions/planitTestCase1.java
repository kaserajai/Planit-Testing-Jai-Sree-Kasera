package StepDefinitions;


//import java.util.List;
import java.math.RoundingMode;  
import java.text.DecimalFormat;  
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
//import enums.Context;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class planitTestCase1 {
	static WebDriver driver = null;
	
	@Given("chrome browser is open")
	public static void browser_is_open() {

		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver","/Users/jaisreekasera/CucumberJava/src/test/resources/drivers/chromedriver");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(options);
		// MaximizeWindow
		driver.manage().window().maximize();

		driver.navigate().to("http://jupiter.cloud.planittesting.com");
		
	}

	@And("user is on Planit Testing Website")
	public void user_is_on_Planit_Testing_Website() throws InterruptedException {
		System.out.println("Inside Step - Planit Testing website");
	}
		
		
	@And("user clicks on contact page from the home page")
	
	public void user_clicks_on_contact_page_from_the_home_page() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Contact')]")).click();
		Thread.sleep(2000);
		System.out.println("User clicked on Contact");
		
	
	}


	@And("click on submit button")
	
	public void click_on_submit_button() throws InterruptedException{
		driver.findElement(By.xpath("//*[contains(@class,'btn-contact btn btn-primary')]")).click(); 
		
			}

	@Then("verify error messages")
	
	public void verify_error_message() throws InterruptedException{
		
		//Forename Error message validation
		
		String actual_forename = driver.findElement(By.xpath("//*[@id='forename-err']")).getText();
		
		System.out.println(actual_forename);
		
		String expected_forename = "Forename is required";
		
		Assert.assertEquals(expected_forename, actual_forename);
		
		//Email Error message validation
		
		String actual_email = driver.findElement(By.xpath("//*[@id='email-err']")).getText();
		
		System.out.println(actual_email);
		
		String expected_email = "Email is required";
		
		Assert.assertEquals(expected_email, actual_email);
		
		
		//Email Error message validation
		
		String actual_message = driver.findElement(By.xpath("//*[@id='message-err']")).getText();
		
		System.out.println(actual_message);
		
		String expected_message = "Message is required";
		
		Assert.assertEquals(expected_message, actual_message);

	}
	
	@And("populate mandatory fields")
	
	public void populate_mandatory_fields(DataTable testData) throws InterruptedException{
		
		Map<String, String> details = testData.asMap(String.class, String.class);
		
		driver.findElement(By.xpath("//*[@id='forename']")).sendKeys(details.get("forename"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(details.get("email"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='message']")).sendKeys(details.get("message"));
		Thread.sleep(2000);
		
		Thread.sleep(10000);
		
	}
	
	@And("validate errors are gone")
	
	public void validate_errors_are_gone() throws InterruptedException{
		
		// Error message disappeared
		
		String forename = driver.findElement(By.xpath("//*[@id='forename']")).getText();
		
		if (!forename.isBlank()) {
			
			System.out.println("Field value is not blank, Rather it is" + forename + "and hence mandaotry field error messages has been disappeared.");
		}	
		
		String email = driver.findElement(By.xpath("//*[@id='email']")).getText();
		
		if (!email.isBlank()) {
			
			System.out.println("Field value is not blank, Rather it is" + email + "and hence mandaotry field error messages has been disappeared.");
		}
		
		String message = driver.findElement(By.xpath("//*[@id='email']")).getText();
		
		if (!message.isBlank()) {
			
			System.out.println("Field value is not blank, Rather it is" + message + "and hence mandaotry field error messages has been disappeared.");
		}

	}
		

	@And("close the Browser")
	public void Close_the_Browser()throws InterruptedException {
	
	//Close the Chrome Browser
	driver.close();		
	System.out.println("User Close the Browser");
	
	
	
}
	
	@Then("validate successful submission message")
	
	public void validate_successful_submission_message() throws InterruptedException{
		
		Thread.sleep(10000);
		
		
		String actual_msg = driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
		
		System.out.println(actual_msg);
		
		String expected_msg = "Thanks Jai, we appreciate your feedback." + "	";
		
		if (expected_msg.equals(actual_msg)) {
			System.out.println(actual_msg);
		}
		
		else {
			System.out.println("actual and expected alert message did not match");
		}
	}
	
	

	@And("user clicks on Shop page from the home page")
	
	//Need to change code below
	public void user_clicks_on_Shop_page_from_the_home_page() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='nav-shop']")).click();
		Thread.sleep(2000);
		System.out.println("User clicked on Shop");
		Thread.sleep(2000);
	}

	
	@When("Buy Products")
	
	public void Buy_Products(DataTable testData) throws InterruptedException{
		
		Map<String, String> details = testData.asMap(String.class, String.class);
 		Thread.sleep(2000);
		//Fetch the data from table
		
		for (int i=1; i<=7; i++) {
			
			if(i == 2) {
				for(int p=1; p<=2; p++) {
					driver.findElement(By.xpath("//*[@id='product-2']/div/p/a")).click();
					System.out.println(p + "product 4 is clicked");
				}
				}
			
			else if(i == 4) {
				for(int q=1; q<=5; q++) {
					driver.findElement(By.xpath("//*[@id='product-4']/div/p/a")).click();
					System.out.println(q + "product is clicked");
					
				}
				}
			
			else if(i == 7) {
				for(int r=1; r<=3; r++) {
					driver.findElement(By.xpath("//*[@id='product-7']/div/p/a")).click();
					System.out.println(r + "product 4 is clicked");
					
				}	
				}	
			
		}
		
	}
	
	
	@And("go to Cart page")
	
	public void go_to_Cart_page() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='nav-cart']")).click(); 
		Thread.sleep(5000);
			}
	
	@Then("Verify the subtotal, Price for each product and total price is correct")
	
	public void verify_subtotal_price_each_product_subtotal(DataTable testData) throws InterruptedException{

		// Fetch data from table
		
		Map<String, String> details = testData.asMap(String.class, String.class);
		
//		table : //table[@class='table table-striped cart-items']
//		header/columns : //table[@class='table table-striped cart-items']//th
//		rows : //table[@class='table table-striped cart-items']//tr
//		All data : //table[@class='table table-striped cart-items']//td
		
//		1st Column (item) in all the rows  : //table[@class='table table-striped cart-items']//tr//td[1]
		
//		2nd Column (unit price) in all rows: //table[@class='table table-striped cart-items']//tr//td[2]
		
//		3rd column (qty) in all rows: //table[@class='table table-striped cart-items']//tr//td[3]
		
//		4th column (subtotal) in all rows: //table[@class='table table-striped cart-items']//tr//td[4]
		
		Thread.sleep(10000);
		
		List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@class='table table-striped cart-items']//th"));
		System.out.println("Total cols are " +allHeaders.size());
		
		Assert.assertEquals(allHeaders.size(), 5);
		
		List<WebElement> numofRows = driver.findElements(By.xpath("/html/body//form/table/tbody/tr"));
		System.out.println("Total number of rows are " +numofRows.size());
		
		List<WebElement> allData = driver.findElements(By.xpath("/html/body//form/table/tbody/tr/td"));
		System.out.println("All data of the table is" +allData.size());
		
		
		boolean status = false;
		for(WebElement ele:allHeaders) {
			String value = ele.getText();
			System.out.println(value);
			if(value.contains(" Stuffed Frog")) {
				status = true;
				break;
			}
		}
		
//		Assert.assertEquals(status, "status is false");
		
		float sum = 0;
		
		for (int i =1; i<=numofRows.size(); i++) {
					
					
					for(int j=1; j<allHeaders.size(); j++) {	
						
						String table_data = driver.findElement(By.xpath("/html/body//form/table/tbody/tr["+ i +"]/td[1]")).getText();
						System.out.println("item for row "+ i +" is " + table_data);
						
						String get_price = driver.findElement(By.xpath("/html/body//form/table/tbody/tr["+ i +"]/td[2]")).getText();
						System.out.println("Price for "+ table_data + " is " + get_price);
						String num_price = get_price.replaceAll("[$]", "");
						
						String get_qty = driver.findElement(By.xpath("/html/body//form/table/tbody/tr["+ i +"]/td[3]/input")).getAttribute("value");
						System.out.println("Quantity for "+ table_data + " is " + get_qty);
						
						if(get_qty.equals(details.get("stuffed_frog")))
						{
							System.out.println("Quantity for " + table_data + " is correct");
						}
						
						else if(get_qty.equals(details.get("fluffy_bunny")))
						{
							System.out.println("Quantity for " + table_data + " is correct");
						}
						
						else if(get_qty.equals(details.get("valentine_bear")))
						{
							System.out.println("Quantity for " + table_data + " is correct");
						}
						
						else {
							System.out.println("Quantity for " + table_data + " is incorrect");
						}
						
						String subtotal = driver.findElement(By.xpath("/html/body//form/table/tbody/tr["+ i +"]/td[4]")).getText();
						
						String num_subtotal = subtotal.replaceAll("[$]","");
						
						System.out.println ("subtotal is " + num_subtotal);
						
						final DecimalFormat decfor = new DecimalFormat("0.00");  
						
						float exp_subtotal = Float.parseFloat(num_price) * Integer.parseInt(get_qty);
						System.out.println ("Expected subtotal is " + decfor.format(exp_subtotal));
						
						String str_exp_subtotal = decfor.format(exp_subtotal);
						float exp_subtotal_final = Float.parseFloat(str_exp_subtotal);
						
						float act_subtotal = Float.parseFloat(num_subtotal);
						System.out.println ("Actual subtotal is " + act_subtotal);
						
						if(exp_subtotal_final == act_subtotal)
						{
							System.out.println("Subtotal is correct");
						}
						
						else {
							System.out.println("Subtotal is not correct");
						}
						
								
						Thread.sleep(2000);
						
						// Calculate total
						
						Scanner input = new Scanner(System.in);
						
						System.out.print("Enter the result of iteration, Expected Subtotal " + i + ": ");
			            float exp_total_loop = input.nextFloat();
			            
			            sum += exp_total_loop;
			            
			            System.out.println("Current sum is: " + sum);
						
						String act_total = driver.findElement(By.xpath("/html/body//form/table/tfoot/tr[1]/td/strong")).getText();
						
						String str_act_total = act_total.replaceAll("Total: ", "");
						
						float num_act_total = Float.parseFloat(str_act_total);
						
						System.out.println("actual total is " +num_act_total);
						
						
						if (sum == num_act_total ) {
							System.out.println("Expected toatl is equal to actual total");
						}
						else {
							System.out.println("Expected toatl is not equal to actual total");
						}
						
						break;
						
					}				
				
		
				}
		}

	
}



	
