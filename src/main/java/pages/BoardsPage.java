package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//button[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTyping;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnSubmitCreateBoard;
    @FindBy(xpath = "//div[@class='B1uWdim9Jd0dJ9']")
    WebElement btnAccount;
    @FindBy(xpath = "//a//span[text()='Manage account']")
    WebElement btnManageAccount;
    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement popUpMessageBoardDelete;




    public void openMyAccount() {
        clickWait(btnAccount, 3);
        clickWait(btnManageAccount, 3);
    }

    public void createNewBoard(Board board) {
        btnCreateNewBoard.click();
        inputBoardTyping.sendKeys(board.getBoardTitle());
        clickWait(btnSubmitCreateBoard, 8);
    }

    public void createNewBoardNegative(Board board) {
        btnCreateNewBoard.click();
        inputBoardTyping.sendKeys(board.getBoardTitle());


    }


    public boolean validateUrl() {

        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("boards"));
    }

    public boolean buttonCreateIsNotClickable() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(btnSubmitCreateBoard)));
    }
}
