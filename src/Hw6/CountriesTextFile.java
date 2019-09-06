package Hw6;

import java.util.ArrayList;
import java.io.*;
public class CountriesTextFile {
    private File countriesFile = null;

    public CountriesTextFile() {
        countriesFile = new File("countries.txt");
        this.checkFile();
    }

    public ArrayList<String> getCountries() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(countriesFile));
            ArrayList<String> countries = new ArrayList<>();
            String line = in.readLine();
            while(line != null) {
                countries.add(line);
                line = in.readLine();
            }
            return countries;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            close(in);
        }
    }

    public boolean saveCountries(ArrayList<String> countries) {
        PrintWriter out = null;
        try {
            checkFile();
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(countriesFile)));
            for (int i = 0; i < countries.size(); i++) {
                String country = countries.get(i);
                out.println(country);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        } finally {
            close(out);
        }
        return true;
    }

    private void checkFile() {
        try {
            if (!countriesFile.exists())
                countriesFile.createNewFile();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void close(Closeable stream) {
        try {
            if (stream != null)
                stream.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}