package passwordHash;
import org.mindrot.jbcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//public class HashingPassword {
//    public static String hash(String password) {
//        String passwordToHash = "password";
//        String generatedPassword = null;
//
//        try {
//            // Create MessageDigest instance for MD5
//            MessageDigest md = MessageDigest.getInstance("MD5");
//
//            // Add password bytes to digest
//            md.update(passwordToHash.getBytes());
//
//            // Get the hash's bytes
//            byte[] bytes = md.digest();
//
//            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < bytes.length; i++) {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//
//            // Get complete hashed password in hex format
//            generatedPassword = sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return generatedPassword;
//    }
//
////    private static final int SALT_LENGTH = 16; // Length of the salt in bytes
////
////    public static String hashPassword(String password, byte[] salt) {
////        String generatedPassword = null;
////
////        try {
////            // Create MessageDigest instance for SHA-256
////            MessageDigest md = MessageDigest.getInstance("SHA-256");
////
////            // Add salt and password bytes to digest
////            md.update(salt);
////            md.update(password.getBytes());
////
////            // Get the hash's bytes
////            byte[] bytes = md.digest();
////
////            // Convert the bytes to hexadecimal format
////            StringBuilder sb = new StringBuilder();
////            for (byte b : bytes) {
////                sb.append(String.format("%02x", b));
////            }
////
////            // Get the complete hashed password in hex format
////            generatedPassword = sb.toString();
////        } catch (NoSuchAlgorithmException e) {
////            e.printStackTrace();
////        }
////
////        return generatedPassword;
////    }
////
////    public static byte[] generateSalt() {
////        SecureRandom random = new SecureRandom();
////        byte[] salt = new byte[SALT_LENGTH];
////        random.nextBytes(salt);
////        return salt;
////    }
//}

public class HashingPassword {
    // Method to hash a password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Method to verify entered password with stored hashed password
    public static boolean verifyPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }
}
