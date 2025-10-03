package lk.sliit.inventorycontrolsystem.projectse2030se.config.db.ddl;

import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.structure.Model;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.StringBuilderAppendUtils;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBTableAndColumnConfig {

    private static final String packagePath = "lk.sliit.inventorycontrolsystem";

    public static void checkEachModelHaveDBTable(List<Class<?>> modelClasses) {

        StringBuilder modelsWithoutTables = new StringBuilder();
        boolean isAnyModelWithoutTable = false;

        System.out.println("Checking All The Models ...");
        for (Class<?> modelClass : modelClasses) {
            if (!modelClass.isAnnotationPresent(DBTable.class)) {
                StringBuilderAppendUtils.appendWithComma(modelsWithoutTables, modelClass.getSimpleName());
                isAnyModelWithoutTable = true;
            }
        }

        if (isAnyModelWithoutTable) {
            throw new RuntimeException("Following class/classes [" + modelsWithoutTables + "] is/are not annotated with @DBTable!\n");
        }

        System.out.println("All Model Classes have @DBTable Annotation!\n");

    }

    public static void checkEachColumnHaveDBColumn(List<Class<?>> modelClassesWithTables) {

        StringBuilder modelsWithoutColumns = new StringBuilder();
        boolean isAnyModelWithoutColumn = false;

        for (Class<?> modelClass : modelClassesWithTables) {
            Field[] modelFields = modelClass.getDeclaredFields();
            System.out.println("Checking " + modelClass.getSimpleName() + "class ...");

            for (Field modelField : modelFields) {
                if (!modelField.isAnnotationPresent(DBColumn.class)) {
                    StringBuilderAppendUtils.appendWithComma(modelsWithoutColumns, modelField.getName());
                    isAnyModelWithoutColumn = true;
                }
            }

            if (isAnyModelWithoutColumn) {
                throw new RuntimeException("Following Field/Fields [" + modelsWithoutColumns + "] is/are not annotated with @DBTable!\n");
            }

            System.out.println("All Columns have @DBColumn Annotation!\n");
        }
    }

    public static List<Class<?>> getAllModelClasses() {
        Reflections reflections = new Reflections(packagePath);
        return new ArrayList<>(reflections.getTypesAnnotatedWith(Model.class));
    }
}
