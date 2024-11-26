package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Experiments
{
    public static void main( String[] args ) {
        String pathToChromeDriver = "src\\main\\resources\\chromedriver.exe";
        String pathToGeckoDriver = "src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        System.setProperty("webdriver.firefox.driver", pathToGeckoDriver);

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--start-maximized");

//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
//         WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());
        driver.quit();
    }
}
