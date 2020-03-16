import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

//если список вернулся пустым, значит комментариев 0
public class DelfiSecondTitle {
    private final By HOME_PAGE_SECOND_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By SECOND_ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains (@class, 'd-inline')]");
    private final By COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By COMMENT_COUNT_SECOND_ARTICLE_PAGE = By.xpath(".//a [contains (@class, \"d-print-none\")]");
    private final By COMMENT_COUNT_ANON_AND_REG = By.xpath(".//span [contains (@class, 'type-cnt')]");
    private final Logger LOGGER = LogManager.getLogger(DelfiSecondTitle.class);
//    private final By SECOND_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    //final это константа, меняем название на КАПС с андерскорами между словами
    @Test
    public void delfiCompareSecondTitle() throws InterruptedException {
        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.delfi.lv");


        List<WebElement> articles = driver.findElements(HOME_PAGE_SECOND_ARTICLE);
        for (int i = 0; i < articles.size(); i++) {

            if (articles.get(i).getText().length() != 0) {
//                System.out.println(i + ": " + articles.get(i).getText());
//                System.out.println(articles.size());
            }
        }
//
//        String secondArticleTitle = articles.get(1).getText();
//        System.out.println(secondArticleTitle);
//
//
//        articles.get(1).click();
//        WebElement secondArticleTitleElement = driver.findElement(SECOND_ARTICLE_PAGE_TITLE);
//        String secondArticleTitleText = secondArticleTitleElement.getText();
//        System.out.println(secondArticleTitleText);
//        Assertions.assertEquals(secondArticleTitle, secondArticleTitleText, "Titles are not equals");

//
//        driver.navigate().to("http://www.delfi.lv");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.findElement(HOME_PAGE_SECOND_ARTICLE);

        List<WebElement> commentCount = driver.findElements(By.xpath(String.valueOf(COMMENT_COUNT)));
        String commentCountSecondArticleHomePageString = commentCount.get(1).getText().replaceAll("\\D", "");
        int commentCountSecondArticleHomePageInt = Integer.parseInt(commentCountSecondArticleHomePageString);
        System.out.println(commentCountSecondArticleHomePageInt + " comments on the second article on Home page");

        articles.get(1).click();
        WebElement commentCountSecondArticlePage = driver.findElement(By.xpath(String.valueOf(COMMENT_COUNT_SECOND_ARTICLE_PAGE)));
        String commentCountSecondArticlePageString = commentCountSecondArticlePage.getText().replaceAll("\\D", "");
        int commentCountSecondArticlePageInt = Integer.parseInt(commentCountSecondArticlePageString);
        System.out.println(commentCountSecondArticlePageInt + " comments on the second article page");

        commentCountSecondArticlePage.click();
        List<WebElement> commentCountAnonAndReg = driver.findElements(By.xpath(String.valueOf(COMMENT_COUNT_ANON_AND_REG)));
        String commentCountAnonString = commentCountAnonAndReg.get(0).getText().replaceAll("\\D", "");
        int commentCountAnonInt = Integer.parseInt(commentCountAnonString);
        System.out.println(commentCountAnonInt + " anonymous comments");

        String commentCountRegString = commentCountAnonAndReg.get(1).getText().replaceAll("\\D", "");
        int commentCountRegInt = Integer.parseInt(commentCountRegString);
        System.out.println(commentCountRegInt + " registered comments");

        int commentCountSum = commentCountAnonInt + commentCountRegInt;
        System.out.println(commentCountSum + " comment Sum");

        if ((commentCountSecondArticleHomePageInt == commentCountSecondArticlePageInt) && (commentCountSecondArticlePageInt == commentCountSum)) {
            System.out.println("Comment count is equal");
        } else {
            System.out.println("Comment count is not equal");
        }

    }
}



//1. Find comments count elements on home page
//2. Get second's articles comment number and save to String only number
//3. Click on the second article
//4. Get Articles Comment Number and save to String only number
//5. Click on comment number
//6. Get and save comment numbers of anonymous and registred users
//7. Summ anonymus and registred comments
//8. Compare comment count from home page, article page and comment page.


//Find first article title
// WebElement firstArticleTitle = driver.findElement(HOME_PAGE_ARTICLE);
//Get text and save it
// String firstArticleTitleText = firstArticleTitle.getText();
//Click on first article title
//  firstArticleTitle.click();
//Find article title
//  WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
//Get text and save"
// String articleTitleText = articleTitle.getText();
//Check (compare) both titles
//  Assertions.assertEquals(firstArticleTitleText, articleTitleText, "Titles are not equals");
