package TestCase;

import com.contour.core.AbstractTest;
import com.contour.utilities.LoadConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AddMemberTest extends AbstractTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeMethod(){
        driver = getDriver();
    }

    @AfterEach
    public void afterMethod(){
        closeBrowser(driver);
    }

    @Test
    public void verifyAdNewMember(){
        System.out.printf(LoadConfig.CONFIG.getPropertyByEnv("url"));
    }
}
