package hello.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    public int methodC() {
        try {
            int value = 0;
            value = computeValue();
            return value;
        } catch (Exception e) {
            throw new RuntimeException("Error in methodC: " + e.getMessage());
        }
    }

    private int computeValue() {
        int value = 0;
        for (int i = 1; i <= 10; i++) {
            value += i;
        }
        if (value < 0) {
            throw new RuntimeException("Computed value is negative");
        }
        return value;
    }
}