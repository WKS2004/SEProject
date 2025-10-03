package lk.sliit.inventorycontrolsystem.projectse2030se.utils;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;

import java.sql.PreparedStatement;

public interface SQLQueryHelper {
    String sqlQueryMaker(String... allArgs);

    void singleDataWriter(PreparedStatement stmt, int parameterIndex, Object data);

    <T extends DefaultModel> void multiDataWriter(PreparedStatement stmt, T object);
}
