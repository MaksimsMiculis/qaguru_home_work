import okhttp3.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;


public class TVNetArticleTest {

    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_TITLE_HOME_PAGE = By.xpath(".//span [contains(@class, 'list-article__headline')]");
    private final By ARTICLE_COMMENTS_HOME_PAGE = By.xpath(".//span [contains(@class, 'list-article__comment')]");
    private final By ARTICLE_TITLE_ARTICLE_PAGE = By.xpath(".//h1 [contains (@class, 'article-headline')]");
    private final By ARTICLE_COMMENTS_ARTICLE_PAGE = By.xpath(".//span [contains(@class, 'article-share__item--count')]");
    private final By ARTICLE_COMMENTS_COMMENT_PAGE = By.xpath(".//span [contains (@class, 'article-comments-heading__count')]");
    private final Logger LOGGER = LogManager.getLogger(TVNetArticleTest.class);


    @Test
    public void tvnetSecondTitle() {

        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.tvnet.lv");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ALL_ARTICLES));

        //find all articles, choose second, get title text, get comment count
        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        WebElement secondArticle = articles.get(1);
        String secondArticleTextHomePage = secondArticle.findElement(ARTICLE_TITLE_HOME_PAGE).getText();
        LOGGER.info("Second article title home page: " + secondArticleTextHomePage);

        if (secondArticle.findElements(ARTICLE_COMMENTS_HOME_PAGE).size() != 0) {
            String commentCount = secondArticle.findElement(ARTICLE_COMMENTS_HOME_PAGE).getText().replaceAll(("[^0-9]"), "");
            int commentCountIntHomePage = Integer.parseInt(commentCount);
            LOGGER.info("Comment count home page: " + commentCountIntHomePage);

        }

        secondArticle.click();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE_ARTICLE_PAGE));

        WebElement secondArticleTitle = driver.findElement(ARTICLE_TITLE_ARTICLE_PAGE);
        String secondArticleTitleArticlePage = secondArticleTitle.getText();
        LOGGER.info("Second article title article page: " + secondArticleTitleArticlePage);

        List<WebElement> commentCountArticlePageEl = driver.findElements(ARTICLE_COMMENTS_ARTICLE_PAGE);
        String commentCountArticlePageHeaderText = commentCountArticlePageEl.get(1).getText().replaceAll(("(^0-9)"), "");
        int commentCountArticlePageHeaderInt = Integer.parseInt(commentCountArticlePageHeaderText);
        LOGGER.info("Comment count article page header: " + commentCountArticlePageHeaderInt);

        String commentCountArticlePageFooterText = commentCountArticlePageEl.get(3).getText().replaceAll("(^0-9)", "");
        int commentCountArticlePageFooterInt = Integer.parseInt(commentCountArticlePageFooterText);
        LOGGER.info("Comment count article page footer: " + commentCountArticlePageFooterInt);




        WebElement commentCountArticlePage = commentCountArticlePageEl.get(1);
        commentCountArticlePage.click();

        WebElement secondArticleTitleCommentPage = driver.findElement(ARTICLE_TITLE_ARTICLE_PAGE);
        String secondArticleTitleCommentPageTex = secondArticleTitleCommentPage.getText();
        LOGGER.info("Second article title comment page: " + secondArticleTitleCommentPageTex);

        WebElement commentCountCommentPage = driver.findElement(ARTICLE_COMMENTS_COMMENT_PAGE);
        String commentCountCommentPageText = commentCountCommentPage.getText().replaceAll("(^0-9)", "");
        int commentCountCommentPageInt = Integer.parseInt(commentCountCommentPageText);
        LOGGER.info("Comment count comment page: " + commentCountCommentPageInt);


    }
}
