
package packk;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection conn;

    private DatabaseManager() {
        // Инициализация соединения с базой данных
        conn = connectTo("postgres", "postgres", "42rerive");
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection connectTo(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!=null){
                System.out.println("Connection established");
            }
            else {
                System.out.println("Connection failed");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return conn; // Возвращаем соединение
    }


    public void executeOperation(DatabaseOperations operation) {
        operation.execute(conn);
    }

    // Другие методы управления базой данных
}
