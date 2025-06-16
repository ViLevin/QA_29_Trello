package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import static utils.RandomUtils.*;

public class DeleteBoardTest extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login() {
        User user = User.builder().email("vilevinqa@gmail.com")
                .password("Cjytxrf2003")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder().boardTitle(generateString(7)).build();
        boardsPage.createNewBoard(board);
    }

    @Test
    public void deleteBoardPositiveTest() {
        new MyBoardPage(getDriver()).deleteBoard();
    }


}
