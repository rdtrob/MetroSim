import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by robert on 11/26/14.
 */

public class ReadFromFile {
    private String readFile(String pathname) throws IOException {

        File file = new File(pathname);
        //pathname = "/mnt/storage/devel/MetroSim/resources/stations.txt"
        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

}