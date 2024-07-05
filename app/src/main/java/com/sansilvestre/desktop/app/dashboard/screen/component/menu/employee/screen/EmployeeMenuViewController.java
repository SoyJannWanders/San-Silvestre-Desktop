package com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen;

import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;

public interface EmployeeMenuViewController {

    void setSession(Session session);

    void setShift(Shift shift);

}