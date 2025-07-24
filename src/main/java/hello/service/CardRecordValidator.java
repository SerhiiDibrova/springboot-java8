package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.repository.CardRecordRepository;
import hello.model.CardRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class CardRecordValidator {

    private final CardRecordRepository cardRecordRepository;

    @Autowired
    public CardRecordValidator(CardRecordRepository cardRecordRepository) {
        this.cardRecordRepository = cardRecordRepository;
    }

    public boolean validateCardRecord(CardRecord cardRecord) {
        if (cardRecord == null) {
            return false;
        }
        if (cardRecord.getCardNumber() == null || cardRecord.getExpirationDate() == null) {
            return false;
        }
        if (!isValidCardNumber(cardRecord.getCardNumber())) {
            return false;
        }
        if (!isValidExpirationDate(cardRecord.getExpirationDate())) {
            return false;
        }
        return true;
    }

    private boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            return false;
        }
        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // Luhn algorithm for card number validation
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    private boolean isValidExpirationDate(String expirationDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            LocalDate expirationLocalDate = LocalDate.parse(expirationDate, formatter);
            LocalDate currentLocalDate = LocalDate.now();
            return !expirationLocalDate.isBefore(currentLocalDate) && expirationLocalDate.getYear() > currentLocalDate.getYear() || 
                   (expirationLocalDate.getYear() == currentLocalDate.getYear() && expirationLocalDate.getMonthValue() >= currentLocalDate.getMonthValue());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}