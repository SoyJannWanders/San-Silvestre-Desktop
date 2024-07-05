package com.sansilvestre.desktop.app.auth.domain.repository;

import com.sansilvestre.desktop.app.util.data.response.Response;

public interface AuthRepository {

    Response<String> signIn(int id, String password);

}