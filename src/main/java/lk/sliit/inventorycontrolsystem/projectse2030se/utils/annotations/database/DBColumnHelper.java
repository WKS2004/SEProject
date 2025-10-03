package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.StringBuilderAppendUtils;

import java.lang.reflect.Field;
import java.util.Objects;

public class DBColumnHelper {

    public static <T extends DefaultModel> String allColumnNames(T object) {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) object.getClass();
        return allColumnNames(clazz);
    }

    public static <T extends DefaultModel> String allColumnNames(Class<T> clazz) {
        Class<?> superClass = clazz.getSuperclass();

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = superClass.getDeclaredFields();

        StringBuilder columnData = new StringBuilder();

        boolean hasAllColumnsUpdated = hasAllColumnsUpdated(superClass, superFields, columnData);

        boolean hasAllSuperColumnsUpdated = hasAllColumnsUpdated(clazz, fields, columnData);

        return ( (hasAllColumnsUpdated && hasAllSuperColumnsUpdated) ? columnData.toString() : null );
    }

    private static boolean hasAllColumnsUpdated(Class<?> clazz, Field[] fields, StringBuilder columnData) {
        for (Field field : fields) {
            try {
                DBColumn column = field.getAnnotation(DBColumn.class);

                StringBuilderAppendUtils.appendWithCommaAndSpace(columnData, column.value());
            } catch (Exception e) {
                System.out.println("Attribute '" + field.getName() + "' of Class '" + clazz.getSimpleName() +"' missing @DBColumn annotation");
                return false;
            }
        }

        return true;
    }

    public static <T extends DefaultModel> boolean hasAllColumnsUpdated(T object) {
        String columnData = allColumnNames(object);
        return ( (columnData) != null && (!columnData.isEmpty()) );
    }

    public static <T extends DefaultModel> boolean hasAllColumnsUpdated(Class<T> clazz) {
        String columnData = allColumnNames(clazz);
        return ( (columnData) != null && (!columnData.isEmpty()) );
    }

    public static <T extends DefaultModel> String allPlaceholders(T object) {
        return allPlaceholders(object.getClass());
    }

    public static <T extends DefaultModel> String allPlaceholders(Class<T> clazz) {
        if (hasAllColumnsUpdated(clazz)) {
            String allColumnNames = allColumnNames(clazz);
            StringBuilder valueParameters = new StringBuilder();

            for (int columnName = 0; columnName < Objects.requireNonNull(allColumnNames).split(",").length; columnName++) {
                StringBuilderAppendUtils.appendWithCommaAndSpace(valueParameters, "?");
            }
            return valueParameters.toString();
        }

        return null;
    }

    public static <T extends DefaultModel> String allColumnNamesWithPlaceholders(T object) {
        return allColumnNamesWithPlaceholders(object.getClass());
    }

    public static <T extends DefaultModel> String allColumnNamesWithPlaceholders(Class<T> clazz) {
        String[] allColumnNames = Objects.requireNonNull(allColumnNames(clazz)).split(", ");

        StringBuilder allColumnNamesWithPlaceHolders = new StringBuilder();

        for (String columnName : allColumnNames) {
            StringBuilderAppendUtils.appendWithCommaAndSpace(allColumnNamesWithPlaceHolders, columnName);
            StringBuilderAppendUtils.appendWithEqualBetweenSpaces(allColumnNamesWithPlaceHolders, "?");
        }

        return allColumnNamesWithPlaceHolders.toString();
    }

    public static <T extends DefaultModel> boolean isIDColumnPresent(T object) {
        return isIDColumnPresent(object.getClass());
    }

    public static <T extends DefaultModel> boolean isIDColumnPresent(Class<T> clazz) {
        String idColumnName = getIDColumnName(clazz);
        return (idColumnName != null && !idColumnName.isEmpty());
    }

    public static <T extends DefaultModel> String getIDColumnName(T object) {
        return getAnyColumnName(object, "id");
    }

    public static <T extends DefaultModel> String getIDColumnName(Class<T> clazz) {
        return getAnyColumnName(clazz, "id");
    }

    public static <T extends DefaultModel> String getAnyColumnName(T object, String columnName) {
        return getAnyColumnName(object.getClass(), columnName);
    }

    public static <T extends DefaultModel> String getAnyColumnName(Class<T> clazz, String columnName) {
        Class<?> superClass = clazz.getSuperclass();

        Field[] superFields = superClass.getDeclaredFields();

        for (Field superField : superFields) {
            DBColumn column = superField.getAnnotation(DBColumn.class);

            if (column != null && !column.value().isEmpty() && superField.getName().equals(columnName)) {
                return column.value();
            }
        }

        System.out.println("Either Field " + columnName + " not found or " + columnName + " Column has not been annotated with @DBColumn!");
        return null;
    }

}
