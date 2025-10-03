package lk.sliit.inventorycontrolsystem.projectse2030se.utils.base;

public class StringBuilderAppendUtils {

    public static String appendWithCustom(String regex, Object... values) {
        StringBuilder sb = new StringBuilder();
        appendWithCustom(regex, sb, values);
        return sb.toString();
    }

    public static String appendWithComma(Object... values) {
        return appendWithCustom(",", values);
    }

    public static String appendWithCommaAndSpace(Object... values) {
        return appendWithCustom(", ", values);
    }

    public static String appendWithSpace(Object... values) {
        return appendWithCustom(" ", values);
    }

    public static String appendWithEqualBetweenSpaces(Object value1, Object value2) {
        return appendWithCustom(" = ", value1, value2);
    }

    public static void appendWithCustom(String regex, StringBuilder sb, Object... values) {
        if (values == null) return;

        for (Object value : values) {
            if (sb.isEmpty()) {
                sb.append(value);
            } else {
                sb.append(regex).append(value);
            }
        }
    }

    public static void appendWithComma(StringBuilder sb, Object... values) {
        appendWithCustom(",", sb, values);
    }

    public static void appendWithCommaAndSpace(StringBuilder sb, Object... values) {
        appendWithCustom(", ", sb, values);
    }

    public static void appendWithSpace(StringBuilder sb, Object... values) {
        appendWithCustom(" ", sb, values);
    }

    public static void appendWithEqualBetweenSpaces(StringBuilder sb, Object value1, Object value2) {
        appendWithCustom(" = ", sb, value1, value2);
    }
}
