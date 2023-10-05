package testpractice4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class saucedemo4 {
	
        public static void main(String[] args) 	{
	
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\2252204\\Downloads\\Open Source_Google_Chrome Driver_114.0.5735.90_chromedriver_win32 (5) (1)\\chromedriver.exe");
         
       // Initialize the WebDriver
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
        
       // Navigate to the website      
       driver.get("https://www.saucedemo.com");
        
       //  fill in the username and password fields, then click the login button    
       WebElement usernameField = driver.findElement(By.id("user-name"));
       WebElement passwordField = driver.findElement(By.id("password"));
       WebElement loginButton = driver.findElement(By.id("login-button"));
     
       usernameField.sendKeys("standard_user");
       passwordField.sendKeys("secret_sauce");
       loginButton.click();
        
       // Verify the count of products is 6      
       int productCount = driver.findElements(By.className("inventory_item")).size();
       if (productCount == 6)
         {
     
       System.out.println("Product count is 6. Test passed!");
       
         }else {
        	 
       System.out.println("Product count is not 6. Test failed!");
       
         }
       
         // Check the price of Sauce Labs Backpack 
       
       WebElement backpackPrice = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
       backpackPrice.click();
       
       WebElement backpackPrice1 = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
       if (backpackPrice1.getText().equals("$29.99"))
         {
    	   
       System.out.println("Sauce Labs Backpack price is $29.99. Test passed!");
       
       } else {
    	   
       System.out.println("Sauce Labs Backpack price is not $29.99. Test failed!");
       
        }
       
       // Add Sauce Labs Backpack to the cart  
      WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
      addToCartButton.click();
      
         // Click on the cart       
      WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
      cartIcon.click();
      
         // Confirm Sauce Labs Backpack is added to the cart    
       WebElement cartItem = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
       if (cartItem.isDisplayed())
    	   
        {
    	   
      System.out.println("Sauce Labs Backpack is in the cart. Test passed!");
      
       }else {
    	   
       System.out.println("Sauce Labs Backpack is not in the cart. Test failed!");
       
       }
       
       // Click on Continue Shopping 
       WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
       continueShoppingButton.click();
       
        // Click Remove on the Sauce Labs Backpack  
       WebElement removeButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
       removeButton.click();
       
        // Access the menu on the left of the page  
      WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
      menuButton.click();
      
      // Click logout
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
       logout.click();
       
       // Close the browser 
      driver.quit();
      
       }
  }








