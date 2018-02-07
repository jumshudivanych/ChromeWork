package sandbox50572;

import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChromeDriver implements Runnable {

    private static org.openqa.selenium.chrome.ChromeDriver driver;
    private static String url;//url загружаемои страницы
    private static String name;
    private String login;
    private String password;
    public String findElement1;
    public String findElement2;
    public String resultString;

    public ChromeDriver(String name, String url) {
        this.name = name;
        this.url = url;
        this.login = login;
        this.password = password;
        this.findElement1 = "Рисуем по клеточкам #1ДОМ - YouTube";
        this.findElement2 = "Моя кухня - YouTube";
        this.resultString = "empty";
    }

    public void run() {

        for(int i=0; i<1500; i++) {

            //TODO Случайный выбор из найденных элементов
            //инициализация генератора случаиных чисел
            Random r = new Random();
            //получение случайного числа
            int n = r.nextInt(2);//случайный выбор из двух
            if(n == 1) {
                resultString = findElement2;
                System.out.println("Кухня");
            }
            else {
                resultString = findElement1;
                System.out.println("Дом");
            }

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
            googleSearch.sendKeys("Rita Lykova- YouTube");
            //находим и жмем
            WebElement search = driver.findElementByName("btnK");
            search.click();
            //находим элемент в поисковой выдаче
            WebElement ritaYouTube = driver.findElementByLinkText(resultString);//жмем
            ritaYouTube.click();

            //TODO время задержки
            try {
                Thread.sleep(260000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();//завершение работы браузера

            //инициализация генератора случаиных чисел
            Random random = new Random();
            //получение случайного числа
            long a = random.nextInt(6);
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
