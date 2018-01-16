package sandbox50572;

public class Coordinator implements Runnable {

    //конструктор
    public Coordinator() {

    }
    public void run() {
        //TODO добавить TimeControl
        //создание объекта
        Runnable chromeDriver1 = new sandbox50572.ChromeDriver("ChromeDriver1", "https://www.google.ru");
        //создание дочернего потока
        Thread threadNext = new Thread(chromeDriver1);
        //стартуем новыи поток
        threadNext.start();
    }
}
