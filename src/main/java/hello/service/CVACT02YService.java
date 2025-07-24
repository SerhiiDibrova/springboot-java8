package hello.service;

import org.springframework.stereotype.Service;

@Service
public class CVACT02YService {

    public boolean validateCardRecord(String cardNumber, String accountID, String cvvCode, String embossedName, String expirationDate, String activeStatus) {
        try {
            // Card number validation
            if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
                return false;
            }
            for (char c : cardNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            // Account ID validation
            if (accountID == null || accountID.isEmpty()) {
                return false;
            }

            // CVV code validation
            if (cvvCode == null || cvvCode.length() != 3) {
                return false;
            }
            for (char c : cvvCode.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            // Embossed name validation
            if (embossedName == null || embossedName.isEmpty()) {
                return false;
            }

            // Expiration date validation
            if (expirationDate == null || expirationDate.length() != 5) {
                return false;
            }
            String[] dateParts = expirationDate.split("/");
            if (dateParts.length != 2) {
                return false;
            }
            int month, year;
            try {
                month = Integer.parseInt(dateParts[0]);
                year = Integer.parseInt(dateParts[1]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (month < 1 || month > 12) {
                return false;
            }

            // Active status validation
            if (activeStatus == null || !activeStatus.equalsIgnoreCase("active") && !activeStatus.equalsIgnoreCase("inactive")) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}