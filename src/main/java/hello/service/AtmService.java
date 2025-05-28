package hello.service;

import hello.entity.AtmEntity;
import hello.repository.AtmRepository;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtmService {
    private final AtmRepository atmRepository;
    private static final Logger LOGGER = Logger.getLogger(AtmService.class.getName());
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = generateEncryptionKey();

    public AtmService(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public AtmEntity createAtm() {
        AtmEntity atmEntity = new AtmEntity();
        atmEntity.setPin(generateRandomPin());
        atmEntity.setBalance(0.0);
        return atmEntity;
    }

    public boolean validatePin(String pin) {
        return pin != null && pin.length() == 6 && pin.matches("\\d+");
    }

    public boolean validateBalance(double balance) {
        return balance >= 0;
    }

    public void saveAtm(AtmEntity atmEntity) {
        if (atmEntity == null) {
            LOGGER.log(Level.SEVERE, "AtmEntity is null");
            return;
        }
        try {
            validateAtmEntity(atmEntity);
            String encryptedPin = encrypt(atmEntity.getPin());
            atmEntity.setPin(encryptedPin);
            atmRepository.save(atmEntity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving ATM entity", e);
        }
    }

    public AtmEntity getAtm(Long id) {
        try {
            AtmEntity storedAtmEntity = atmRepository.findById(id);
            if (storedAtmEntity != null) {
                String decryptedPin = decrypt(storedAtmEntity.getPin());
                storedAtmEntity.setPin(decryptedPin);
                return storedAtmEntity;
            } else {
                LOGGER.log(Level.SEVERE, "ATM Entity not found");
                return null;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving ATM entity", e);
            return null;
        }
    }

    private void validateAtmEntity(AtmEntity atmEntity) {
        if (atmEntity == null) {
            throw new IllegalArgumentException("AtmEntity is null");
        }
        if (atmEntity.getId() == null || atmEntity.getId() <= 0) {
            throw new IllegalArgumentException("AtmEntity id is invalid");
        }
        if (atmEntity.getPin() == null || atmEntity.getPin().isEmpty()) {
            throw new IllegalArgumentException("AtmEntity pin is invalid");
        }
    }

    private String generateRandomPin() {
        SecureRandom random = new SecureRandom();
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            pin.append(random.nextInt(10));
        }
        return pin.toString();
    }

    private String generateEncryptionKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    private String encrypt(String pin) throws Exception {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(ENCRYPTION_KEY), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(pin.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decrypt(String encryptedPin) throws Exception {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(ENCRYPTION_KEY), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPin));
        return new String(decryptedBytes);
    }
}