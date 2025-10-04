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
		String ActualCurrency = driver.findElement(By.cssSelector(".__ds__comp.MuiBox-root.alm-desktop-1282bi2")).getText();
		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckContactNumber() {
		String ActualNumber = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-h0bow9")).getText();
		String ExpectedNumber = "+966554400000";
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}
	@Test (priority = 4)
	public void  ChechQitafLogoIsThereInTheFooter() {
	boolean ActualResult =	driver.findElement(By.cssSelector(".alm-desktop-1mqexmc-acceptedCards")).isDisplayed();
	boolean ExpectedResult = true;
	Assert.assertEquals(ActualResult, ExpectedResult);

	}
	

}
