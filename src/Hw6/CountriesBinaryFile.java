package Hw6;

import java.util.ArrayList;
import java.io.*;

public class CountriesBinaryFile {
    private static File countriesFile = new File("countries.dat");

    public CountriesBinaryFile() {
        checkFile();
    }

    public static void main(String args[]) {
    }

//    private static void initializeCountriesFile() {
//        try {
//            countriesFile.createNewFile();
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        }
//        ArrayList<String> countries = new ArrayList<>();
//        countries.add("India");
//        countries.add("Japan");
//        countries.add("Mexico");
//        countries.add("Spain");
//        countries.add("United States");
//        DataOutputStream out = null;
//        try {
//            out = new DataOutputStream(
//                    new BufferedOutputStream(
//                            new FileOutputStream(countriesFile)));
//            for (String country : countries) {
//                out.writeUTF(country);
//            }
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        } finally {
//            close(out);
//        }
//        System.out.println("The countries.dat file has been initialized.\n");
//    }

//    public ArrayList<String> getCountries() {
//        DataInputStream in = null;
//        try {
//            checkFile();
//            in = new DataInputStream(
//                    new BufferedInputStream(
//                            new FileInputStream(countriesFile)));
//            ArrayList<String> countries = new ArrayList<>();
//            while(in.available() > 0) {
//                String country = in.readUTF();
//                countries.add(country);
//            }
//            return countries;
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//            return null;
//        } finally {
//            close(in);
//        }
//    }

//    public boolean saveCountries(ArrayList<String> countries) {
//        DataOutputStream out = null;
//        try {
//            checkFile();
//            out = new DataOutputStream(
//                    new BufferedOutputStream(
//                            new FileOutputStream(countriesFile)));
//            for (String country : countries) {
//                out.writeUTF(country);
//            }
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//            return false;
//        } finally {
//            close(out);
//        }
//        return true;
//    }

    private static void checkFile() {
        try {
            if (!countriesFile.exists())
                countriesFile.createNewFile();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    private static void close(Closeable stream) {
//        try {
//            if (stream != null)
//                stream.close();
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }
}