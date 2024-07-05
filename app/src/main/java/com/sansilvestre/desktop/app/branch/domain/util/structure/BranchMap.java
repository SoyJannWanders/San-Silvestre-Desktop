package com.sansilvestre.desktop.app.branch.domain.util.structure;

import com.sansilvestre.desktop.app.branch.data.source.BranchDatabase;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BranchMap {

    public static Map<Integer, Branch> valueOf(ResultSet result) throws SQLException {
        Map<Integer, Branch> branches = new ConcurrentHashMap<>();
        while (result.next()) {
            branches.put(result.getInt(BranchDatabase.ID.getColumnName()), new Branch(result));
        }
        return branches;
    }

}