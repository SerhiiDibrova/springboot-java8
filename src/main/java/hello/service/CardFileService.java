package hello.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CardFileService {

    private int applicationResult;
    private String ioStatus;
    private BufferedReader br;
    private static final Logger LOGGER = Logger.getLogger(CardFileService.class.getName());

    public CardFileService() {
        this.applicationResult = 0;
        this.ioStatus = "";
        try {
            this.br = new BufferedReader(new FileReader("CARDFILE-FILE"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error opening file", e);
            setApplicationResult(2);
            setIOStatus("Error opening file");
            displayIOStatus();
            abendProgram();
        }
    }

    public String readCardFile() {
        try {
            String line = br.readLine();
            if (line == null) {
                setApplicationResult(1);
                setIOStatus("End of file reached");
                displayIOStatus();
                return null;
            } else {
                setApplicationResult(0);
                setIOStatus("Record read successfully");
                return line;
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file", e);
            setApplicationResult(2);
            setIOStatus("Error reading file");
            displayIOStatus();
            abendProgram();
            return null;
        }
    }

    public void setApplicationResult(int result) {
        this.applicationResult = result;
    }

    public void setIOStatus(String status) {
        this.ioStatus = status;
    }

    public void displayIOStatus() {
        if (getApplicationResult() == 0) {
            System.out.println("IO Status: " + ioStatus);
        } else {
            System.out.println("Error: " + ioStatus);
        }
    }

    public int getApplicationResult() {
        return applicationResult;
    }

    public void abendProgram() {
        System.out.println("Abnormal program termination due to error");
        System.exit(1);
    }
}