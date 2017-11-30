import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage {

    @FindBy(css="#slider-range-max > span")
    WebElement sliderGrab;

    @FindBy(css="#menu-item-97 > a")
    WebElement sliderPageLink;

    @FindBy(id = "amount1")
    WebElement number;

    public void nextTest(){
        sliderPageLink.click();
    }

    public String getNumber(){
        return number.getAttribute("value");
    }
}
