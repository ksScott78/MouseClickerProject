import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DraggableTest {

    private String url = "http://demoqa.com/draggable/";
    private static WebDriver webDriver;
    private Actions builder;
    private ConstrainPage con;
    private DraggablePage drag;
    private CursorStylePage cur;
    private int offX,offY;


    private void grabAndMove(WebElement el, int offX, int offY){
        builder.clickAndHold(el).moveByOffset(offX,offY).release().perform();
    }

    private void moveAndClick(WebElement target){
        builder.moveToElement(target).click().release().perform();
    }
    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        builder = new Actions(webDriver);
        con =  PageFactory.initElements(webDriver,ConstrainPage.class);
        drag = PageFactory.initElements(webDriver,DraggablePage.class);
        cur = PageFactory.initElements(webDriver,CursorStylePage.class);
    }

    @AfterClass
    public static void destroy(){
        webDriver.quit();
    }

    @Test
    public void defaultTest() {
        int X = drag.getPosX();
        int Y = drag.getPosY();
         offX = 200;
         offY = 300;
        grabAndMove(drag.box,offX,offY);
        Assert.assertEquals(drag.getPosX(),X+offX );
        Assert.assertEquals(drag.getPosY(), Y+offY);
    }

    @Test
    public void constrainMovDomBox1(){
        con.nextTest();
        int Y = con.getY(con.domBox1);
         offX = 200;
         offY = 0;
        grabAndMove(con.domBox1,offX,offY);
        int expectedX = 796;
        int expectedY = 562;
        Assert.assertEquals(expectedX,con.domBox1.getLocation().getX());
        Assert.assertEquals(expectedY,Y);
    }

    @Test
    public void constrainMovDomBox2(){
        con.nextTest();
        int X = con.getX(con.domBox2);
        builder.clickAndHold(con.domBox2).moveByOffset(0,200).release().perform();
        int expectedX = 696;
        int expectedY = 562;
        Assert.assertEquals(expectedX,X);
        Assert.assertEquals(expectedY,con.domBox1.getLocation().getY());
    }

    @Test
    public void constrainMovHorBox(){
        con.nextTest();
         offX = 300;
         offY = 0;
        int X = con.getX(con.horBox);
        int Y = con.getY(con.horBox);
        grabAndMove(con.horBox,offX,offY);
        Assert.assertEquals(con.getX(con.horBox),X + offX);
        Assert.assertEquals(con.getY(con.horBox),Y);
    }


    @Test
    public void constrainMovVerBox(){
        con.nextTest();
        offY = 300;
        int X = con.getX(con.verBox);
        int Y = con.getY(con.verBox);
        grabAndMove(con.verBox,0,offY);
        Assert.assertEquals(con.getX(con.verBox),X);
        Assert.assertEquals(con.getY(con.verBox),Y + offY);
    }
    @Test
    public void cursorStyleMiddle(){
        cur.nextTest();
        int elemHeight = cur.centreCursor.getSize().height/2;
        int elemWidth = cur.centreCursor.getSize().width/2;
        offX = 200;
        offY = 200;
        int expectedPosX = cur.centreCursor.getLocation().getX() + (offX + elemWidth -48);
        int expectedPosY = cur.centreCursor.getLocation().getY() + (offY + elemHeight- 48);
        grabAndMove(cur.centreCursor,offX,offY);
        Assert.assertEquals(cur.centreCursor.getLocation().getX(), expectedPosX);
        Assert.assertEquals(cur.centreCursor.getLocation().getY(), expectedPosY);
    }

    @Test
    public void cursorStyleTopLeft(){
        cur.nextTest();
        offX = 200;
        offY = 200;
        int expectedPosX = cur.topLeftCursor.getLocation().getX() + (offX +54);
        int expectedPosY = cur.topLeftCursor.getLocation().getY() + (offY +55);
        grabAndMove(cur.topLeftCursor,offX,offY);
        Assert.assertEquals(cur.topLeftCursor.getLocation().getX(), expectedPosX);
        Assert.assertEquals(cur.topLeftCursor.getLocation().getY(), expectedPosY);

    }

//    @Test
//    public void events(){
//
//    }
//    @Test
//    public void sortableAnddragable(){
//
//    }
}
