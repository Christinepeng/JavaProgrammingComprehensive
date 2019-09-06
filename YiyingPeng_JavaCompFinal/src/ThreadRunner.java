public class ThreadRunner extends Thread {
    private String runnersName;
    private double runnersSpeed;
    private int restPercentage;
    private MarathonRaceApp app;
    private static final int raceDistance = 1000;

    ThreadRunner(String runnersName, double runnersSpeed, int restPercentage, MarathonRaceApp app) {
        this.runnersName = runnersName;
        this.runnersSpeed = runnersSpeed;
        this.restPercentage = restPercentage;
        this.app = app;
    }

    String getRunnersName() {
        return runnersName;
    }

    @Override
    public void run() {
        int distanceCovered = 0;

        try {
            while (distanceCovered < raceDistance) {
                int randomNumber = (int)(Math.random() * 100 + 1);

                if (randomNumber <= restPercentage) {
                    Thread.sleep(100);
                } else {
                    distanceCovered += runnersSpeed;
                    System.out.println(runnersName + " : " + distanceCovered);
                }
                Thread.sleep(100);
            }

            boolean firstThread = app.isFirst();

            if (firstThread) {
                System.out.println(runnersName + " : I finished!\n");
                app.announceWinner(runnersName);
                app.finished(runnersName);
                return;
            } else {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}
        System.out.println(runnersName + " : You beat me fair and square.\n");
    }
}
