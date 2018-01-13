package sandbox50572;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //TODO добавить TimeControl
        //создание объекта
        Runnable chromeDriver1 = new sandbox50572.ChromeDriver("ChromeDriver1", "https://sandbox50572.wordpress.com/");
        //создание дочернего потока
        Thread thread2 = new Thread(chromeDriver1);
        //стартуем новыи поток
        thread2.start();
        System.out.println( "Метод main завершен." );
    }
}
