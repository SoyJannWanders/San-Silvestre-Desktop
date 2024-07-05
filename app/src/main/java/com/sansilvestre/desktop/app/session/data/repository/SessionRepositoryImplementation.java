package com.sansilvestre.desktop.app.session.data.repository;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.data.source.SessionStorage;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.log.Console;

public class SessionRepositoryImplementation implements SessionRepository {

    private final SessionStorage storage;

    public SessionRepositoryImplementation(SessionStorage storage) {
        this.storage = storage;
    }

    @Override
    public Response<Integer> openSession(int checkoutId) {
        Response<Integer> openSession = storage.openSession(checkoutId);
        openSession.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Integer> success) {
                Console.info(Console.InfoCode.I001, "OK: OpenSession - " + checkoutId);
            }

            @Override
            public void visitFailure(Response.Failure<Integer> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: OpenSession - " + checkoutId);
            }

        });
        return openSession;
    }

    @Override
    public Response<Void> closeSession(int id) {
        Response<Void> closeSession = storage.closeSession(id);
        closeSession.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: CloseSession - " + id);
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: CloseSession - " + id);
            }

        });
        return closeSession;
    }

    @Override
    public Response<Session> getLastActiveSession() {
        Response<Session> response = storage.getLastActiveSession();
        if (response instanceof Response.Success<Session>) {

        } else {
            Console.warn(Console.WarnCode.W001, "Error al obtener la lista de sesiones activas.");
        }
        return response;
    }
}