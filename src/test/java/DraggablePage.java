import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage {

    @FindBy(css = "#draggable")
    WebElement box;

    public int getPosX(){
        return box.getLocation().getX();
    }

    public int getPosY(){
        return box.getLocation().getY();
    }


}
