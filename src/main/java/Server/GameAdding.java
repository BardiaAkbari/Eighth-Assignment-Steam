package Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GameAdding {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/steam",
                "root",
                "Nariman@1383");
        Statement statement = connection.createStatement();
        int[] numbers = {292030, 323190, 359550, 489830, 1085660, 1151640, 1174180, 1196590, 1245620, 2050650};
        for (int i = 0; i < numbers.length; i++){
            File file = new File("D:\\Uni TA Projects\\Term 2\\Java\\Main\\Eighth-Assignment-Steam\\src\\main\\java\\Server" +
                    "\\Resources\\" + numbers[i] + ".txt");
            Scanner myScanner = new Scanner(file);
            Process(myScanner, statement);

        }
    }
    public static void Process(Scanner myScanner, Statement statement) throws SQLException {
        String id = myScanner.nextLine();
        String title = myScanner.nextLine();
        String developer = myScanner.nextLine();
        String genre = myScanner.nextLine();
        double price = myScanner.nextDouble();
        int release_year = myScanner.nextInt();
        boolean controller_support = myScanner.nextBoolean();
        int reviews = myScanner.nextInt();
        int size = myScanner.nextInt();
        String sqlCommand = "INSERT INTO games VALUES (\"" + id + "\", \"" + title + "\", \"" + developer + "\", \"" + genre + "\", "
                + price + ", " + release_year + ", " + controller_support + ", " + reviews + ", " + size + ", \"D:\\Uni TA Projects\\Term 2" +
                "\\Java\\Main\\Eighth-Assignment-Steam\\src\\main\\java\\Server\\Resources\")";
        int insert = statement.executeUpdate(sqlCommand);
    }
}
