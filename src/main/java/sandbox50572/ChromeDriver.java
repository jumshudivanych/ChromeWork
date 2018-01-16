package sandbox50572;

import org.openqa.selenium.WebElement;

import java.util.Random;
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

        for(int i=0; i<1500; i++) {

            //TODO ЗАПУСК Chrome
            System.setProperty("webdriver.chrome.driver","C:/idea/chromedriver.exe");
            driver = new org.openqa.selenium.chrome.ChromeDriver();
            driver.manage().window().maximize();
            //неявное ожидание действует всякий раз при поиске элемента
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(url);

            //находим элемент поиск google
            WebElement googleSearch = driver.findElementById("lst-ib");
            //вводим поисковыи запрос
            googleSearch.sendKeys("https://youtu.be/L2X4fAIo7vA");
            //находим и жмем
            WebElement search = driver.findElementByName("btnK");
            search.click();
            //находим элемент в поисковой выдаче
            WebElement ritaYouTube = driver.findElementByLinkText("Мой - YouTube");                //жмем
            ritaYouTube.click();

            //TODO время задержки
            try {
                Thread.sleep(450000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();//завершение работы браузера

            //инициализация генератора случаиных чисел
            Random random = new Random();
            //получение случайного числа
            long a = random.nextInt(30);
            //перевод в минуты
            a = a * 60000;

            //вывод количества проиденных циклов
            System.out.println(i);
            System.out.println("Задержка равна " + a / 60000);

            //задержка
            try {
                Thread.sleep(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
