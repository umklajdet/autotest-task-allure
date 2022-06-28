import managers.DriverManager;
import managers.PageManager;
import managers.PropManager;
import org.junit.AfterClass;
import org.junit.Before;

public class BaseTests {

    private static final DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();
    private final PropManager propManager = PropManager.getPropManager();

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(propManager.getProperty("base.url"));
    }

    @AfterClass
    public static void afterAll() {
        driverManager.quitDriver();
    }
}