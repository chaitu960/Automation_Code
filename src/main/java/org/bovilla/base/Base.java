package org.bovilla.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver startDriver(String browserName) throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\details.properties");

		prop.load(fis);

		if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("Mozilla")) {
			WebDriverManager.firefoxdriver().setup();
		}

		return driver;

	}

}
