package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.githup.bonigarcia.wdm.WebDriverMAnager;

public class WebDriverManager {

	public static void main(String[] args) {
		
		
		io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();;
		WebDriver driver = new FirefoxDriver();
		driver.get("https://github.com/bonigarcia/webdrivermanager");
		driver.quit();

	}

}
