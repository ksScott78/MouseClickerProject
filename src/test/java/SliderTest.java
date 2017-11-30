import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SliderTest {

    private String url = "http://demoqa.com/draggable/";
    private static WebDriver webDriver;
    private Actions builder;
    private SliderPage slider;


    private void grabAndMove(WebElement el, int offX, int offY) {
        builder.clickAndHold(el).moveByOffset(offX, offY).release().perform();
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        builder = new Actions(webDriver);
        slider = PageFactory.initElements(webDriver,SliderPage.class);
    }

    @AfterClass
    public static void destroy(){
        webDriver.quit();
    }

    @Test
    public void sliderTest(){
        slider.nextTest();

        grabAndMove(slider.sliderGrab,-50,0);
        String moveNumber1 = slider.getNumber();
        Assert.assertEquals("1", moveNumber1);

        grabAndMove(slider.sliderGrab,50,0);
        String initialNumber = slider.getNumber();
        Assert.assertEquals("2", initialNumber);

        grabAndMove(slider.sliderGrab,50,0);
        String moveNumber = slider.getNumber();
        Assert.assertEquals("3", moveNumber);

        grabAndMove(slider.sliderGrab,50,0);
        String moveNumber2 = slider.getNumber();
        Assert.assertEquals("4", moveNumber2);

        grabAndMove(slider.sliderGrab,50,0);
        String moveNumber3 = slider.getNumber();
        Assert.assertEquals("5", moveNumber3);

        grabAndMove(slider.sliderGrab,500,0);
        String moveNumber10 = slider.getNumber();
        Assert.assertEquals("10", moveNumber10);
    }
}