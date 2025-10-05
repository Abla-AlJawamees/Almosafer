import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String WebSiteURL = "https://global.almosafer.com/en";

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();
		driver.get(WebSiteURL);
		WebElement ButtonForTheCurrency = driver.findElement(By.id("mui-4"));
		ButtonForTheCurrency.click();

	}

	@Test(priority = 1)
	public void ChekTheEnglishLanguageIsDefult() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2)
	public void CheckTheDefaultCurrencyIsSAR() {
		String ActualCurrency = driver.findElement(By.cssSelector(".__ds__comp.MuiBox-root.alm-desktop-1282bi2"))
				.getText();
		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckContactNumber() {
		String ActualNumber = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-h0bow9"))
				.getText();
		String ExpectedNumber = "+966554400000";
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4)
	public void CheckQitafLogoIsThereInTheFooter() {
		boolean ActualResult = driver.findElement(By.cssSelector(".alm-desktop-1mqexmc-acceptedCards")).isDisplayed();
		boolean ExpectedResult = true;
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("tab-hotels"));
		String ActualValue = HotelTab.getAttribute("aria-selected");
		String ExpectedValue = "false";
		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 6)
	public void CheckDepartureDate() {
		int today = LocalDate.now().getDayOfMonth();
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();

		String ActualDeparture = driver.findElement(By.cssSelector("#testIdPickerPrefix__DatePicker__DepartureDate"))
				.getAttribute("value");
		Assert.assertTrue(ActualDeparture.contains(Integer.toString(Tomorrow)),
				"Departure date does not match expected tomorrow's date");
	}

	@Test(priority = 7)
	public void CheckReturnDate() {
		int today = LocalDate.now().getDayOfMonth();
		int AfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();

		String ActualCheckReturnDate = driver
				.findElement(By.cssSelector("#testIdPickerPrefix__DatePicker__ArrivalDate")).getAttribute("value");
		Assert.assertTrue(ActualCheckReturnDate.contains(Integer.toString(AfterTomorrow)),
				"Return date does not match expected tomorrow's date");
	}

}
