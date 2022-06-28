import io.qameta.allure.junit4.AllureJunit4;
import managers.DriverManager;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureListener extends AllureJunit4 {
    @Override
    public void testFailure(Failure failure) {
        byte[] byteScreenshot = ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        getLifecycle().addAttachment("failureScreenshot", "image/png", "png", byteScreenshot);
        super.testFailure(failure);
    }
}
