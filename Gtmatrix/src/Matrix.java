import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Matrix {
	public static void main(String[] args) {
		String cwd = Paths.get("").toAbsolutePath().toString();
		String filePath = cwd + "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gtmetrix.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("https://www.facebook.com/", Keys.ENTER);
		WebElement e = driver.findElement(By.xpath("//div[@class='report-scores']//div/i"));
		String f = e.getAttribute("class").split("grade-")[1].trim();
		switch (f) {
		case "A":
			System.out.println("90-99%");
			break;
		case "B":
			System.out.println("80-89%");
			break;
		case "C":
			System.out.println("70-79%");
			break;
		case "D":
			System.out.println("60-69%");
			break;
		default:
			System.out.println("50%");
		}
		String p = driver.findElement(By.xpath("//div[@class='report-scores']//div[2]/span/span")).getText()
				.split("%")[0].trim();
		int performance = Integer.parseInt(p);
		if (performance >= 90) {
			System.out.println("A");
		} else if (performance >= 80 && performance < 90) {
			System.out.println("B");
		} else if (performance >= 70 && performance < 80) {
			System.out.println("C");
		} else if (performance >= 60 && performance < 70) {
			System.out.println("D");
		} else {
			System.out.println("E");
		}
		String s = driver.findElement(By.xpath("//div[@class='report-scores']//div[3]/span/span")).getText()
				.split("%")[0].trim();
		int structure = Integer.parseInt(s);
		if (structure >= 90) {
			System.out.println("A");
		} else if (structure >= 80 && structure < 90) {
			System.out.println("B");
		} else if (structure >= 70 && structure < 80) {
			System.out.println("C");
		} else if (structure >= 60 && structure < 70) {
			System.out.println("D");
		} else {
			System.out.println("E");
		}
		driver.quit();
	}
}