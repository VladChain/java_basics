import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "****";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT pl.course_name, " +
                            "COUNT(*) / (MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)))" +
                            "AS average_number_of_purchases_per_month " +
                            "FROM PurchaseList pl " +
                            "WHERE YEAR(pl.subscription_date) = 2018 " +
                            "GROUP BY pl.course_name");
            while(resultSet.next()) {
                String courseName = resultSet.getString("pl.course_name");
                double averageNumber = (double) Math.round(resultSet.getDouble(
                        "average_number_of_purchases_per_month") * 100) / 100;
                System.out.println(courseName + " = " + averageNumber);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
