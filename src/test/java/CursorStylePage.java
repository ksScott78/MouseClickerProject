import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursorStylePage {

    @FindBy(css="#drag > p")
    WebElement centreCursor;

    @FindBy(css="#drag2 > p")
    WebElement topLeftCursor;

    @FindBy(css="#drag3 > p")
    WebElement buttomCursor;

    @FindBy(css="#ui-id-3")
    WebElement nextTest;

    public void nextTest(){
        nextTest.click();
    }

}
