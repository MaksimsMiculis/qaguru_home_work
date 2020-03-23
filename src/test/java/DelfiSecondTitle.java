//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
////----------------ДОПИЛИТЬ----------------------------
////    StaleElementReferenceException
////    try catch modal window
//// if cannot find  comment count element = comment count 0
//------------------------------------------------------
////final это константа, меняем название на КАПС с андерскорами между словами
////если список вернулся пустым, значит комментариев 0
//
//
//public class DelfiSecondTitle {
//
//
//    private final By ARTICLE_TITLE_HOME_PAGE = By.xpath(".//h1[contains(@class, 'headline__title')]");
//    private final By ARTICLE_TITLE_ARTICLE_PAGE = By.xpath(".//h1[contains (@class, 'd-inline')]");
//    private final By COMMENT_COUNT_HOME_PAGE = By.xpath(".//a[contains(@class, 'comment-count')]");
//    private final By COMMENT_COUNT_ARTICLE_PAGE = By.xpath(".//a [contains (@class, 'd-print-none')]");
//    private final By COMMENT_COUNT_ANON_AND_REG = By.xpath(".//span [contains (@class, 'type-cnt')]");
//    private final Logger LOGGER = LogManager.getLogger(DelfiSecondTitle.class);
//
//
//    @Test
//    public void delfiCompareSecondTitle() {
//        LOGGER.info("Setting up driver path");
//        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
//        LOGGER.info("Opening browser");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://www.delfi.lv");
////
//
//        List<WebElement> articles = driver.findElements(ARTICLE_TITLE_HOME_PAGE);
//
//        //        for (int i = 0; i < articles.size(); i++) {
////
////        if (articles.get(i).getText().length() != 0) {
////                System.out.println(i + ": " + articles.get(i).getText());
////               System.out.println(articles.size());
////        }
////        }
//
//        String secondArticleTitle = articles.get(1).getText();
//        LOGGER.info("Article title on home page: " + secondArticleTitle);
//
//        articles.get(1).click();
//        WebElement secondArticleTitleElement = driver.findElement(ARTICLE_TITLE_ARTICLE_PAGE);
//        String secondArticleTitleText = secondArticleTitleElement.getText();
//        LOGGER.info("Article title on article's page: " + secondArticleTitleText);
//        Assertions.assertEquals(secondArticleTitle, secondArticleTitleText, "Titles are not equals");
//
//
//        driver.get("http://www.delfi.lv");
//        List<WebElement> commentCount = driver.findElements(COMMENT_COUNT_HOME_PAGE);
//        String commentCountSecondArticleHomePageString = commentCount.get(1).getText().replaceAll("\\D", "");
//        int commentCountSecondArticleHomePageInt = Integer.parseInt(commentCountSecondArticleHomePageString);
//        LOGGER.info(commentCountSecondArticleHomePageInt + " article's comments on Home page");
//
//        List<WebElement> articles2 = driver.findElements(ARTICLE_TITLE_HOME_PAGE);
//        articles2.get(1).click();
//        WebElement commentCountSecondArticlePage = driver.findElement(COMMENT_COUNT_ARTICLE_PAGE);
//        String commentCountSecondArticlePageString = commentCountSecondArticlePage.getText().replaceAll("\\D", "");
//        int commentCountSecondArticlePageInt = Integer.parseInt(commentCountSecondArticlePageString);
//        LOGGER.info(commentCountSecondArticlePageInt + " comments on the article's page");
//
//        commentCountSecondArticlePage.click();
//        List<WebElement> commentCountAnonAndReg = driver.findElements(COMMENT_COUNT_ANON_AND_REG);
//        String commentCountAnonString = commentCountAnonAndReg.get(0).getText().replaceAll("\\D", "");
//        int commentCountAnonInt = Integer.parseInt(commentCountAnonString);
//        LOGGER.info(commentCountAnonInt + " anonymous comments");
//
//        String commentCountRegString = commentCountAnonAndReg.get(1).getText().replaceAll("\\D", "");
//        int commentCountRegInt = Integer.parseInt(commentCountRegString);
//        LOGGER.info(commentCountRegInt + " registered comments");
//
//        int commentCountSum = commentCountAnonInt + commentCountRegInt;
//        LOGGER.info(commentCountSum + " comment Sum");
//
//        if ((commentCountSecondArticleHomePageInt == commentCountSecondArticlePageInt) && (commentCountSecondArticlePageInt == commentCountSum)) {
//            LOGGER.info("Comment count is equal");
//        } else {
//            LOGGER.info("Comment count is not equal");
//        }
//
//
//    }
//}
//
//
////
//////1. Find comments count elements on home page
//////2. Get second's articles comment number and save to String only number
//////3. Click on the second article
//////4. Get Articles Comment Number and save to String only number
//////5. Click on comment number
//////6. Get and save comment numbers of anonymous and registred users
//////7. Summ anonymus and registred comments
//////8. Compare comment count from home page, article page and comment page.
////
////
//////Find first article title
////// WebElement firstArticleTitle = driver.findElement(HOME_PAGE_ARTICLE);
//////Get text and save it
////// String firstArticleTitleText = firstArticleTitle.getText();
//////Click on first article title
//////  firstArticleTitle.click();
//////Find article title
//////  WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
//////Get text and save"
////// String articleTitleText = articleTitle.getText();
//////Check (compare) both titles
//////  Assertions.assertEquals(firstArticleTitleText, articleTitleText, "Titles are not equals");
