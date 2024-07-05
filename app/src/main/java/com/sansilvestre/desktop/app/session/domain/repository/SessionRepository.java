package com.sansilvestre.desktop.app.session.domain.repository;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.domain.model.Session;

public  interface SessionRepository {

    Response<Integer> openSession(int checkoutId);
    Response<Void> closeSession(int id);

    Response<Session> getLastActiveSession();

}