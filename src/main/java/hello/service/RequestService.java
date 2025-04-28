package hello.service;

import javax.servlet.http.HttpServletRequest;

public class RequestService {
    public String getAcceptRequestHeader(HttpServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("HttpServletRequest cannot be null");
        }
        String acceptHeader = request.getHeader("Accept");
        return acceptHeader != null ? acceptHeader : "*/*";
    }
}