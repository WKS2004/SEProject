package lk.sliit.inventorycontrolsystem.projectse2030se.config.db.ddl;

import lk.sliit.inventorycontrolsystem.projectse2030se.config.db.DBConnectionConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.SQLQueryBuilder;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.SQLQueryHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumnHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTableHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.sql.keywords.SQLKeywords;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBTableCreateConfig implements SQLKeywords {

    private static final SQLQueryHelper sqlQueryHelper = new SQLQueryBuilder();

    public static <T extends DefaultModel> void createTables(List<Class<T>> modelsWithTablesAndColumns) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            for (Class<T> model : modelsWithTablesAndColumns) {
                String tableName = DBTableHelper.getTableName(model);
                String sql = sqlQueryHelper.sqlQueryMaker(CREATE, TABLE, tableName, "();");
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public static <T extends DefaultModel> void addColumns(List<Class<T>> modelsWithTablesAndColumns) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            for (Class<T> model : modelsWithTablesAndColumns) {
                String tableName = DBTableHelper.getTableName(model);
                for (Field field : model.getDeclaredFields()) {
                    String columnName = DBColumnHelper.getAnyColumnName(model, field.getName());
                    String sql = sqlQueryHelper.sqlQueryMaker(ALTER, TABLE, tableName, ADD, COLUMN, columnName, "// More Data");
                }
            }
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public static <T extends DefaultModel> void addConstraints(List<T> modelsWithTablesAndColumns) {}

}
