package org.bovilla.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keyhighlights {

	public WebDriver driver;

	private By filterBar = By.xpath("//div[@class='c-tag-picker__display form-control']");
	private By filterOptionDigital = By.xpath("//button[@value='digital']");
	private By filterOptionRadio = By.xpath("//button[@value='radio']");
	private By filterOptionTV = By.xpath("//button[@value='tv']");
	private By filterOptionInf = By.xpath("//button[@value='influencer']");
	private By applyFilter = By.xpath("//input[@class='btn btn-sme']");
	private By searchResults = By.xpath("//div[@class='col-md-4']//a");

	public Keyhighlights(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getFilterBar() {
		return driver.findElement(filterBar);
	}

	public WebElement getApplyFilter() {
		return driver.findElement(applyFilter);
	}

	public List<WebElement> getSearchResults() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(searchResults)));
		return driver.findElements(searchResults);
	}

	// Generic method to select the filter option using testng parameters
	public WebElement getFilterOption(String filterType) {
		WebElement el = null;

		/*
		 * if(filterType.equalsIgnoreCase("Digital")) { el=
		 * driver.findElement(filterOptionDigital); }
		 * if(filterType.equalsIgnoreCase("TV")) { el=
		 * driver.findElement(filterOptionTV); }
		 * if(filterType.equalsIgnoreCase("Radio")) { el=
		 * driver.findElement(filterOptionRadio); }
		 * if(filterType.equalsIgnoreCase("Influencer")) { el=
		 * driver.findElement(filterOptionInf); } return el;
		 */

		switch (filterType) {
		case "Radio":
			el = driver.findElement(filterOptionRadio);
			break;
		case "Tv":
			el = driver.findElement(filterOptionTV);
			break;
		case "Digital":
			el = driver.findElement(filterOptionDigital);
			break;
		case "Influencer":
			el = driver.findElement(filterOptionInf);
			break;
		}
		return el;

	}
}
