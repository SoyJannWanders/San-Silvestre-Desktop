package com.sansilvestre.desktop.app.session.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;

public class GetSession {

    private final SessionRepository repository;

    public GetSession(SessionRepository repository) {
        this.repository = repository;
    }

    public Response<Session> execute() {
        return repository.getLastActiveSession();
    }

}