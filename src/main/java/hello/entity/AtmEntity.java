package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Entity
public class AtmEntity {
    @Id
    private String pinHash;
    private double balance;
    private String salt;

    public AtmEntity() {}

    public AtmEntity(String pin, double balance) {
        this.balance = balance;
        this.salt = generateSalt();
        this.pinHash = hashPin(pin, this.salt);
    }

    public String getPinHash() {
        return pinHash;
    }

    public void setPinHash(String pinHash) {
        this.pinHash = pinHash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private String hashPin(String pin, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] pinBytes = pin.getBytes(StandardCharsets.UTF_8);
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            byte[] combinedBytes = new byte[pinBytes.length + saltBytes.length];
            System.arraycopy(pinBytes, 0, combinedBytes, 0, pinBytes.length);
            System.arraycopy(saltBytes, 0, combinedBytes, pinBytes.length, saltBytes.length);
            byte[] hashBytes = md.digest(combinedBytes);
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyPin(String pin) {
        if (pin == null || pin.isEmpty()) {
            return false;
        }
        String hashedPin = hashPin(pin, this.salt);
        return this.pinHash.equals(hashedPin);
    }
}