import java.util.ArrayList;
import java.util.Scanner;

public class MarathonRaceApp {
    private static RaceDAO raceDAO = null;
    private ArrayList<Thread> threadList = null;
    private boolean executed = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName;
        String dbName;
        MarathonRaceApp app = new MarathonRaceApp();

        int choice = 0;
        while (choice != 5) {
            app.reset();

            System.out.println("Welcome to the Marathon Race Runner Program\n\nSelect your data source:\n");
            System.out.println("1. Derby database\n2. XML File\n3. Text File\n4. Default two runners\n5. Exit\n");
            choice = Validator.getIntWithinRange(sc, "Enter your choice: ", 1, 5);

            raceDAO = DAOFactory.getRaceDAO(choice);

            switch (choice) {
                case 1: dbName = Validator.getRequiredString("Enter Database name: ", sc);
                    app.createThreads(dbName); break;
                case 2: fileName = Validator.getRequiredString("Enter XML file name: ", sc);
                    app.createThreads(fileName); break;
                case 3:	fileName = Validator.getRequiredString("Enter Text file name: ", sc);
                    app.createThreads(fileName); break;
                case 4: app.createThreads(""); break;
                case 5: System.out.println("\nThank you for using my Marathon Race Program");
                    System.exit(0);
                default: break;
            }
        }
    }

    private void reset() {
        executed = false;
    }

    private void createThreads(String fileName) {
        ArrayList<Runner> runners;
        if (fileName.equals("")) {
            Default defaultRunners = (Default) raceDAO;
            runners = defaultRunners.getRunnerDetails();
        } else {
            runners = raceDAO.getRunnerDetails(fileName);
        }
        if (runners == null) {
            System.err.println("Error! Unable to get runners. Please re-enter valid data source.\n");
        } else {
            int numberOfRunners = runners.size();
            threadList = new ArrayList<>();
            ThreadRunner thread;
            System.out.println("Get set...Go!");

            for (int i = 0; i < numberOfRunners; i++) {
                String runnersName = runners.get(i).getRunnersName();
                int runnersSpeed = runners.get(i).getRunnersSpeed();
                int restPercentage = runners.get(i).getRestPercentage();

                thread = new ThreadRunner(runnersName, runnersSpeed, restPercentage, this);
                thread.start();
                threadList.add(thread);
            }
            waitOnThreadsToComplete();
            System.out.println();
            pressToContinue();
        }
    }

    synchronized boolean isFirst() {
        if (!executed) {
            executed = true;
            return true;
        } else {
            return false;
        }
    }

    void announceWinner(String threadName) {
        System.out.println("The race is over! The " + threadName + " is the winner. \n");
    }

    void finished(String threadName) {
        for (int i = 0; i < threadList.size(); i++) {
            if (!threadName.equals(((ThreadRunner) threadList.get(i)).getRunnersName())) {
                threadList.get(i).interrupt();
            }
        }
    }

    private void waitOnThreadsToComplete() {
        for (int i = 0; i < threadList.size(); i++) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pressToContinue() {
        System.out.println("Press enter to continue . . .");
        try {
            System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}