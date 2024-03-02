
package packk;

import java.sql.Connection;
import java.sql.Statement;

public class DropTableOperation implements DatabaseOperations {
    private String cars;

    public DropTableOperation(String cars) {
        this.cars = cars;
    }

    @Override
    public void execute(Connection conn) {
        try {
            // Удаление таблицы
            Statement statement = conn.createStatement();
            String query = "DROP TABLE IF EXISTS " + cars;
            statement.executeUpdate(query);
            System.out.println("Table " + cars + " dropped successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
