package diary.ru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Diary {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    private static final String USER_LOGIN = "mcfly123";
    private static final String USER_PASSWORD = "9feede1fe";

   // Запуски в тестах без асертов.

    public void login() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);

        WebElement openCommon = driver.findElement(By.cssSelector("#drop-login"));
        openCommon.click();

        WebElement fillLogin = driver.findElement(By.cssSelector("#usrlog2"));
        fillLogin.sendKeys(USER_LOGIN);

        WebElement fillPass = driver.findElement(By.cssSelector("#usrpass2"));
        fillPass.sendKeys(USER_PASSWORD);

        WebElement loginButton = driver.findElement(By.cssSelector("#loginform > form > button"));
        loginButton.click();

    }

    public void registration() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);

        WebElement regButton = driver.findElement(By.cssSelector("#body > div.navbar.navbar-inverse > div > ul.nav.navbar-nav.navbar-index > li:nth-child(2) > a"));
        regButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/create"));
        // что я только тут не пробовал не хочет он работать.
        // В FF селениум последовательность проходит полностью, а в хром спотыкается.
        WebElement regName = driver.findElement(By.id("usrlog"));
        regName.click();
        regName.sendKeys("randomusername12312");

        WebElement regEmail = driver.findElement(By.xpath("//*[@id=\"usremail\"]"));
        regEmail.sendKeys("randomusername12312@mail.ru");

        WebElement offerCheckBox = driver.findElement(By.cssSelector("#modal-register > div > div > div.modal-body > form:nth-child(2) > label > input[type=checkbox]"));
        offerCheckBox.click();

        WebElement regButtonFinal = driver.findElement(By.cssSelector("#modal-register > div > div > div.modal-body > form:nth-child(2) > button"));
        regButtonFinal.click();


    }
}
