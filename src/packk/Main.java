package packk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DatabaseManager dbManager = DatabaseManager.getInstance();

        boolean m = true;
        while (m) {
            System.out.println("Choose operation:");
            System.out.println("1. SHOW TABLE");
            System.out.println("2. ADD ROW");
            System.out.println("3. DELETE ROW");
            System.out.println("4. DROP TABLE");

            try {
                int choose = scan.nextInt();
                switch (choose) {
                    case 1:
                        dbManager.executeOperation(new ShowOperation("cars"));
                        break;
                    case 2:
                        System.out.println("Enter name, year, genre, season_number, country:");
                        String name = scan.next();
                        int year = scan.nextInt();
                        String genre = scan.next();
                        int seasonNumber = scan.nextInt();
                        String country = scan.next();
                        dbManager.executeOperation(new InsertOperation("cars", name, year, genre, seasonNumber, country));
                        break;
                    case 3:
                        System.out.println("Enter id you want to delete:");
                        int idToDelete = scan.nextInt();
                        dbManager.executeOperation(new DeleteOperation("cars", idToDelete));
                        break;
                    case 4:
                        dbManager.executeOperation(new DropTableOperation("cars"));
                        m = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Очищаем буфер ввода
            }
        }
        scan.close();
    }
}
