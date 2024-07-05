package com.sansilvestre.desktop.app.branch.domain.util.structure;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchList {

    public static List<Branch> of(ResultSet result) throws SQLException {
        List<Branch> list = new ArrayList<>();
        while (result.next()) {
            list.add(new Branch(result));
        }
        return list;
    }

}