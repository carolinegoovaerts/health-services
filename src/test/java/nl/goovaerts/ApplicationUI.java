package nl.goovaerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationUI {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @BeforeAll
    static void setUpClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldDisplayCorrectHeaderText() {
        String url = String.format("http://localhost:%s/", port);

        driver.get(url);

        WebElement h1 = driver.findElement(By.tagName("h1"));
        Assertions.assertEquals("Health Services", h1.getText());
    }
}
