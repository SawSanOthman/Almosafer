import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	

WebDriver driver = new ChromeDriver();

String URL1 = "https://global.almosafer.com/en";
Random rand = new Random();	
String Url2 =" https://global.almosafer.com/ar";	
;
	
@BeforeTest	
public void SetUP() {

driver.manage().window().maximize();
driver.get(URL1);

WebElement ButtonForcurrancy =driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));

ButtonForcurrancy.click();

}

	
@Test(priority=1)	
public void CheckTheEnglishLanguageIsDeafult() {
	
String ActualResult = driver.findElement(By.tagName("html")).getAttribute("lang");	
String ExpectedResult = "en";
	
Assert.assertEquals(ActualResult,ExpectedResult );	
		
}	
	
@Test(priority=2)	
public void CheckTheCurrancyIsSAR() {
	
String ActualCurrancyResult= driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();	
String ExpectedCurrancyResult = "SAR";
	
Assert.assertEquals(ActualCurrancyResult,ExpectedCurrancyResult );	
	
	
}	
@Test(priority=3)	
public void CheckContactNumber() {
	
String ActualNumberResult= driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
	
String ExpectedNumberResult= "+966554400000";
	
Assert.assertEquals(ActualNumberResult, ExpectedNumberResult);	
	
	
}	
	
@Test(priority=4)	
public void CheckLogoQitaf() {
	
boolean ActualResult =driver.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs")).isDisplayed();	
boolean ExpectedResult = true;
	
Assert.assertEquals(ActualResult,ExpectedResult );	
		
}	

@Test(priority=5)
public void CheckHotelTabIsNotSelected() {
	WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	
	String Actualhotel =HotelTab.getAttribute("aria-selected");
	String Expectedhotel = "false";
		
}

@Test(priority=6)
public void CheckDeparturedate () {
	
	int Today = LocalDate.now().getDayOfMonth();
	int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
	
	String ActualDeparture = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
	
	String ExpectedDeparture = Integer.toString(Tomorrow);
	Assert.assertEquals(ActualDeparture, ExpectedDeparture);
	
	
}
@Test(priority=7)
public void CheckReturnDate() {
	
int Today = LocalDate.now().getDayOfMonth();	
	
int Afterdaytomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
	
String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText()	;
String ExpectedReturn = Integer.toString(Afterdaytomorrow)	;
Assert.assertEquals(ActualReturn,ExpectedReturn );

	
}
@Test(priority=8)
public void RandomlyChangeTheLanguage() throws InterruptedException {

	String [] WebSites= {"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
	
	
	int RandomIndex = rand.nextInt(WebSites.length);
	
	driver.get(WebSites[RandomIndex]);
	
	if(driver.getCurrentUrl().equals("https://global.almosafer.com/ar")) {
		
		String ActualLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");	
		String ExpectedLanguge = "ar";
			
		Assert.assertEquals(ActualLanguge,ExpectedLanguge);	
		Thread.sleep(3000);			
	}
	
	else {
		String ActualLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");	
		String ExpectedLanguge = "en";
			
		Assert.assertEquals(ActualLanguge,ExpectedLanguge);	
						
	}
	
}

@Test(priority=9)
public void HotelSearchTab() {
	
driver.get(URL1);

 driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();
String [] countries= {"Dubai","Jeddah","Riyad"};
	
int country =rand.nextInt(countries.length)	;
 driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']")).sendKeys(countries[country]);
	
}

@Test(priority=10)
public void hotelsearchtabar() throws InterruptedException {
	
driver.get(Url2);	
	
driver.findElement(By.cssSelector("body > div:nth-child(1) > section:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > a:nth-child(2) > div:nth-child(1)")).click();

String [] countries= {"جده","الرياض","دبي"};
	
int country =rand.nextInt(countries.length)	;
Thread.sleep(2000);
 driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input")).sendKeys(countries[country]);
	
}
	
@Test(priority=11)
public void selectroom() {
	
WebElement myroom= driver.findElement(By.xpath("//select[@class='sc-tln3e3-1 gvrkTi']"));	
	
Select selector = new Select(myroom)	;
	
selector.selectByIndex(0);	
	
}

@Test(priority=12)
public void clickonsearchbutton() {
	
WebElement hotelbutton=driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));	
hotelbutton.click();	
		
}

@Test

public void visalogo() {
	
	boolean Actualvisa =driver.findElement(By.cssSelector(".sc-kNBZmU.jEzChs")).isDisplayed();
	
	boolean Expectedvisa= true;
	
	Assert.assertEquals(Actualvisa, Expectedvisa);
	
}










	
}



	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


