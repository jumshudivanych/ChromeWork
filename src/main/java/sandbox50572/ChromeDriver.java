package sandbox50572;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ChromeDriver implements Runnable {

    private static org.openqa.selenium.chrome.ChromeDriver driver;
    private static String url;//url загружаемои страницы
    private static String name;

    public ChromeDriver(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void run() {

        //TODO ЗАПУСК Chrome
        System.setProperty("webdriver.chrome.driver","C:/idea/chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        //неявное ожидание действует всякий раз при поиске элемента
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);

        // WebElement hrefButton = driver.findElement(By.xpath("//button[text()='Автозагрузчик']"));//TODO проверить соответствие!!!
        WebElement hrefButton = driver.findElementByLinkText("Автозагрузчик");//находим элемент
        //нажать на кнопку
        hrefButton.click();



        //TODO время задержки
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();//завершение работы браузера
    }
}
