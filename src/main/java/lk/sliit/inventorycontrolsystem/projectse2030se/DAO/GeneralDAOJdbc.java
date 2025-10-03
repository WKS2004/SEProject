package lk.sliit.inventorycontrolsystem.projectse2030se.DAO;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.db.DBConnectionConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.SQLQueryBuilder;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.SQLQueryHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.DBDataRetrieveConstructorHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumnHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTableHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.AttributeUtils;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.StringBuilderAppendUtils;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.sql.keywords.SQLKeywords;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDAOJdbc<T extends DefaultModel> implements GeneralDAO<T>, SQLKeywords {
    private final Class<T> modelClass;

    protected GeneralDAOJdbc(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    protected T getDataByParameter(String parameter, String value) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            String tableName;

            if (DBTableHelper.isTableNameNotEmpty(modelClass)) {
                tableName = DBTableHelper.getTableName(modelClass);

                SQLQueryHelper readAllQuery = new SQLQueryBuilder();

                String sql = readAllQuery.sqlQueryMaker(SELECT, parameter, FROM, tableName, WHERE, StringBuilderAppendUtils.appendWithEqualBetweenSpaces(parameter, value));
                PreparedStatement stmt = connection.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                Constructor<T> constructor = DBDataRetrieveConstructorHelper.getConstructor(modelClass);
                Field[] fields = AttributeUtils.getAllFields(modelClass);

                Object[] values = new Object[fields.length];
                for (int counter = 0; counter < fields.length; counter++) {
                    DBColumn dbColumn = fields[counter].getAnnotation(DBColumn.class);
                    values[counter] = rs.getObject(dbColumn.value());
                }

                return constructor.newInstance(values);
            }
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
            System.out.println("Error while try to create the instance from " + modelClass.getSimpleName() + "Class!");
        } catch (SQLException e) {
            System.out.println("Error while getting crypto of " + modelClass.getSimpleName() + "from Database!");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public T getById(String id) {
        return getDataByParameter("id", id);
    }

    public List<T> getAll() {
        List<T> allRecords = new ArrayList<>();
        try (Connection connection = DBConnectionConfig.getConnection()) {
            String tableName;

            if (DBTableHelper.isTableNameNotEmpty(modelClass)) {
                tableName = DBTableHelper.getTableName(modelClass);

                SQLQueryHelper readAllQuery = new SQLQueryBuilder();

                String sql = readAllQuery.sqlQueryMaker(SELECT, "*", FROM, tableName);
                PreparedStatement stmt = connection.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                Constructor<T> constructor = DBDataRetrieveConstructorHelper.getConstructor(modelClass);
                Field[] fields = AttributeUtils.getAllFields(modelClass);

                while (rs.next()) {
                    Object[] values = new Object[fields.length];
                    for (int counter = 0; counter < fields.length; counter++) {
                        DBColumn dbColumn = fields[counter].getAnnotation(DBColumn.class);
                        values[counter] = rs.getObject(dbColumn.value());
                    }

                    T instance = constructor.newInstance(values);
                    allRecords.add(instance);
                }
            }
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
            System.out.println("Error while try to create the instance from " + modelClass.getSimpleName() + "Class!");
        } catch (SQLException e) {
            System.out.println("Error while getting crypto from Database!");
        }
        return allRecords;
    }

    public boolean create(T object) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            String tableName;
            String allColumnNames;
            String placeHolders;

            if (DBTableHelper.isTableNameNotEmpty(object)) {
                if (DBColumnHelper.hasAllColumnsUpdated(object)) {

                    tableName = DBTableHelper.getTableName(object);
                    allColumnNames = DBColumnHelper.allColumnNames(object);
                    placeHolders = DBColumnHelper.allPlaceholders(object);

                    SQLQueryHelper createQuery = new SQLQueryBuilder();

                    String sql = createQuery.sqlQueryMaker(INSERT, INTO, tableName, "(", allColumnNames, ")", VALUES, "(", placeHolders, ")");

                    PreparedStatement stmt = connection.prepareStatement(sql);

                    createQuery.multiDataWriter(stmt, object);

                    stmt.executeUpdate();

                    return true;

                } else {
                    System.out.println("One or more Columns have not been set!");
                    return false;
                }
            } else {
                System.out.println("Table name has not been set!");
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("Error while creating the " + object.getClass().getSimpleName());
        }
        return false;
    }

    public boolean update(T object) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            String tableName;
            String allColumnNamesWithPlaceholders;
            String idColumnName;

            if (DBTableHelper.isTableNameNotEmpty(object)) {
                if (DBColumnHelper.hasAllColumnsUpdated(object)) {

                    tableName = DBTableHelper.getTableName(object);
                    allColumnNamesWithPlaceholders = DBColumnHelper.allColumnNamesWithPlaceholders(object);
                    idColumnName = DBColumnHelper.getIDColumnName(object);

                    SQLQueryHelper updateQuery = new SQLQueryBuilder();

                    String sql = updateQuery.sqlQueryMaker(UPDATE, tableName, SET, "(", allColumnNamesWithPlaceholders, ")", WHERE, StringBuilderAppendUtils.appendWithEqualBetweenSpaces(idColumnName, object.getId()));

                    PreparedStatement stmt = connection.prepareStatement(sql);

                    updateQuery.multiDataWriter(stmt, object);

                    stmt.executeUpdate();

                    return true;

                } else {
                    System.out.println("One or more Columns have not been set!");
                }
            } else {
                System.out.println("Table name has not been set!");
            }
        } catch (SQLException e) {
            System.out.println("Error while updating the " + object.getClass().getSimpleName());
        }
        return false;
    }
    public boolean delete(T object) {
        try (Connection connection = DBConnectionConfig.getConnection()) {
            String tableName;
            String idColumnName;

            if (DBTableHelper.isTableNameNotEmpty(object)) {
                if (DBColumnHelper.isIDColumnPresent(object)) {
                    tableName = DBTableHelper.getTableName(object);
                    idColumnName = DBColumnHelper.getIDColumnName(object);

                    SQLQueryHelper deleteQuery = new SQLQueryBuilder();

                    String sql = deleteQuery.sqlQueryMaker(DELETE, FROM, tableName, WHERE, StringBuilderAppendUtils.appendWithEqualBetweenSpaces(idColumnName, object.getId()));

                    PreparedStatement stmt = connection.prepareStatement(sql);

                    stmt.executeUpdate();
                    return true;
                }
                else {
                    System.out.println("id Column have not been set!");
                    return false;
                }
            }
            else {
                System.out.println("Table name has not been set!");
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("Error while deleting the " + object.getClass().getSimpleName());
        }
        return false;
    }
}
