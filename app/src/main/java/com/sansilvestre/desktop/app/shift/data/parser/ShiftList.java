package com.sansilvestre.desktop.app.shift.data.parser;

import com.sansilvestre.desktop.app.shift.domain.model.Shift;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShiftList {

    public static List<Shift> of(ResultSet result) throws Exception {
        List<Shift> shiftList = new ArrayList<>();
        while (result.next()) {
            shiftList.add(Shift.of(result));
        }
        return shiftList;
    }

}