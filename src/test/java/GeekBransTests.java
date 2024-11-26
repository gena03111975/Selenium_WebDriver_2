import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeekBransTests {

    @Test
    void loginTest(){
        String pathToChromeDriver = "src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://test-stand.gb.ru/login");
//        WebElement usernameField = driver.findElement(By.cssSelector("form#login input[type='text']"));
//        WebElement passwordField = driver.findElement(By.cssSelector("form#login input[type='password']"));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='text']")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='password']")));


       // final String USERNAME = System.getProperty("geekbrains_username", System.getenv("geekbrains_username"));
       // final String PASSWORD = System.getProperty("geekbrains_password", System.getenv("geekbrains_password"));

        usernameField.sendKeys(System.getProperty("geekbrains_username", System.getenv("geekbrains_username")));
        passwordField.sendKeys(System.getProperty("geekbrains_password", System.getenv("geekbrains_password")));

        WebElement loginButton = driver.findElement(By.cssSelector("form#login button"));
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loginButton));

//        WebElement usernameLink = driver.findElement(
//                By.partialLinkText(System.getProperty("geekbrains_username", System.getenv("geekbrains_username"))));
//
//
        WebElement usernameLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(
                        System.getProperty("geekbrains_username", System.getenv("geekbrains_username")))));
        String actualUsername = usernameLink.getText().replace("\n", " ").trim();


        Assertions.assertEquals(
                String.format("Hello, %s", System.getProperty("geekbrains_username", System.getenv("geekbrains_username"))),
                actualUsername);

        driver.quit();
    }
}
