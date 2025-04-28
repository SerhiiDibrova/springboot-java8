package hello.service;

import javax.servlet.http.HttpServletRequest;

public class RequestService {

    public String getAcceptRequestHeader(HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        return acceptHeader != null ? acceptHeader : "*/*";
    }
}