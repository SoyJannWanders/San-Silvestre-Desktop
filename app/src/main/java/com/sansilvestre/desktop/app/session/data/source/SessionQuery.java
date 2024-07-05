package com.sansilvestre.desktop.app.session.data.source;

public class SessionQuery {

    public static final String OPEN_SESSION =
            "INSERT INTO sessions (checkout_id) VALUES (?);";

    public static final String CLOSE_SESSION =
            "UPDATE sessions SET status = 'CLOSED' WHERE id = ?;";

    public static final String GET_LAST_ACTIVE_SESSION =
            "SELECT * FROM sessions WHERE status = 'OPEN' ORDER BY open_time DESC LIMIT 1;";

}