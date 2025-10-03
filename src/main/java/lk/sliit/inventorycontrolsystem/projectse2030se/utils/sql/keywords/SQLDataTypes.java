package lk.sliit.inventorycontrolsystem.projectse2030se.utils.sql.keywords;

public interface SQLDataTypes {

    String INT = "INT";
    String FLOAT = "FLOAT";
    String REAL = "REAL";
    String BOOLEAN = "BOOLEAN";
    String DATE = "DATE";
    String TIME = "TIME";
    String DATETIME = "DATETIME";
    String TIMESTAMP = "TIMESTAMP";

    static String CHAR(int value) {
        return ("CHAR(" + value + ")");
    }

    static String VARCHAR(int value) {
        return ("VARCHAR(" + value + ")");
    }

    static String BINARY(int value) {
        return ("BINARY(" + value + ")");
    }

    static String VARBINARY(int value) {
        return ("VARBINARY(" + value + ")");
    }

    static String NCHAR(int value) {
        return ("NCHAR(" + value + ")");
    }

    static String NVARCHAR(int value) {
        return ("NVARCHAR(" + value + ")");
    }
}
