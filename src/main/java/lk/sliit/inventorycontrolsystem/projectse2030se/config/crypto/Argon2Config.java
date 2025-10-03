package lk.sliit.inventorycontrolsystem.projectse2030se.config.crypto;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2Config {
    private static final int TIME_COST = 10;
    private static final int MEMORY_COST = 262144;
    private static final int PARALLELISM = 4;
    private static final Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    public static String hashPassword(String password) {
        return argon2.hash(TIME_COST, MEMORY_COST, PARALLELISM, password.toCharArray());
    }

    public static boolean verifyPassword(String hashedPassword, String password) {
        return argon2.verify(hashedPassword, password.toCharArray());
    }
}
