package tests;

import dto.Board;
import dto.User;
import lombok.Builder;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class BoardsTests extends AppManager {

    @BeforeMethod
    public void login() {
        User user = User.builder().email("vilevinqa@gmail.com")
                .password("Cjytxrf2003")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);

    }


    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder()
                .boardTitle("123")
                .build();
        new BoardsPage(getDriver()).createNewBoard(board);

        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName("123", 10));
    }
}
