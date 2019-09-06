import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RunnersDB implements RaceDAO {
    private Connection getConnection(String dbName) {
        Connection connection = null;

        try {
            String dbDir = "resources";
            System.setProperty("derby.system.home", dbDir);

            String url = "jdbc:derby:" + dbName.trim();
            String user = "";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println();
        }
        return connection;
    }

    @Override
    public ArrayList<Runner> getRunnerDetails(String dbName) {
        ArrayList<Runner> runners;
        try {
            Connection connection = getConnection(dbName);
            runners = new ArrayList<>();

            String query = "SELECT RunnerName, RunnerSpeed, RestPercentage "
                    + "FROM Runners";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String runnerName = rs.getString("Name");
                int runnerSpeed = rs.getInt("RunnersSpeed");
                int restPercentage = rs.getInt("RestPercentage");

                Runner runner = new Runner();
                runner.setRunnersName(runnerName);
                runner.setRunnersSpeed(runnerSpeed);
                runner.setRestPercentage(restPercentage);

                runners.add(runner);
            }
            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            return null;
        }
        return runners;
    }

}