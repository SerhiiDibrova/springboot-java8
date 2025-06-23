package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.B;

@Service
public class CService {

    private B b;

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public String methodC() {
        if (b == null) {
            throw new NullPointerException("B is null");
        }
        String result = b.methodB();
        if (result == null) {
            throw new NullPointerException("Result from methodB is null");
        }
        System.out.println(result);
        return result;
    }
}