package lk.sliit.inventorycontrolsystem.projectse2030se.utils;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.GetterHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.StringBuilderAppendUtils;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLQueryBuilder implements SQLQueryHelper {

    @Override
    public String sqlQueryMaker(String... allArgs) {
        StringBuilder finalQuery = new StringBuilder();

        for (String arg : allArgs) {
            StringBuilderAppendUtils.appendWithSpace(finalQuery, arg);
        }

        return finalQuery.toString();
    }

    @Override
    public void singleDataWriter(PreparedStatement stmt, int parameterIndex, Object data) {
        try {
            if (data instanceof Byte) {
                stmt.setByte(parameterIndex, (Byte) data);
            }
            else if (data instanceof Short) {
                stmt.setShort(parameterIndex, (Short) data);
            }
            else if (data instanceof Integer) {
                stmt.setInt(parameterIndex, (Integer) data);
            }
            else if (data instanceof Long) {
                stmt.setLong(parameterIndex, (Long) data);
            }
            else if (data instanceof Double) {
                stmt.setDouble(parameterIndex, (Double) data);
            }
            else if (data instanceof Float) {
                stmt.setFloat(parameterIndex, (Float) data);
            }
            else if (data instanceof String) {
                stmt.setString(parameterIndex, (String) data);
            }
            else if (data instanceof Boolean) {
                stmt.setBoolean(parameterIndex, (Boolean) data);
            }
        }
        catch (SQLException e) {
            System.out.println("Error while building SQL Query with Single Data Writer!" + e);
        }
    }

    @Override
    public <T extends DefaultModel> void  multiDataWriter(PreparedStatement stmt, T object) {
        List<Method> getters = GetterHelper.getOrderedAllPublicGetters(object);
        for (int counterWriter = 0; counterWriter < getters.size(); counterWriter++) {
            try {
                Object value = getters.get(counterWriter).invoke(this);
                if (value == null) break;
                singleDataWriter(stmt, counterWriter, value);
            }
            catch (Exception e) {
                System.out.println("Error while building SQL Query with Multi Data Writer!" + e);
            }
        }
    }
}
