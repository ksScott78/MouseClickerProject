import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DatePickerTest {
    private String url = "http://demoqa.com/draggable/";
    private static WebDriver webDriver;
    private Actions builder;
    private DatePickerPage date;

    private void moveAndClick(WebElement el, int offX, int offY){
        builder.moveByOffset(offX,offY).click().release().perform();
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        builder = new Actions(webDriver);
        date = PageFactory.initElements(webDriver, DatePickerPage.class);

    }

    @AfterClass
    public static void destroy(){
        webDriver.quit();
    }


}
