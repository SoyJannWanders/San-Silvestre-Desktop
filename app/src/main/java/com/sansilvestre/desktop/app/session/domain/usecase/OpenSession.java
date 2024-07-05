package com.sansilvestre.desktop.app.session.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;

public class OpenSession {

    private final SessionRepository repository;

    public OpenSession(SessionRepository repository) {
        this.repository = repository;
    }

    public Response<Integer> execute(int checkoutId) {
        return repository.openSession(checkoutId);
    }

}