package hello.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getAcceptRequestHeader(HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        return acceptHeader != null ? acceptHeader : "*/*";
    }
}