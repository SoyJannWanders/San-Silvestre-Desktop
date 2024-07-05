package com.sansilvestre.desktop.app.auth.domain.repository;

import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.response.Response;

public interface AuthRepository {

    Response<User> signIn(int id, String password);

}