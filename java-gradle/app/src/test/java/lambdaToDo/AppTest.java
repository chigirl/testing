/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lambdaToDo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    private WebDriver driver;

   @BeforeEach
   void Setup() {
       driver = new ChromeDriver();
       driver.get("https://lambdatest.github.io/sample-todo-app/");
   }

   @AfterEach
   void TearDown() {
       driver.quit();
   }

    @Test void VerifyTitle() {
        String title = "Sample page - lambdatest.com";
        assertEquals(title, driver.getTitle());
    }

    @Test void AddToDo() {
       String todoText = "Clean Hall Closet";
        driver.findElement(By.id("sampletodotext")).sendKeys(todoText);
        driver.findElement(By.id("addbutton")).click();

        WebElement newItem = driver.findElement(By.name("li6"));
        assertNotNull(newItem);
    }

    @Test void MarkToDoDone() {
        WebElement item2 = driver.findElement(By.name("li2"));
        WebElement itemSpan2 = item2.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/span"));
        assertTrue(itemSpan2.getAttribute("class").contains("done-false"));
        item2.click();
        assertTrue(itemSpan2.getAttribute("class").contains("done-true"));
    }
   
}
