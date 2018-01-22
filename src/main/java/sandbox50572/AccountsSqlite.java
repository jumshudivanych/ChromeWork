package sandbox50572;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountsSqlite implements Runnable {

    public AccountsSqlite() {

    }

    public void run() {

        try {

            //инициализация драивера базы данных
            Class.forName("org.sqlite.JDBC");
            //создание подключения
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\idea\\sqlite\\accounts.db");//строка подключения
            //в строке подключения либо полный путь к фаилу либо
            //имя фаила если в тои же папке
            System.out.println("Connected");

            //создание sql запроса
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO 'users' ('name', 'url', 'login', 'password') VALUES ('ivan', 'google.ru', 'ivanlykov028@gmail.com', '1234cani');");//TODO тут sql запрос
System.out.println("Запись добавлена");

        //считывание из таблицы
            ResultSet resSet = stmt.executeQuery("SELECT * FROM users");
            while(resSet.next())
            {
                int id = resSet.getInt("id");
                String  name = resSet.getString("name");
                String  url = resSet.getString("url");
                String  login = resSet.getString("login");
                String  password = resSet.getString("password");
                System.out.println( "ID = " + id );
                System.out.println( "name = " + name );
                System.out.println( "url = " + url );
                System.out.println( "login = " + login );
                System.out.println( "password = " + password );
                System.out.println("Таблица выведена");

                //TODO !!! Добавить закрытие базы данных в отдельных методах
                connection.close();
                stmt.close();
                resSet.close();

                System.out.println("Соединения закрыты");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
