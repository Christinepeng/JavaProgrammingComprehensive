class DAOFactory {
    static RaceDAO getRaceDAO(int choice) {
        RaceDAO raceDAO = null;

        if (choice == 1) {
            raceDAO = new RunnersDB();
        } else if (choice == 2) {
            raceDAO = new XMLFile();
        } else if (choice == 3) {
            raceDAO = new TextFile();
        } else if (choice == 4) {
            raceDAO = new Default();
        }
        return raceDAO;
    }
}
