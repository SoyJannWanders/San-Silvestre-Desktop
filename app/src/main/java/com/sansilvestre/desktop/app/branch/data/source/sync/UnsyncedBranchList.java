package com.sansilvestre.desktop.app.branch.data.source.sync;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnsyncedBranchList {

    public static List<UnsyncedBranch> valueOf(ResultSet result) throws SQLException {
        List<UnsyncedBranch> unsyncedBranches = new ArrayList<>();
        while (result.next()) {
            unsyncedBranches.add(new UnsyncedBranch(result));
        }
        return unsyncedBranches;
    }

}