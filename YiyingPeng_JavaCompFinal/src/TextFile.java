import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFile implements RaceDAO {
    private ArrayList<Runner> runners = null;

    @Override
    public ArrayList<Runner> getRunnerDetails(String fileName) {
        if (runners != null)
            return runners;

        Path textFilePath = Paths.get(fileName);
        File textFile = textFilePath.toFile();

        runners = new ArrayList<>();

        if (Files.exists(textFilePath)) {
            try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lineParse = line.split("\t");
                    String name = lineParse[0];
                    String speedString = lineParse[1];
                    String restString = lineParse[2];
                    int speed = Integer.parseInt(speedString);
                    int restPercentage = Integer.parseInt(restString);
                    Runner runner = new Runner();
                    runner.setRunnersName(name);
                    runner.setRunnersSpeed(speed);
                    runner.setRestPercentage(restPercentage);
                    runners.add(runner);
                }
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
        return runners;
    }
}
