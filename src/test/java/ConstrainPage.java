import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstrainPage {
    @FindBy(css ="#draggabl > p")
    WebElement verBox;

    @FindBy(css ="#draggabl2 > p")
    WebElement horBox;

    @FindBy(css="#draggabl3 > p")
    WebElement domBox1;

    @FindBy(css="#draggabl5")
    WebElement domBox2;

    @FindBy(css="#ui-id-2")
    WebElement nextTest;

    public void nextTest(){
        nextTest.click();
    }

    public int getX(WebElement el){
        return el.getLocation().getX();
    }

    public int getY(WebElement el){
        return el.getLocation().getY();
    }

}
