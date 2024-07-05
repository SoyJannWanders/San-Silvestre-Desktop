package com.sansilvestre.desktop.app.session.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;

public class CloseSession {

    private final SessionRepository repository;

    public CloseSession(SessionRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int sessionId) {
        return repository.closeSession(sessionId);
    }

}