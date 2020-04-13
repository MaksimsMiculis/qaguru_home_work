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

import java.util.List;


public class TVNetArticleTest {

    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_TITLE_HOME_PAGE = By.xpath(".//span [contains(@class, 'list-article__headline')]");
    private final By ARTICLE_COMMENTS_HOME_PAGE = By.xpath(".//span [contains(@class, 'list-article__comment')]");
    private final By ARTICLE_TITLE_ARTICLE_PAGE = By.xpath(".//h1 [contains(@class, 'article-superheader__headline')]");
    private final By ARTICLE_COMMENTS_ARTICLE_PAGE = By.xpath(".//span [contains(@class, 'article-share__item--count')]");
    private final By ARTICLE_COMMENTS_COMMENT_PAGE = By.xpath(".//span [contains (@class, 'article-comments-heading__count')]");
    private final By ARTICLE_TITLE_COMMENT_PAGE = By.xpath(".//h1 [contains(@class, 'article-headline')]");
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

//        WebDriverWait wait2 = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div [contains (@style, 'cursor' )]")));
//        WebElement closeBanner = driver.findElement(By.xpath(".//div [contains (@style, 'cursor' )]"));
//        closeBanner.click();


        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        WebElement secondArticle = articles.get(1);
        String secondArticleTitleHomePageText = secondArticle.findElement(ARTICLE_TITLE_HOME_PAGE).getText();
        LOGGER.info("Second article title home page: " + secondArticleTitleHomePageText);

        int commentCountHomePageInt = 0;
        if (secondArticle.findElements(ARTICLE_COMMENTS_HOME_PAGE).size() != 0) {
            String commentCount = secondArticle.findElement(ARTICLE_COMMENTS_HOME_PAGE).getText().replaceAll(("(^0-9)"), "");
            commentCountHomePageInt = Integer.parseInt(commentCount);
            LOGGER.info("Comment count home page: " + commentCountHomePageInt);


        }


        secondArticle.click();
        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE_ARTICLE_PAGE));

        WebElement secondArticleTitle = driver.findElement(ARTICLE_TITLE_ARTICLE_PAGE);
        String secondArticleTitleArticlePageText = secondArticleTitle.getText();
        LOGGER.info("Second article title article page: " + secondArticleTitleArticlePageText);

        List<WebElement> commentCountArticlePageEl = driver.findElements(ARTICLE_COMMENTS_ARTICLE_PAGE);
        String commentCountArticlePageHeaderText = commentCountArticlePageEl.get(0).getText().replaceAll(("(^0-9)"), "");
        int commentCountArticlePageHeaderInt = Integer.parseInt(commentCountArticlePageHeaderText);
        LOGGER.info("Comment count article page header: " + commentCountArticlePageHeaderInt);

        String commentCountArticlePageFooterText = commentCountArticlePageEl.get(1).getText().replaceAll("(^0-9)", "");
        int commentCountArticlePageFooterInt = Integer.parseInt(commentCountArticlePageFooterText);
        LOGGER.info("Comment count article page footer: " + commentCountArticlePageFooterInt);


        WebElement commentCountArticlePage = commentCountArticlePageEl.get(1);
        commentCountArticlePage.click();


        WebElement secondArticleTitleCommentPage = driver.findElement(ARTICLE_TITLE_COMMENT_PAGE);
        String secondArticleTitleCommentPageText = secondArticleTitleCommentPage.getText();
        LOGGER.info("Second article title comment page: " + secondArticleTitleCommentPageText);

        WebElement commentCountCommentPage = driver.findElement(ARTICLE_COMMENTS_COMMENT_PAGE);
        String commentCountCommentPageText = commentCountCommentPage.getText().replaceAll("(^0-9)", "");
        int commentCountCommentPageInt = Integer.parseInt(commentCountCommentPageText);
        LOGGER.info("Comment count comment page: " + commentCountCommentPageInt);


        Assertions.assertEquals(secondArticleTitleHomePageText, secondArticleTitleArticlePageText, "Article title home page and article page is not equal");
        Assertions.assertEquals(secondArticleTitleArticlePageText, secondArticleTitleCommentPageText, "Article title article page and article title comment page is not equal");

        Assertions.assertEquals(commentCountHomePageInt, commentCountArticlePageHeaderInt, "Home page, article page header comment count is not equal");
        Assertions.assertEquals(commentCountArticlePageHeaderInt, commentCountArticlePageFooterInt, "Article page Header and Footer comment count is not equal");
        Assertions.assertEquals(commentCountArticlePageFooterInt, commentCountCommentPageInt, "Arrticle page footer and comment page commemnt counnt is not equal");


    }
}
