
package packk;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTableOperation implements DatabaseOperations {
    private String cars;

    public CreateTableOperation(String cars) {
        this.cars = cars;
    }

    @Override
    public void execute(Connection conn) {
        try {
            // Создание таблицы
            String query = "create table " + cars + "(id cars, name varchar(50), year integer, genre varchar(50), season_number integer, country varchar(50), primary key (id));";
            conn.createStatement().executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
