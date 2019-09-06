package Hw6;

import java.util.ArrayList;
import java.io.*;

public class ConversionsTextFile
{
    private static File conversionTypeFile = new File("conversion_types.txt");
    private static final String FIELD_SEP = "\t";
    public ArrayList<Conversion> getConversions()
    {
        BufferedReader in = null;
        try
        {
            checkFile();
            in = new BufferedReader(
                    new FileReader(conversionTypeFile));
            // create the array list
            ArrayList<Conversion> typesList = new ArrayList<>();
            // read each line in the file
            String line = in.readLine();
            while(line != null)
            {
                String[] columns = line.split(FIELD_SEP);
                String toUnit = columns[0];
                String fromUnit = columns[1];
                String ratio = columns[2];
                Conversion ct = new Conversion(toUnit, fromUnit,
                        Double.parseDouble(ratio));
                typesList.add(ct);
                line = in.readLine();
            }
            return typesList;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        finally
        {
            close(in);
        }
    }
    public boolean saveConversions(ArrayList<Conversion> typesList)
    {
        PrintWriter out = null;
        try
        {
            checkFile();
            // open the output stream for overwriting
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(conversionTypeFile)));
            for (int i = 0; i < typesList.size(); i++)
            {
                Conversion ct = typesList.get(i);
                // write the entry to the end of the file
                out.print(ct.getFromUnit() + FIELD_SEP);
                out.print(ct.getToUnit() + FIELD_SEP);
                out.print(ct.getRatio());
                out.println();
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return false;
        }
        finally
        {
            close(out);
        }
        return true;
    }
    // a private method that creates a blank file if the file doesn't already exist
    private void checkFile() throws IOException
    {
        // if the file doesn't exist, create it
        if (!conversionTypeFile.exists())
            conversionTypeFile.createNewFile();
    }
    // a private method that closes the I/O stream
    private void close(Closeable stream)
    {
        try
        {
            if (stream != null)
                stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}