package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;

public class DBTableHelper {

    public static <T extends DefaultModel> String getTableName(T object) {
        Class<?> clazz = object.getClass();

        try {
            DBTable table = clazz.getAnnotation(DBTable.class);
            return table.value();
        } catch (Exception e) {
            System.out.println("Class '" + clazz.getSimpleName() + "' missing @DBTable annotation");
            return null;
        }
    }

    public static <T extends DefaultModel> String getTableName(Class<T> clazz) {
        try {
            DBTable table = clazz.getAnnotation(DBTable.class);
            return table.value();
        } catch (Exception e) {
            System.out.println("Class '" + clazz.getSimpleName() + "' missing @DBTable annotation");
            return null;
        }
    }

    public static <T extends DefaultModel> boolean isTableNameNotEmpty(T object) {
        String tableName = getTableName(object);
        return ( (tableName != null) && (!tableName.isEmpty()) );
    }

    public static <T extends DefaultModel> boolean isTableNameNotEmpty(Class<T> clazz) {
        String tableName = getTableName(clazz);
        return ( (tableName != null) && (!tableName.isEmpty()) );
    }
}