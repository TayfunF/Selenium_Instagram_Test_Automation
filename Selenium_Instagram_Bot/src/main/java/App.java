import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    WebDriver Driver;
    String BaseURL = "https://www.instagram.com/";

    By UserNameLocator = new By.ByCssSelector("input[name='username']");
    By PasswordLocator = new By.ByCssSelector("input[name='password']");
    By LoginButtonLocator = new By.ByCssSelector("button[type='submit']");
    By InstagramHomeLogoLocator = new By.ByClassName("s4Iyt");
    By ProfileNameLocator = new By.ByClassName("CfWVH");
    By PostLocator = new By.ByClassName("_9AhH0");
    By LikeButtonLocator = new By.ByCssSelector("span.fr66n");
    By AllPostCountLocator = new By.ByClassName("g47SY");
    By HtmlTagLocator = new By.ByTagName("html");

    public App() {
        WebDriverManager.chromedriver().setup();
        Driver = new ChromeDriver();
        Driver.get(BaseURL);
        Driver.manage().window().maximize();
    }

    public void LoginWith(String UserName, String Password) {
        WaitForFiveSeconds(UserNameLocator);
        Driver.findElement(UserNameLocator).sendKeys(UserName);
        Driver.findElement(PasswordLocator).sendKeys(Password);
        Driver.findElement(LoginButtonLocator).click();
    }

    public void NavigationToProfile(String ProfileName) {
        WaitForFiveSeconds(InstagramHomeLogoLocator);
        Driver.navigate().to(BaseURL.concat(ProfileName));
    }

    public void ClickFirstPost() {
        WaitForFiveSeconds(ProfileNameLocator);
        Driver.findElements(PostLocator).get(0).click();
    }

    public void LikeAllPost() {
        int Count = GetPostCount();
        while (Count > 0) {
            WaitForFiveSeconds(LikeButtonLocator);
            Driver.findElement(LikeButtonLocator).click();
            Driver.findElement(HtmlTagLocator).sendKeys(Keys.ARROW_RIGHT);
            Count--;
        }

    }

    private int GetPostCount() {
        String Count = Driver.findElement(AllPostCountLocator).getText();
        return Integer.parseInt(Count);
    }

    private void WaitForFiveSeconds(By Locator) {
        WebDriverWait Wait = new WebDriverWait(Driver, Duration.ofSeconds(5));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }
}
