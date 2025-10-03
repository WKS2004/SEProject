package lk.sliit.inventorycontrolsystem.projectse2030se.config.db.credentials;

import lk.sliit.inventorycontrolsystem.projectse2030se.utils.crypto.CryptoUtils;

public class DBCredentialSecurityConfig {
    private static final String KEY = System.getenv("ICS_DB_CREDENTIAL_ENCRYPTION_KEY");

    public static void encryptAndSetUsername(String username) {
        DBCredentialPropertiesConfig.setProperty("db.username", basicEncrypt(username));
    }

    public static void encryptAndSetPassword(String password) {
        DBCredentialPropertiesConfig.setProperty("db.password", basicEncrypt(password));
    }

    public static String decryptUsername() {
        String encryptedUsername = DBCredentialPropertiesConfig.getProperty("db.username");

        if (encryptedUsername == null) {
            throw new RuntimeException("Username is not set or cannot be found!");
        }

        return basicDecrypt(encryptedUsername);
    }

    public static String decryptPassword() {
        String encryptedPassword = DBCredentialPropertiesConfig.getProperty("db.password");

        if (encryptedPassword == null) {
            throw new RuntimeException("Password is not set or cannot be found!");
        }

        return basicDecrypt(encryptedPassword);
    }

    private static String basicEncrypt(String value) {
        if (KEY == null) {
            throw new RuntimeException("Encryption Key is not set or cannot be found!");
        }

        return CryptoUtils.encryptData(value, KEY);
    }

    private static String basicDecrypt(String value) {
        if (KEY == null) {
            throw new RuntimeException("Encryption Key is not set or cannot be found!");
        }

        return CryptoUtils.decryptData(value, KEY);
    }
}
