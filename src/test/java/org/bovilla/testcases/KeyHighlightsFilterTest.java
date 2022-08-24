package org.bovilla.testcases;

import java.io.IOException;
import java.util.List;

import org.bovilla.base.Base;
import org.bovilla.pageobjects.Keyhighlights;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KeyHighlightsFilterTest extends Base {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest()
	public void driverIntialization(String browser) throws IOException {
		driver = startDriver(browser);
		driver.manage().window().maximize();

	}

	@Parameters({ "filterType", "searchCount" })
	@Test
	public void keyHighlightsPageNavigation(String filterType, String searchCount) throws IOException {
		driver.get(prop.getProperty("url"));
		Keyhighlights kh = new Keyhighlights(driver);
		kh.getFilterBar().click();
		kh.getFilterOption(filterType).click();
		kh.getApplyFilter().click();
		List<WebElement> ls = kh.getSearchResults();
		System.out.println(ls.size());
		Assert.assertEquals(ls.size(), searchCount);

	}

	@AfterTest
	public void closeBrowser() {

		driver.quit();

	}

}
