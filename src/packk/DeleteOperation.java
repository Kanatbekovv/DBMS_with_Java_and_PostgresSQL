
package packk;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteOperation implements DatabaseOperations {
    private String cars;
    private int idToDelete;

    public DeleteOperation(String tableName, int idToDelete) {
        this.cars = tableName;
        this.idToDelete = idToDelete;
    }

    @Override
    public void execute(Connection conn) {
        try {
            // Удаление записи
            Statement statement = conn.createStatement();
            String query = "DELETE FROM " + cars + " WHERE id = " + idToDelete;
            statement.executeUpdate(query);
            System.out.println("Row deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
