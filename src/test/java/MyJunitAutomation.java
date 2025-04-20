import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunitAutomation {
    WebDriver driver;

@BeforeAll
    public void setup(){

       driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
@Test
        public void writeSomething(){
    driver.get("https://demoqa.com/text-box");

    driver.findElement(By.id("userName")).sendKeys("Md Ashrafuzzaman");
    driver.findElements(By.className("mr-sm-2")).get(1).sendKeys("mdashrafuzzaman4343@gmail.com");
driver.findElements(By.tagName("textarea")).get(0).sendKeys("uttora");
    driver.findElements(By.tagName("textarea")).get(1).sendKeys("Dhaka");
    Utils.scroll(driver,0,500);

    driver.findElement(By.id("submit")).click();
    String nameActual=driver.findElement(By.id("name")).getText();


    String nameExpected="Md Ashrafuzzaman";

    Assertions.assertTrue(nameActual.contains(nameExpected));

        }

@Test
        public void clickButton(){
    driver.get("https://demoqa.com/buttons");

    List<WebElement> button=driver.findElements(By.className("btn-primary"));

            Actions actions=new Actions(driver);
            actions.doubleClick(button.get(0)).perform();
            actions.contextClick(button.get(1)).perform();
            actions.click(button.get(2)).perform();
            Utils.scroll(driver,0,500);

            List<WebElement> textActual=driver.findElements(By.tagName("p"));
            String t1=textActual.get(0).getText();
            String t2=textActual.get(1).getText();
            String t3=textActual.get(2).getText();


            Assertions.assertTrue(t1.contains("double click"));
            Assertions.assertTrue(t2.contains("right click"));
            Assertions.assertTrue(t3.contains("dynamic click"));



        }
@Test
        public void handleAlert() throws InterruptedException {
    driver.get("https://demoqa.com/alerts");
    driver.findElement(By.id("alertButton")).click();

    Thread.sleep(3000);
    driver.switchTo().alert().accept();

        }
        @Test
        public void handleCalender(){

    driver.get("https://demoqa.com/date-picker");

    WebElement txtCalendar=driver.findElement(By.id("datePickerMonthYearInput"));
    txtCalendar.click();
    txtCalendar.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
    txtCalendar.sendKeys("12/10/2023");
    txtCalendar.sendKeys(Keys.ENTER);

        }

@Test
        public void selectDropdown(){
    driver.get("https://demoqa.com/select-menu");
    WebElement dropdown=driver.findElement(By.id("oldSelectMenu"));
            Select select=new Select(dropdown);
            select.selectByVisibleText("Black");
        }
        @Test
        public void selectMultipleDropdown(){

    driver.get("https://demoqa.com/select-menu");

    Utils.scroll(driver,0,500);

    WebElement dropdown=driver.findElement(By.id("cars"));
    Select select=new Select(dropdown);
    if (select.isMultiple()){
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Audi");
    }
        }

        @Test
        public void selectWithDropdown() throws InterruptedException {
            driver.get("https://demoqa.com/select-menu");
            // Find the dropdown element
            WebElement dropdownElement = driver.findElement(By.id("withOptGroup"));

            // Use Select class for interacting with dropdown
            Select dropdown = new Select(dropdownElement);

            // Use keyboard actions to navigate dropdown options
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);

            // Select the highlighted option
            actions.sendKeys(Keys.ENTER).perform();


        }
@Test
        public  void mouseHover(){

    driver.get("https://daffodilvarsity.edu.bd/");


    WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'Admission')]"));

    Actions actions=new Actions(driver);

    actions.moveToElement(menu).perform();
        }

@Test
        public void uploadImage(){
            driver.get("https://demoqa.com/upload-download");
            System.out.println(System.getProperty("user.dir"));
            driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\USER\\Downloads\\pp.png");

        }






        @AfterAll
        public void closeDriver(){
//    driver.quit();
        }


    }

