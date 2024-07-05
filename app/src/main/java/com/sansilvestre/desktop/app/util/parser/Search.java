package com.sansilvestre.desktop.app.util.parser;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Search {

    public static void ofCategory(PreparedStatement statement, String search) throws SQLException {
        statement.setString(1, "%" + search + "%");
        statement.setString(2, search);
        statement.setString(3, search + "%");
    }

    public static void ofBranch(PreparedStatement statement, String search) throws SQLException {
        statement.setString(1, "%" + search + "%");
        statement.setString(2, search + "%");
        statement.setString(3, search);
        statement.setString(4, search);
        statement.setString(5, search + "%");
        statement.setString(6, search + "%");
    }


    public static void ofProduct(PreparedStatement statement, String search) throws Exception {
        statement.setString(1, "%" + search + "%");
        statement.setString(2, search + "%");
        statement.setString(3, search);
        statement.setString(4, search);
        statement.setString(5, search + "%");
        statement.setString(6, search + "%");
    }

}