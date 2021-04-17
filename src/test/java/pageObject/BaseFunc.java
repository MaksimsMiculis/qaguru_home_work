package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
//в каждом классе должен быть свой логгер
// A B тест, что бы ты изменил на каком то сайте, обоснованное
//xmind facebook только тулбар, остальное без мелочей. Большие сайты
// на каждой странице свой локатор
//в локаторе contains не нужен в классе если там один объект
public class BaseFunc {
    private final String HOME_PAGE_URL = "delfi.lv";
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);


    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
            //! - ne. esli ssilka ne na4inaetsa s http i ne na4inaetsa s https, to dobavljaem http://

        }

        driver.get(url);

    }

    public void openHomePage() {
        goToUrl(HOME_PAGE_URL);
//        driver.get(HOME_PAGE_URL);


    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);


    }

    public WebElement findElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);


    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }


}