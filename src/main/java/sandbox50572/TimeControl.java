package sandbox50572;

import java.util.Random;

public class TimeControl implements Runnable{
    private static long startTime;
    private static int randomTime;

    public TimeControl() {
        //получение текущего времени
        startTime = System.currentTimeMillis();
        //инициализация генератора случаиных чисел
        Random random = new Random();
        //получение случаиного числа в диапазоне 1000
        randomTime = random.nextInt(1000);
    }

    public void run() {
       //TODO тут пишется код выполняемыи в дочернем потоке как в методе main

    }
}
