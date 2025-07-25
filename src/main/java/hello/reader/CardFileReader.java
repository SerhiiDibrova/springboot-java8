package hello.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardFileReader {

    private BufferedReader reader;
    private static final Logger LOGGER = Logger.getLogger(CardFileReader.class.getName());

    public CardFileReader() {
        try {
            reader = new BufferedReader(new FileReader("CARDFILE"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing file reader", e);
            System.out.println("Error: The file 'CARDFILE' does not exist.");
        }
    }

    public void readFile() {
        if (reader != null) {
            displayStartMessage();
            try {
                String line;
                List<String> lines = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                for (String record : lines) {
                    System.out.println(record);
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error reading file", e);
                System.out.println("An error occurred while reading the file.");
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Error closing file reader", e);
                }
                displayEndMessage();
            }
        } else {
            System.out.println("No file to read.");
        }
    }

    private void displayStartMessage() {
        System.out.println("Starting to read CARDFILE...");
    }

    private void displayEndMessage() {
        System.out.println("Finished reading CARDFILE.");
    }

    public static void main(String[] args) {
        CardFileReader cardFileReader = new CardFileReader();
        cardFileReader.readFile();
    }
}