package lk.sliit.inventorycontrolsystem.projectse2030se.utils.base;

import java.lang.reflect.Field;

public class AttributeUtils {
    public static <T> Field[] getDeclaredFields(Class<T> clazz) {
        return clazz.getDeclaredFields();
    }

    public static <T> Field[] getSuperFields(Class<T> clazz) {
        return clazz.getSuperclass().getDeclaredFields();
    }

    public static <T> Field[] getAllFields(Class<T> clazz) {
        Field[] fields = getDeclaredFields(clazz);
        Field[] superFields = getSuperFields(clazz);

        Field[] allFields = new Field[fields.length + superFields.length];
        System.arraycopy(superFields, 0, allFields, 0, fields.length);
        System.arraycopy(fields, 0, allFields, fields.length, superFields.length);

        return allFields;
    }
}
