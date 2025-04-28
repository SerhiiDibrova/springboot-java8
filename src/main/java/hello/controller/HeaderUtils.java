package hello.controller;

import javax.servlet.http.HttpServletRequest;

public class HeaderUtils {
    
    /**
     * Retrieves the Accept request header from the HttpServletRequest.
     * 
     * @param request the HttpServletRequest object
     * @return the value of the Accept header or '*/*' if not found
     */
    public static String getAcceptRequestHeader(HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader == null || acceptHeader.isEmpty()) {
            return "*/*";
        }
        return acceptHeader;
    }
}