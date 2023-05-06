package com.backend.store.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUtil {
    private DaoUtil() {
    }
    public static void setPrepareStatement(PreparedStatement ps, Object[] data) throws SQLException {
        if (ps == null) {
            return;
        }
        int i = 1;
        for (var column : data) {
            if (column instanceof Long) {
                ps.setLong(i++, (long) column);
            } else if (column instanceof Integer) {
                ps.setInt(i++, (int) column);
            } else if (column instanceof String) {
                ps.setString(i++, (String) column);
            } else if (column instanceof Double) {
                ps.setDouble(i++, (double) column);
            } else {
                ps.setObject(i++, column);
            }
        }

    }
}
