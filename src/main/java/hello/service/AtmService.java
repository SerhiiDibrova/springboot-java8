package hello.service;

import hello.entity.AtmEntity;
import hello.repository.AtmRepository;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtmService {
    private final AtmRepository atmRepository;
    private static final Logger LOGGER = Logger.getLogger(AtmService.class.getName());

    public AtmService(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public void run(AtmEntity atmEntity) {
        if (atmEntity == null) {
            LOGGER.log(Level.SEVERE, "AtmEntity is null");
            return;
        }
        try {
            validateAtmEntity(atmEntity);
            String encryptedPin = encrypt(atmEntity.getPin());
            atmEntity.setPin(encryptedPin);
            atmRepository.save(atmEntity);
            AtmEntity storedAtmEntity = atmRepository.findById(atmEntity.getId());
            if (storedAtmEntity != null) {
                String decryptedPin = decrypt(storedAtmEntity.getPin());
                storedAtmEntity.setPin(decryptedPin);
                System.out.println("ATM Entity: " + storedAtmEntity);
            } else {
                System.out.println("ATM Entity not found");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error executing ATM's main functionality", e);
        }
    }

    private void validateAtmEntity(AtmEntity atmEntity) {
        if (atmEntity.getId() == null || atmEntity.getId() <= 0) {
            throw new IllegalArgumentException("AtmEntity id is invalid");
        }
        if (atmEntity.getPin() == null || atmEntity.getPin().isEmpty()) {
            throw new IllegalArgumentException("AtmEntity pin is invalid");
        }
    }

    private String encrypt(String pin) throws Exception {
        Key key = new SecretKeySpec("1234567890abcdef".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(pin.getBytes());
        return new String(encryptedBytes);
    }

    private String decrypt(String encryptedPin) throws Exception {
        Key key = new SecretKeySpec("1234567890abcdef".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedPin.getBytes());
        return new String(decryptedBytes);
    }
}