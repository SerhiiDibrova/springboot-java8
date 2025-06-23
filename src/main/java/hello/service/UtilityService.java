package hello.service;

import hello.model.UserType;
import hello.model.Quote;

public class UtilityService {

    public Object[] utilityFunction() {
        try {
            UserType userType = new UserType();
            Quote quote = new Quote();

            System.out.println("Using UserType and Quote");

            String userTypeResult = userType.getUserType();
            String quoteResult = quote.getQuote();

            return new Object[]{userTypeResult, quoteResult};
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return new Object[]{null, null};
        }
    }
}