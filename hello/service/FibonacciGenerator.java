

package hello.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FibonacciGenerator {

    private static final int TRUNCATE_AFTER_THIS_MANY = 100;

    public FibonacciResult fibList(Integer n) {
        if (n == null) {
            return new FibonacciResult(new ArrayList<>(), "Invalid input: n must not be null.");
        }

        if (n < 0) {
            return new FibonacciResult(new ArrayList<>(), "Invalid input: n must be a non-negative integer.");
        }

        if (n == 0) {
            return new FibonacciResult(new ArrayList<>(), "Fibonacci sequence generated successfully.");
        }

        List<Integer> fibList = new ArrayList<>();
        fibList.add(0);
        fibList.add(1);

        int a = 0;
        int b = 1;
        int count = 2;

        while (count < n && fibList.size() < TRUNCATE_AFTER_THIS_MANY) {
            int temp = a;
            a = b;
            b = temp + b;
            fibList.add(b);
            count++;
        }

        return new FibonacciResult(fibList, "Fibonacci sequence generated successfully.");
    }
}

class FibonacciResult {
    private List<Integer> fibList;
    private String message;

    public FibonacciResult(List<Integer> fibList, String message) {
        this.fibList = fibList;
        this.message = message;
    }

    public List<Integer> getFibList() {
        return fibList;
    }

    public String getMessage() {
        return message;
    }
}