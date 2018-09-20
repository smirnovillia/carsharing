package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class PreparedStatemenAction<RETURN_TYPE> {

    private String sql;

    private boolean returnGeneratedKeys;

    public PreparedStatemenAction(final String sql) {
        this(sql, false);
    }

    public PreparedStatemenAction(final String sql, final boolean returnGeneratedKeys) {
        super();
        this.sql = sql;
        this.returnGeneratedKeys = returnGeneratedKeys;
    }

    public boolean isReturnGeneratedKeys() {
        return returnGeneratedKeys;
    }

    public String getSql() {
        return sql;
    }

    public abstract RETURN_TYPE doWithPreparedStatement(PreparedStatement pStmt) throws SQLException;
}
