import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class XMLFile implements RaceDAO {
    private ArrayList<Runner> runners = null;

    @Override
    public ArrayList<Runner> getRunnerDetails(String fileName) {
        if (runners != null)
            return runners;

        Path xmlFilePath = Paths.get(fileName);
        File xmlFile = xmlFilePath.toFile();
        Runner r = null;
        runners = new ArrayList<>();

        if (Files.exists(xmlFilePath)) {
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try {
                FileReader fileReader =	new FileReader(xmlFile);
                XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);

                while (reader.hasNext()) {
                    int eventType = reader.getEventType();
                    switch (eventType) {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Runner")) {
                                r = new Runner();
                                String name = reader.getAttributeValue(0);
                                r.setRunnersName(name);
                            }
                            if (elementName.equals("RunnersMoveIncrement")) {
                                int speed = Integer.parseInt(reader.getElementText());
                                r.setRunnersSpeed(speed);
                            }
                            if (elementName.equals("RestPercentage")) {
                                int restPercentage = Integer.parseInt(reader.getElementText());
                                r.setRestPercentage(restPercentage);
                            }
                            break;

                        case XMLStreamConstants.END_ELEMENT:

                            elementName = reader.getLocalName();
                            if (elementName.equals("Runner")) {
                                runners.add(r);
                            }
                            break;

                        default:
                            break;
                    }
                    reader.next();
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