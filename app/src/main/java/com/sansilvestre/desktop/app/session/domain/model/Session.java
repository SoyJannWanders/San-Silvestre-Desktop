package com.sansilvestre.desktop.app.session.domain.model;

import com.sansilvestre.desktop.app.session.data.source.SessionDatabase;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Session {

    public enum Status {

        OPEN,
        CLOSED

    }

    private int id;
    private int checkoutId;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private Status status;

    public Session(ResultSet result) throws Exception {
        id = result.getInt(SessionDatabase.ID.getColumnName());
        checkoutId = result.getInt(SessionDatabase.ID_CHECKOUT.getColumnName());
        openTime = result.getObject(SessionDatabase.OPEN_TIME.getColumnName(), LocalDateTime.class);
        closeTime = result.getObject(SessionDatabase.CLOSE_TIME.getColumnName(), LocalDateTime.class);
        status = Status.valueOf(result.getString(SessionDatabase.STATUS.getColumnName()).toUpperCase());
    }

    public int getId() {
        return id;
    }

    public int getCheckoutId() {
        return checkoutId;
    }

}