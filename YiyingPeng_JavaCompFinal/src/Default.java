import java.util.ArrayList;

public class Default implements RaceDAO {
    private ArrayList<Runner> runners = new ArrayList<>();

    @Override
    public ArrayList<Runner> getRunnerDetails(String fileName) {
        return null;
    }

    ArrayList<Runner> getRunnerDetails() {
        Runner runnerOne = new Runner();
        runnerOne.setRunnersName("Tortoise");
        runnerOne.setRunnersSpeed(10);
        runnerOne.setRestPercentage(0);
        runners.add(runnerOne);

        Runner runnerTwo = new Runner();
        runnerTwo.setRunnersName("Hare");
        runnerTwo.setRunnersSpeed(100);
        runnerTwo.setRestPercentage(90);
        runners.add(runnerTwo);

        return runners;
    }
}
