package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage {
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;


    @FindBy(xpath = "//button[@aria-label ='Show menu']")
    WebElement btnMenuDots;
    @FindBy(xpath = "//div[text() ='Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid ='popover-close-board-confirm']")
    WebElement btnCloseConfirm;
    @FindBy(xpath = "//button[@data-testid ='close-board-delete-board-button']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//button[@data-testid ='close-board-delete-board-confirm-button']")
    WebElement getBtnDeleteBoardConfirm;


    public void deleteBoard() {
        clickWait(btnMenuDots, 5);
        clickWait(btnCloseBoard, 5);
        clickWait(btnCloseConfirm, 5);
//        clickWait(btnMenuDots, 5);
//        clickWait(btnCloseBoard,5);
//        clickWait(getBtnDeleteBoardConfirm,5);
    }


    public boolean validateBoardName(String text, int time) {
        return validateTextElementWait(boardName, text, time);
    }

}
