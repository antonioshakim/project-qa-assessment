package ValidationOfAmazonCart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ValidationOfAddingAndRemovingProduct {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://amazon.com/");
        Thread.sleep(Long.parseLong("5000"));
        driver.manage().window().maximize();
        Thread.sleep(Long.parseLong("5000"));
        WebElement MenuButton = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]"));
        MenuButton.click();
        Thread.sleep(Long.parseLong("5000"));
        WebElement Computers = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]/a/div"));
        Computers.click();
        Thread.sleep(Long.parseLong("5000"));
        WebElement ComputersAndTablets = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[6]/li[5]/a"));
        ComputersAndTablets.click();
        Thread.sleep(Long.parseLong("5000"));
        driver.findElement(By.xpath("//*[@id=\"p_89/SAMSUNG\"]/span/a/span")).click();
        Thread.sleep(Long.parseLong("5000"));
        WebElement Product = driver.findElement(By.linkText("SAMSUNG Galaxy Tab A7 Lite 8.7\" 32GB Android Tablet w/ Compact, Slim Design, Sturdy Metal Frame, Long Lasting Battery, Gray"));
        Product.click();
        Thread.sleep(Long.parseLong("5000"));
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
        Thread.sleep(Long.parseLong("5000"));
        String ProductAddedToCart = driver.findElement(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/span")).getText(); // (When a popup cart menu displayed after adding the product to the cart)
        System.out.println(ProductAddedToCart);
        driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
        Thread.sleep(Long.parseLong("5000"));
        WebElement DeleteButton = driver.findElement(By.cssSelector("[aria-label=\"Delete SAMSUNG Galaxy Tab A7 Lite 8.7&quot; 32GB Android Tablet w/ Compact, Slim Design, Sturdy Metal Frame, Long Lasting Battery, Gray\"]"));
        DeleteButton.click();
        Thread.sleep(Long.parseLong("5000"));
        String ProductDeleted = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1")).getText();
        System.out.println(ProductDeleted);
        Thread.sleep(Long.parseLong("5000"));
        driver.quit();
    }
}
