package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    static {
        // Загрузка драйвера MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Не удалось загрузить драйвер MySQL", e);
        }
    }

    // Метод получения подключения к БД
    public static Connection getConnection() {
        // Чтение учетных данных и адреса сервера из конфигурации или переменных окружения
        String hostName = "localhost";
        String dbName = "userdb";
        String userName = "root";
        String password = "password";

        return getConnection(hostName, dbName, userName, password);
    }

    private static Connection getConnection(String hostName, String dbName, String userName, String password) {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        try {
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            // Логгирование исключения
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
            throw new RuntimeException("Ошибка подключения к БД", e);
        }
    }
}