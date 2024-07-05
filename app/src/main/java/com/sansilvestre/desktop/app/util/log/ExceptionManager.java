package com.sansilvestre.desktop.app.util.log;

import com.sansilvestre.desktop.app.product.domain.util.exception.ProductNotFoundException;

import java.sql.*;

public class ExceptionManager {

    public static void catchException(Exception e) {
        if (e instanceof SQLException) {
            Console.warn("E100", "SQLException", e.getMessage());
        }
        if (e instanceof SQLIntegrityConstraintViolationException) {

        }
        if (e instanceof SQLSyntaxErrorException) {

        }
        if (e instanceof SQLDataException) {

        }
        if (e instanceof SQLTimeoutException) {

        }
        if (e instanceof ProductNotFoundException) {
        }
    }

}