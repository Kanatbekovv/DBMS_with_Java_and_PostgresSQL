package packk;
import java.sql.Connection;

public class InsertOperation implements DatabaseOperations {
    private String cars;
    private String name;
    private int year;
    private String genre;
    private int seasonNumber;
    private String country;

    public InsertOperation(String cars, String name, int year, String genre, int seasonNumber, String country) {
        this.cars = cars;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.seasonNumber = seasonNumber;
        this.country = country;
    }

    @Override
    public void execute(Connection conn) {
        try {
            // Вставка записи
            String query = String.format("insert into %s(name,year,genre,season_number,country) values('%s',%d,'%s',%d,'%s');", cars, name, year, genre, seasonNumber, country);

            conn.createStatement().executeUpdate(query);
            System.out.println("Row inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
