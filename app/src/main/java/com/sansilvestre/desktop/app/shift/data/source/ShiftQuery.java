package com.sansilvestre.desktop.app.shift.data.source;

public class ShiftQuery {

    public static final String GET_SHIFT =
            "SELECT * FROM shifts WHERE (start_time < end_time AND TIME(NOW()) BETWEEN start_time AND end_time) OR (start_time > end_time AND (TIME(NOW()) >= start_time OR TIME(NOW()) <= end_time));";

    public static final String GET_SHIFT_BY_ID =
            "SELECT * FROM shifts WHERE id = ?;";

    public static final String GET_SHIFTS =
            "SELECT * FROM shifts;";

    public static final String INSERT_SHIFT =
            "INSERT INTO shifts (name, checkout_id, start_time, end_time) VALUES (?, ?, ?, ?);";

    public static final String UPDATE_SHIFT =
            "UPDATE shifts SET name = ?, checkout_id = ?, start_time = ?, end_time = ? WHERE id = ?;";

    public static final String DELETE_SHIFT_BY_ID =
            "DELETE FROM shifts WHERE id = ?;";

}